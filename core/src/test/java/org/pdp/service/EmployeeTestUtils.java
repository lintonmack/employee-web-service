package org.pdp.service;

import org.pdp.model.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeTestUtils {

    public static Boolean compareEmployee(Employee actual, Employee expected) {
        if (
                (actual.getName() == expected.getName()) &&
                (actual.getGender() == expected.getGender()) &&
                (actual.getAddress() == expected.getAddress()) &&
                (actual.getPostcode() == expected.getPostcode()) &&
                (actual.getDepartment() == expected.getDepartment()) &&
                (actual.getEmail() == expected.getEmail()) &&
                (actual.getSalary() == expected.getSalary()) &&
                (actual.getEmployeeNumber() == expected.getEmployeeNumber())) {
            return true;
        }
        return false;
    }

    public static Boolean compareEmployees(List<Employee> actual, List<Employee> expected) {
        Collections.sort(actual, (a1, a2) -> {
            return a1.getEmployeeNumber() - a2.getEmployeeNumber();
        });

        Collections.sort(expected, (a1, a2) -> {
            return a1.getEmployeeNumber() - a2.getEmployeeNumber();
        });

        for (int i = 0; i < actual.size(); i++) {
            if (!compareEmployee(actual.get(i), expected.get(i))) {
                return false;
            }
        }
        return true;
    }
}
