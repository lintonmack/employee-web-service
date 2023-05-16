package org.pdp.data;

import org.pdp.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public Boolean insertEmployee(Employee employee);
    public Boolean deleteEmployee(Employee employee);
}
