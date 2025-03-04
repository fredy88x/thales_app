package com.thales.app.infraestructure.controller;

import com.thales.app.application.service.EmployeeService;
import com.thales.app.infraestructure.mapper.EmployeeMapper;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployee(@PathVariable Integer id) {
    return employeeService.getEmployeeById(id)
        .map(EmployeeMapper.INSTANCE::employeeToEmployeeDto)
        .map(employeeDto -> new ResponseEntity<>(employeeDto, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getEmployees() {
    return Optional.of(employeeService.getEmployees()
            .stream()
            .filter(Objects::nonNull)
            .map(EmployeeMapper.INSTANCE::employeeToEmployeeDto)
            .toList())
        .filter(list -> !list.isEmpty())
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.noContent().build());
  }
}
