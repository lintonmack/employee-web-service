package org.pdp.controllers;

import org.pdp.model.Employee;
import org.pdp.service.EmployeeService;
import org.pdp.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(ViewNames.EMPLOYEES)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/")
    public List<Employee> home() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }
}
