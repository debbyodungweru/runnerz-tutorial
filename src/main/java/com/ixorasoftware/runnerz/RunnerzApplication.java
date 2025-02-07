package com.ixorasoftware.runnerz;

import com.ixorasoftware.runnerz.user.UserRestClient;
import com.ixorasoftware.runnerz.user.User;
import com.ixorasoftware.runnerz.run.Run;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRestClient client)
	{
		return args -> {
			List<User> users = client.findAll();

            client.findAll();
			System.out.println(users);

			User user = client.findById(1);
			System.out.println(user);

			Run run = client.findRun(1);
			System.out.println(run);
		};
	}

}
