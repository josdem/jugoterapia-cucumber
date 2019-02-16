package com.jos.dem.jugoterapia.cucumber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

import java.util.Date;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeverageTest extends BeverageIntegrationTest {

  private Long id;
  private Beverage beverage;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @When("^I request beverage by id \"([^\"]*)\"$")
  public void shouldRequestBeverageById(Long id) throws Exception {
    log.info("Running: I request beverage by id at " + new Date());
    this.id = id;
    beverage = getBeverageById(id).block();
  }

  @Then("I validate beverage data$")
  public void shouldGetBeverageById() throws Exception {
    log.info("Running: I validate beverage data at " + new Date());

    assertAll("beverage",
        () -> assertEquals(id, beverage.getId(), "Should be 66 id"),
        () -> assertEquals("Jugo nutritivo (Zanahoria)", beverage.getName(), "Should get complete beverage name"),
        () -> assertEquals("4 Zanahorias,1 Tallo de apío,1 Pera,5 hojas de espinacas", beverage.getIngredients(), "Should get complete ingredients"),
        () -> assertTrue(beverage.getRecipe().length() > 50, "Recipe must be larger than 50 characters")
    );
  }

}