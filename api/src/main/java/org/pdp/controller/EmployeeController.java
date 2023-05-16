package org.pdp.controller;

import org.pdp.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeController {
    public ResponseEntity<List<Employee>> getAllEmployees();
    public ResponseEntity<Employee> getEmployee(@RequestParam String id);
    public ResponseEntity<String> insertEmployee(@RequestBody Employee employee);
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee);
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee);


}
