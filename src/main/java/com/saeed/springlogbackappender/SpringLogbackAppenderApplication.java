package com.saeed.springlogbackappender;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLogbackAppenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLogbackAppenderApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(HelloService helloService) {
		return args -> {
			helloService.sayHello();
		};
	}

}
