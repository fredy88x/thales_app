package com.thales.app.infraestructure.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DummyEmployeeListResponse {

  private String status;
  private List<DummyEmployee> data;
  private String message;
}
