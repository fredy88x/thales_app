package com.thales.app.domain.port.out;

import com.thales.app.domain.model.Employee;
import java.util.List;
import java.util.Optional;

public interface DummyApiService {

  Optional<Employee> getEmployeeById(Integer id);

  List<Employee> getEmployees();
}
