package com.thales.app.infraestructure.mapper;

import com.thales.app.domain.model.Employee;
import com.thales.app.infraestructure.dtos.DummyEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DummyEmployeeMapper {

  DummyEmployeeMapper INSTANCE = Mappers.getMapper(DummyEmployeeMapper.class);

  @Mapping(target = "employeeYearSalary", ignore = true)
  Employee dummyEmployeeToEmployee(DummyEmployee dummyEmployee);
}
