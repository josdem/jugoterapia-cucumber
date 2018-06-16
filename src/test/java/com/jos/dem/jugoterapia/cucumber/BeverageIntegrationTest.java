package com.jos.dem.jugoterapia.cucumber;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;
import com.jos.dem.jugoterapia.cucumber.service.BeverageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import reactor.core.publisher.Mono;

@ContextConfiguration(classes = JugoterapiaCucumberApplication.class)
@WebAppConfiguration
public class BeverageIntegrationTest {

  @Autowired
  private BeverageService beverageService;

  Mono<Beverage> getBeverageById(Long id) throws Exception {
    return beverageService.getById(id);
  }

}
