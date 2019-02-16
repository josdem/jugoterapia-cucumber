package com.jos.dem.jugoterapia.cucumber.service;

import reactor.core.publisher.Flux;
import com.jos.dem.jugoterapia.cucumber.model.Category;

public interface CategoryService {

  Flux<Category> getAll();
  Flux<Category> getByLanguage(String language);

}
