package com.jos.dem.jugoterapia.cucumber;

import static org.junit.Assert.assertEquals;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Mono;

public class BeverageGetByAttributeTest extends BeverageIntegrationTest {

  private Beverage beverage;

  @When("^the client wants a beverage$")
  public void shouldCallBeverageById() throws Exception {
    Mono<Beverage> result = getBeverageById(35L);
    beverage = result.block();
  }

  @Then("^the client receives a beverage by id$")
  public void shouldGetBeverageById() throws Exception {
    assertEquals(35L, beverage.getId());
  }

}
