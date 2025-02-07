package com.ixorasoftware.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserRestClient client)
//	{
//		return args -> {
//			List<User> users = client.findAll();
//
//            client.findAll();
//			System.out.println(users);
//
//			User user = client.findById(1);
//			System.out.println(user);
//
//			Run run = client.findRun(1);
//			System.out.println(run);
//		};
//	}

}
