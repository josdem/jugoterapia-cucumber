package com.jos.dem.jugoterapia.cucumber;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@ContextConfiguration(classes = JugoterapiaCucumberApplication.class)
@WebAppConfiguration
public class BeverageIntegrationTest {

  @Autowired
  private WebClient webClient;

  Mono<Beverage> getBeverageById(Long id) throws Exception {
    return webClient.get().uri("").retrieve()
      .bodyToMono(Beverage.class);
  }

}
