package com.example.api.repository;

import com.example.api.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1, "John", "Smith", "johnsmith@gmail.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymond", "alexraymond@gmail.com"));
        DATABASE.add(new Employee(3, "David", "Cameron", "david@gmail.com"));
    }
    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }
    // Get employees
    public List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    }

    // Get 1 employee
    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(emp ->id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    }

    // Update employee
    public void updateEmployee(Employee employee) {
        Employee employee1 = findById(employee.getId());
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
    }
    // Delete employee
    public Boolean deleteById(Integer id) {
        Employee employee = DATABASE
                .stream()
                .filter(emp ->id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }
}
