package com.jos.dem.jugoterapia.cucumber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Mono;

public class BeverageGetByAttributeTest extends BeverageIntegrationTest {

  @Then("^the client receives a beverage by id$")
  public void shouldGetBeverageById() throws Exception {
    Beverage beverage = getBeverageById(35L).block();

    assertAll("beverage",
        () -> assertEquals(new Long(35L), beverage.getId()),
        () -> assertEquals("Jugo nutritivo (Zanahoria)", beverage.getName()),
        () -> assertEquals("4 Zanahorias,1 Tallo de apío,1 Pera,5 hojas de espinacas", beverage.getIngredients()),
        () -> assertTrue(beverage.getRecipe().length() > 50));
  }

}
