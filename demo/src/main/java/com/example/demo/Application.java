package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.demo.run.Location;
import com.example.demo.run.Run;
import com.example.demo.user.User;
import com.example.demo.user.UserHttpClient;
import com.example.demo.user.UserRestClient;
import com.example.demo.run.JdbcClientRunRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class Application {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

	@Bean // Bean is a method that returns an object that Spring manages
	CommandLineRunner runner(UserHttpClient client) {
		return args -> {
			User user = client.findById(1);
			System.out.println(user);
		};
	}
}
