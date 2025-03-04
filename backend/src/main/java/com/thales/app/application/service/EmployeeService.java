package com.thales.app.application.service;

import com.thales.app.domain.model.Employee;
import com.thales.app.domain.port.out.DummyApiService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class EmployeeService {

  private final DummyApiService dummyApiService;

  public EmployeeService(DummyApiService dummyApiService) {
    this.dummyApiService = dummyApiService;
  }

  public Optional<Employee> getEmployeeById(Integer id) {
    return Optional.ofNullable(id)
        .flatMap(dummyApiService::getEmployeeById)
        .map(employee -> {
          employee.setEmployeeYearSalary(calculateYearSalary(employee.getEmployeeSalary()));
          return employee;
        });
  }

  public List<Employee> getEmployees() {
    return dummyApiService.getEmployees()
        .stream()
        .map(employee -> {
          employee.setEmployeeYearSalary(calculateYearSalary(employee.getEmployeeSalary()));
          return employee;
        }).toList();
  }

  private BigDecimal calculateYearSalary(BigDecimal salary) {
    return salary.multiply(BigDecimal.valueOf(12));
  }
}
