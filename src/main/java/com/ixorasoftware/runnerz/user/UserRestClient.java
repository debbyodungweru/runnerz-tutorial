package com.ixorasoftware.runnerz.user;

import com.ixorasoftware.runnerz.run.Run;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient
{
	private final RestClient restClient;
	private final RestClient anotherRestClient;

	public UserRestClient(RestClient.Builder builder)
	{
		this.restClient = builder
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.build();

		this.anotherRestClient = builder
				.baseUrl("http://localhost:8080/api/")
				.build();
	}

	public List<User> findAll()
	{
		return restClient.get()
				.uri("/users")
				.retrieve()
				.body(new ParameterizedTypeReference<>() {});

	}

	public User findById(Integer id)
	{
		return restClient.get()
				.uri("/users/{id}", id)
				.retrieve()
				.body(User.class);
	}

	public Run findRun(Integer id)
	{
		return anotherRestClient.get()
				.uri("/runs/{id}", id)
				.retrieve()
				.body(Run.class);
	}
}
