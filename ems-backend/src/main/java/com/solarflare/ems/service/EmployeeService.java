package com.solarflare.ems.service;

import com.solarflare.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto>getAllEmployees();

    EmployeeDto updatedEmployee(Long employeeId,EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employeeId);
}
