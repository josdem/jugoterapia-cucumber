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

package com.jos.dem.jugoterapia.cucumber;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;
import com.jos.dem.jugoterapia.cucumber.service.BeverageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = JugoterapiaCucumberApplication.class)
@WebAppConfiguration
public class BeverageIntegrationTest {

  @Autowired
  private BeverageService beverageService;

  Mono<Beverage> getById(Long id) throws Exception {
    return beverageService.getById(id);
  }

  Flux<Beverage> getByKeyword(String keyword) throws Exception {
    return beverageService.getByKeyword(keyword);
  }

}
