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
    List<Category> categories = getCategories()
      .collectList()
      .block();

    assertTrue(categories.size() == 4,  () -> "Should be 4 categories");
    assertTrue(categories.contains(new Category(1L, "Curativos")), () -> "Should contains Curativos category");
    assertTrue(categories.contains(new Category(2L, "Energizantes")), () -> "Should contains Energizantes category");
    assertTrue(categories.contains(new Category(3L, "Saludables")), () -> "Should contains Saludables category");
    assertTrue(categories.contains(new Category(4L, "Estimulantes")), () -> "Should contains Estimulantes category");
  }

}
