package com.example.api.resource;

import com.example.api.domain.Employee;
import com.example.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeResource {
    @Qualifier(value = "MySQLEmployeeService")
    private final EmployeeService employeeService; //dependency injection

    public EmployeeResource(@Qualifier(value = "MySQLEmployeeService")EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        //employee.setId(employeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable("id") Integer id) {
        return null;
    }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
