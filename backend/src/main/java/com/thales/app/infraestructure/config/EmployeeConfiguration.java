package com.thales.app.infraestructure.config;

import com.thales.app.application.service.EmployeeService;
import com.thales.app.domain.port.out.DummyApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {

  @Bean
  public EmployeeService employeeService(DummyApiService dummyApiService) {
    return new EmployeeService(dummyApiService);
  }
}
