package org.pdp.service;


import org.pdp.dao.EmployeeDAO;
import org.pdp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {

        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public Boolean insertEmployee(Employee employee) {
        Boolean insertedEmployee = employeeDAO.insertEmployee(employee);
        return insertedEmployee;
    }

    @Override
    public Boolean deleteEmployee(Employee employee) {
        Boolean deletedEmployee = employeeDAO.deleteEmployee(employee);
        return deletedEmployee;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        Boolean updatedEmployee = employeeDAO.updateEmployee(employee);
        return updatedEmployee;
    }
}
