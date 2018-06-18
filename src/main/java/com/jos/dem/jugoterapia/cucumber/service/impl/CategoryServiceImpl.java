package com.jos.dem.jugoterapia.cucumber.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.jugoterapia.cucumber.model.Category;
import com.jos.dem.jugoterapia.cucumber.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private WebClient client;

  public Flux<Category> getAll() {
    return client.get()
      .uri("/categories/").accept(APPLICATION_JSON)
      .retrieve()
      .bodyToFlux(Category.class);
  }

}
