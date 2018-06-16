package com.jos.dem.jugoterapia.cucumber.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;
import com.jos.dem.jugoterapia.cucumber.service.BeverageService;

@Service
public class BeverageServiceImpl implements BeverageService {

  private WebClient client = WebClient.create("http://jugoterapia.josdem.io/jugoterapia-server");

  public Mono<Beverage> getBeverage(Long id){
    return client.get()
      .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
      .retrieve()
      .bodyToMono(Beverage.class);
  }

}
