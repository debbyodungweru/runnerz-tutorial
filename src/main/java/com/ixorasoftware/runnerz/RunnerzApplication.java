package com.ixorasoftware.runnerz;

import com.ixorasoftware.runnerz.run.Run;
import com.ixorasoftware.runnerz.user.User;
import com.ixorasoftware.runnerz.user.UserHttpClient;
import com.ixorasoftware.runnerz.user.UserRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	UserHttpClient userHttpClient()
	{
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

	@Bean
	CommandLineRunner runner(UserRestClient client, UserHttpClient userHttpClient)
	{
		return args -> {
//			List<User> users = c
//
//          client.findAll();
//			System.out.println(users);
//
//			User user = client.findById(1);
//			System.out.println(user);

//			Run run = client.findRun(1);
//			System.out.println(run);

			System.out.println(userHttpClient.findById(1));
		};
	}

}
