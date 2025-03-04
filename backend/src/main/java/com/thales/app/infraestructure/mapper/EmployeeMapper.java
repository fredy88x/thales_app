package com.thales.app.infraestructure.mapper;

import com.thales.app.domain.model.Employee;
import com.thales.app.infraestructure.dtos.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  EmployeeDto employeeToEmployeeDto(Employee employee);
}
