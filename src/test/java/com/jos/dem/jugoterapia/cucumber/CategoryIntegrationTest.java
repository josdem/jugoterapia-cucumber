package com.jos.dem.jugoterapia.cucumber;

import com.jos.dem.jugoterapia.cucumber.model.Category;
import com.jos.dem.jugoterapia.cucumber.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import reactor.core.publisher.Flux;

@ContextConfiguration(classes = JugoterapiaCucumberApplication.class)
@WebAppConfiguration
public class CategoryIntegrationTest {

  @Autowired
  private CategoryService categoryService;

  Flux<Category> getCategories() throws Exception {
    return categoryService.getAll();
  }

  Flux<Category> getByLanguage(String language) throws Exception {
    return categoryService.getByLanguage(language);
  }

}
