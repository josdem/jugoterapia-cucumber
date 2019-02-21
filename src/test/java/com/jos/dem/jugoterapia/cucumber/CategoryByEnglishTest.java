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

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import reactor.core.publisher.Flux;

import com.jos.dem.jugoterapia.cucumber.model.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryByEnglishTest extends CategoryIntegrationTest {

  private List<Category> categories;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @When("^I request categories i18n \"([^\"]*)\"$")
  public void shouldRequestEnglishCategories(String language) throws Exception {
    log.info("Running: I request categories at " + new Date());
    categories = getByLanguage(language)
      .collectList()
      .block();
  }

  @Then("I validate English categories")
  public void shouldValidateEnglishCategories() throws Exception {
    log.info("Running: I validate categories at " + new Date());

    assertTrue(categories.size() == 4,  () -> "Should be 4 categories");

    assertAll("category",
      () -> assertTrue(categories.contains(new Category(5L, "Healing")), () -> "Should contains Healing category"),
      () -> assertTrue(categories.contains(new Category(6L, "Energy")), () -> "Should contains Energy category"),
      () -> assertTrue(categories.contains(new Category(7L, "Healthy")), () -> "Should contains Healthy category"),
      () -> assertTrue(categories.contains(new Category(8L, "Boost")), () -> "Should contains Boost category")
    );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}
