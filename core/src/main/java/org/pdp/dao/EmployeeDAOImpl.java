package org.pdp.dao;

import lombok.extern.slf4j.Slf4j;
import org.pdp.data.EmployeeRepository;
import org.pdp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

@Component
@Slf4j
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDAOImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Connection getDBConnection() {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.getEmployee(Integer.parseInt(employeeId));
    }

    @Override
    public Boolean insertEmployee(Employee employee) {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteEmployee(Employee employee) {
        return employeeRepository.deleteEmployee(employee);
    }

    @Override
    public Boolean checkLoginCredentials(String userName, String password) {
        return null;
    }

    @Override
    public Boolean checkApiKey(String apiKey) {
        return null;
    }
}
