package com.solarflare.ems.service.impl;

import com.solarflare.ems.dto.EmployeeDto;
import com.solarflare.ems.entity.Employee;
import com.solarflare.ems.exceptions.ResourceNotFoundException;
import com.solarflare.ems.mapper.EmployeeMapper;
import com.solarflare.ems.repository.EmployeeRepository;
import com.solarflare.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updatedEmployee(Long employeeId,EmployeeDto updatedEmployeeDto) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee does not exists with id: " + employeeId)
        );
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee does not exists with id: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }
}
