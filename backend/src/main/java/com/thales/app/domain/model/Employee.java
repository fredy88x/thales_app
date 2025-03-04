package com.thales.app.domain.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

  private Integer id;
  private String employeeName;
  private BigDecimal employeeSalary;
  private Integer employeeAge;
  private String profileImage;
  private BigDecimal employeeYearSalary;
}
