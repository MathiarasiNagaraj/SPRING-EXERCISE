package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class TestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(TestApplication.class, args);
		UserServiceInterface service=ctx.getBean("userservice",UserServiceInterface.class);

	}

}
