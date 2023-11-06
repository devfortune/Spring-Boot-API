package com.example.api.service.impl;

import com.example.api.domain.Employee;
import com.example.api.repository.InMemoryEmployeeRepository;
import com.example.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "InMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
