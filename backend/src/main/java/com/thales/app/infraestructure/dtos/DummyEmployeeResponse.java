package com.thales.app.infraestructure.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DummyEmployeeResponse {

  private String status;
  private DummyEmployee data;
  private String message;
}
