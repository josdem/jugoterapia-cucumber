package com.jos.dem.jugoterapia.cucumber.service;

import reactor.core.publisher.Mono;
import com.jos.dem.jugoterapia.cucumber.model.Beverage;

public interface BeverageService {

  Mono<Beverage> getById(Long id);

}
