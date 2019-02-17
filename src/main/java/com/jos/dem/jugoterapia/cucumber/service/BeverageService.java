package com.jos.dem.jugoterapia.cucumber.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

public interface BeverageService {

  Mono<Beverage> getById(Long id);
  Flux<Beverage> getByKeyword(String keyword);

}
