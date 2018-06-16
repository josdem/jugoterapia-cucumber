package com.jos.dem.jugoterapia.cucumber.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beverage {

  private Long id;
  private String name;
  private String ingredients;
  private String recipe;

}
