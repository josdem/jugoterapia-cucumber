package com.jos.dem.jugoterapia.cucumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class JugoterapiaCucumberApplication {

  @Value("${server.url}")
  private String serverUrl;

  @Bean
  public WebClient webClient() {
    return WebClient.create(serverUrl);
  }

	public static void main(String[] args) {
		SpringApplication.run(JugoterapiaCucumberApplication.class, args);
	}

}
