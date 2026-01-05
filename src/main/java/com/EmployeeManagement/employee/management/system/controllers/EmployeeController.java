package com.EmployeeManagement.employee.management.system.controllers;


import com.EmployeeManagement.employee.management.system.entities.EmployeeEntity;
import com.EmployeeManagement.employee.management.system.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    //  Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // API to create a new employee
    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity savedEmployee = employeeService.createEmployee(employeeEntity);
        return ResponseEntity.ok(savedEmployee);
    }

    // API to get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok) // return employee if found
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 if not found
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeEntity employee) {

        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
