package com.jos.dem.jugoterapia.cucumber;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.jos.dem.jugoterapia.cucumber.model.Category;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class CategoryGetTest extends CategoryIntegrationTest {

  private List<Category> categories;

  @When("^the client wants category list$")
  public void shouldCallCategories() throws Exception {
    Flux<Category> result = getCategories();
    categories = result.collectList().block();
  }

  @Then("^the client receives categories$")
  public void shouldGetCategories() throws Exception {
    assertEquals(4 , categories.size());
    assertTrue(categories.contains(new Category(1L, "Curativos")));
    assertTrue(categories.contains(new Category(2L, "Energizantes")));
    assertTrue(categories.contains(new Category(3L, "Saludables")));
    assertTrue(categories.contains(new Category(4L, "Estimulantes")));
  }

}
