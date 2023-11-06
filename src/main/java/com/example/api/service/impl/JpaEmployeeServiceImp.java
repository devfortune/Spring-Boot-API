package com.example.api.service.impl;

import com.example.api.domain.Employee;
import com.example.api.repository.JpaEmployeeRepository;
import com.example.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "MySQLEmployeeService")
public class JpaEmployeeServiceImp implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee) {
        jpaEmployeeRepository.save(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
