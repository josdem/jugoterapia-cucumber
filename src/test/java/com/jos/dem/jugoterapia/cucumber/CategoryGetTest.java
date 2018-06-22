package com.jos.dem.jugoterapia.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jos.dem.jugoterapia.cucumber.model.Category;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class CategoryGetTest extends CategoryIntegrationTest {

  private List<Category> categories;

  @Then("^the client receives categories$")
  public void shouldCallCategories() throws Exception {
    assertTrue(getCategories()
        .collectList()
        .block()
        .size() == 4,  () -> "Should be 4 categories");
  }

}
