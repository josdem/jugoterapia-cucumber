package com.jos.dem.jugoterapia.cucumber.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import javax.annotation.PostConstruct;

import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.PropertySource;

import com.jos.dem.jugoterapia.cucumber.model.Category;
import com.jos.dem.jugoterapia.cucumber.service.CategoryService;

@Service
@PropertySource("classpath:application.properties")
public class CategoryServiceImpl implements CategoryService {

  @Value("${server.url}")
  private String serverBasedUrl;
  private WebClient client;

  @PostConstruct
  public void setup(){
    client = WebClient.create(serverBasedUrl);
  }

  public Flux<Category> getAll() {
    return client.get()
      .uri("/categories/").accept(APPLICATION_JSON)
      .retrieve()
      .bodyToFlux(Category.class);
  }

}
