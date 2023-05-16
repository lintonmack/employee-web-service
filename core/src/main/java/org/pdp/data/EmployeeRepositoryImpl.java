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

    @Override
    public Boolean deleteEmployee(Employee employee) {
        Boolean wasRemoved = false;
        try {
            for (Employee emp : this.employees) {
                if (employee.getEmployeeNumber() == emp.getEmployeeNumber()) {
                    this.employees.remove(emp);
                    wasRemoved = true;
                    break;
                }
            }
            log.info(this.employees.toString());
            return wasRemoved;
        } catch (Exception e) {
            log.info("Unable to remove employee from EmployeeRepo");
            return wasRemoved;
        }
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        Boolean wasUpdated = false;
        try {
            for (Employee emp : this.employees) {
                if (employee.getEmployeeNumber() == emp.getEmployeeNumber()) {
                    if (emp.getSalary() != employee.getSalary()) {
                        emp.setSalary(employee.getSalary());
                    }
                    if (emp.getEmail() != employee.getEmail()) {
                        emp.setEmail(employee.getEmail());
                    }
                    if (emp.getName() != employee.getName()) {
                        emp.setName(employee.getName());
                    }
                    if (emp.getDepartment() != employee.getDepartment()) {
                        emp.setDepartment(employee.getDepartment());
                    }
                    if (emp.getGender() != employee.getGender()) {
                        emp.setGender(employee.getGender());
                    }
                    if (emp.getPostcode() != employee.getPostcode()) {
                        emp.setPostcode(employee.getPostcode());
                    }
                    if (emp.getAddress() != employee.getAddress()) {
                        emp.setAddress(employee.getAddress());
                    }

                    wasUpdated = true;
                    break;
                }
            }
            log.info(this.employees.toString());
            return wasUpdated;
        } catch (Exception e) {
            log.info("Unable to remove employee from EmployeeRepo");
            return wasUpdated;
        }
    }
}
