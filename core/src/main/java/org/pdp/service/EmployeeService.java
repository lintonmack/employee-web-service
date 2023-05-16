package org.pdp.service;

import org.pdp.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(String id);
    public Boolean insertEmployee(Employee employee);
    public Boolean deleteEmployee(Employee employee);
}
