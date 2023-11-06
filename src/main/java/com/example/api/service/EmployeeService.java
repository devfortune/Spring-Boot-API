package com.example.api.service;

import com.example.api.domain.Employee;

import java.util.List;

public interface EmployeeService {
    // Save an employee
    Employee addEmployee(Employee employee);
    // Get employees
    List<Employee> getAllEmployees();

    // Get 1 employee
    Employee findById(Integer id);

    // Update employee
    void updateEmployee(Employee employee);
    // Delete employee
    Boolean deleteById(Integer id);

}
