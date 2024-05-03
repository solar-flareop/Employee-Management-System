package com.solarflare.ems.controller;

import com.solarflare.ems.dto.EmployeeDto;
import com.solarflare.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //RESTAPI

    //Create employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }

    //GetAllEmployees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeList);
    }

    //update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employee = employeeService.updatedEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    //Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
