package com.jos.dem.jugoterapia.cucumber.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import javax.annotation.PostConstruct;

import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;
import com.jos.dem.jugoterapia.cucumber.service.BeverageService;

@Service
public class BeverageServiceImpl implements BeverageService {

  @Value("${server.url}")
  private String serverUrl;
  private WebClient client;

  @PostConstruct
  public void setup(){
    client = WebClient.create(serverUrl);
  }

  public Mono<Beverage> getById(Long id){
    return client.get()
      .uri("/beverages/{id}", id).accept(APPLICATION_JSON)
      .retrieve()
      .bodyToMono(Beverage.class);
  }

}
