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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jos.dem.jugoterapia.cucumber.model.Beverage;

import java.util.Date;
import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeverageByKeywordTest extends BeverageIntegrationTest {

  private String keyword;
  private List<Beverage> beverages;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @When("^I request beverages by keyword \"([^\"]*)\"$")
  public void shouldRequestBeverageByKeyword(String keyword) throws Exception {
    log.info("Running: I request beverages by keyword at " + new Date());
    this.keyword = keyword;
    beverages = getByKeyword(keyword)
      .collectList()
      .block();
  }

  @Then("I validate beverages is not empty$")
  public void shouldValidateBeveragesNotEmpty() throws Exception {
    log.info("Running: I validate beverages is not empty at " + new Date());
    assertFalse(beverages.isEmpty(),  () -> "Should not be empty");
  }

  @And("I validate a beverage contains \"([^\"]*)\"$")
  public void shouldValidateBeverageContainsIngredient(String ingredient) throws Exception {
    log.info("Running: I validate a beverage contains ingredient at " + new Date());

    Beverage beverage = beverages.stream()
      .filter(b-> b.getIngredients().toLowerCase().contains(ingredient))
      .findAny()
      .orElse(null);

    assertNotNull(beverage,  () -> "Should contain ingredient");
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}
