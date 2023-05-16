package org.pdp.controller;

import lombok.extern.slf4j.Slf4j;
import org.pdp.model.Employee;
import org.pdp.service.EmployeeService;
import org.pdp.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(ViewNames.EMPLOYEES)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(ViewNames.EMPLOYEE)
    public ResponseEntity<Employee> getEmployee(@RequestParam String id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value=ViewNames.EMPLOYEE, consumes = {"application/json"})
    public ResponseEntity<String> insertEmployee(@RequestBody Employee employee) {
        Boolean hasInserted = employeeService.insertEmployee(employee);
        if (!hasInserted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added to datastore");
    }

    @DeleteMapping(value=ViewNames.EMPLOYEE, consumes = {"application/json"})
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee) {
        Boolean hasDeleted = employeeService.deleteEmployee(employee);
        if (!hasDeleted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Employee Removed from datastore");
    }

    // ToDo: Add Unit tests for the above an look to add an integration test
    // ToDo: Add remainder of CRUD methods and add tests to support
    // ToDo: Add MongoDB connection
    // ToDo: Add Integration tests
    // ToDo: Add API key integration
    // ToDo: Add React integration


//    @GetMapping("/")
//    public List<Employee> home() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return employees;
//    }
}
