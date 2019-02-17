/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

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

public class BeverageByKeywordTest extends BeverageIntegrationTest {

  private String keyword;
  private Beverage beverage;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @When("^I request beverage by id \"([^\"]*)\"$")
  public void shouldRequestBeverageById(Long id) throws Exception {
    log.info("Running: I request beverage by keyword at " + new Date());
    this.keyword = keyword;
    beverage = getByKeyword(keyword).block();
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
