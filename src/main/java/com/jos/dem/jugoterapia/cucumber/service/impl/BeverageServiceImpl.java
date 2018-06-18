package com.jos.dem.jugoterapia.cucumber.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;
import com.jos.dem.jugoterapia.cucumber.service.BeverageService;

@Service
public class BeverageServiceImpl implements BeverageService {

  @Autowired
  private WebClient client;

  public Mono<Beverage> getById(Long id){
    return client.get()
      .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
      .retrieve()
      .bodyToMono(Beverage.class);
  }

}
