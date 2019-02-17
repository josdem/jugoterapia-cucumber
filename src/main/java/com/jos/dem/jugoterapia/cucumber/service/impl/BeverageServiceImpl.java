/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.jugoterapia.cucumber.service.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

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

  public Flux<Beverage> getByKeyword(String keyword){
    return client.get()
      .uri("/beverages/ingredients/{keyword}", keyword).accept(APPLICATION_JSON)
      .retrieve()
      .bodyToFlux(Beverage.class);
  }

}
