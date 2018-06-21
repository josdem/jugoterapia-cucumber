package com.jos.dem.jugoterapia.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.jugoterapia.cucumber.model.Category;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class CategoryGetTest extends CategoryIntegrationTest {

  private List<Category> categories;

  @Then("^the client receives categories$")
  public void shouldCallCategories() throws Exception {
    Flux<Category> result = assertTrue(getCategories().map(Category::id).sum() == 10L,  () -> "Sum should be 10");
  }

}
