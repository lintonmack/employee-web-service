package org.pdp.controllers;

import org.pdp.model.Employee;
import org.pdp.service.EmployeeService;
import org.pdp.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
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
        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // ToDo: Add Unit tests for the above an look to add an integration test
    // ToDo: Add functionality to get single employee by id from the records
    // ToDo: Add tests to support
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
