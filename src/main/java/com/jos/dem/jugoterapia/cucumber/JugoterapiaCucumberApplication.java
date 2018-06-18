package com.jos.dem.jugoterapia.cucumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class JugoterapiaCucumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(JugoterapiaCucumberApplication.class, args);
	}

}
