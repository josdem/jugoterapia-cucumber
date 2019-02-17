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

import java.util.Date;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import reactor.core.publisher.Flux;

import com.jos.dem.jugoterapia.cucumber.model.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryTest extends CategoryIntegrationTest {

  private List<Category> categories;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @When("I request default categories")
  public void shouldRequestCategories() throws Exception {
    log.info("Running: I request categories at " + new Date());
    categories = getCategories()
      .collectList()
      .block();
  }

  @Then("I validate default categories")
  public void shouldCallCategories() throws Exception {
    log.info("Running: I validate categories at " + new Date());

    assertTrue(categories.size() == 4,  () -> "Should be 4 categories");
    assertAll("category",
      () -> assertTrue(categories.contains(new Category(1L, "Curativos")), "Should contains Curativos category"),
      () -> assertTrue(categories.contains(new Category(2L, "Energizantes")), "Should contains Energizantes category"),
      () -> assertTrue(categories.contains(new Category(3L, "Saludables")), "Should contains Saludables category"),
      () -> assertTrue(categories.contains(new Category(4L, "Estimulantes")), "Should contains Estimulantes category")
    );
  }

}
