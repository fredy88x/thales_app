package com.thales.app.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.thales.app.domain.model.Employee;
import com.thales.app.domain.port.out.DummyApiService;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

  @Mock
  private DummyApiService dummyApiService;

  @InjectMocks
  private EmployeeService employeeService;

  @Test
  void getEmployeeById() {
    // Given
    Integer id = 1;
    Employee employee = new Employee();
    employee.setId(id);
    employee.setEmployeeName("John Doe");
    employee.setEmployeeSalary(BigDecimal.valueOf(1000));
    employee.setEmployeeYearSalary(BigDecimal.valueOf(12000));

    when(dummyApiService.getEmployeeById(id)).thenReturn(Optional.of(employee));

    Optional<Employee> result = employeeService.getEmployeeById(id);

    assertTrue(result.isPresent());
    assertEquals(employee, result.get());
  }

}