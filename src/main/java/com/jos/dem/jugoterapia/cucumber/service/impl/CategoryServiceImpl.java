package com.jos.dem.jugoterapia.cucumber.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.jugoterapia.cucumber.model.Category;
import com.jos.dem.jugoterapia.cucumber.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  private WebClient client = WebClient.create("http://jugoterapia.josdem.io/jugoterapia-server");

  public Flux<Category> getAll() {
    return client.get()
      .uri("/categories/").accept(APPLICATION_JSON)
      .retrieve()
      .bodyToFlux(Category.class);
  }

}
