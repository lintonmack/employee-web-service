package org.pdp.dao;

import org.pdp.model.Employee;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDAO {
    public Connection getDBConnection();
    public List<Employee> getAllEmployees();
    public Employee getEmployee(String employeeId);
    public Boolean insertEmployee(Employee employee);
    public Boolean updateEmployee(Employee employee);
    public Boolean deleteEmployee(Employee employee);
    public Boolean checkLoginCredentials(String userName, String password);
    public Boolean checkApiKey(String apiKey);

}
