package com.thales.app.infraestructure.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EmployeeDto {

  private Integer id;
  private String employeeName;
  private BigDecimal employeeSalary;
  private Integer employeeAge;
  private String profileImage;
  private BigDecimal employeeYearSalary;
}
