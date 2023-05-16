package org.pdp.data;

import lombok.extern.slf4j.Slf4j;
import org.pdp.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private List<Employee> employees;

    public EmployeeRepositoryImpl() {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee("Linton", "male", "1 Fake Street", "m1 3ay", 1, "Tech", 20000.0f, "linton@linton.com" ));
        this.employees.add(new Employee("Bob", "male", "2 Fake Street", "m1 3ay", 2, "PR", 23000.0f, "notlinton@linton.com"));
    }


    @Override
    public List<Employee> getAllEmployees() {
        return this.employees;
    }

    @Override
    public Employee getEmployee(int id) {

        for (Employee employee: employees) {
            if (employee.getEmployeeNumber() == id) {
                return employee;
            }
        }
        return null;
    }
    @Override
    public Boolean insertEmployee(Employee employee) {
        try {
            this.employees.add(employee);
            log.info(this.employees.toString());
            return true;
        } catch (Exception e) {
            log.info("Unable to add employee to EmployeeRepo");
            return false;
        }
    }
}
