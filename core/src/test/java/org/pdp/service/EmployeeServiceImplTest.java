package org.pdp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pdp.CoreMain;
import org.pdp.dao.EmployeeDAO;
import org.pdp.dao.EmployeeDAOImpl;
import org.pdp.data.EmployeeRepository;
import org.pdp.data.EmployeeRepositoryImpl;
import org.pdp.model.Employee;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = CoreMain.class)
public class EmployeeServiceImplTest {

    private EmployeeService employeeService;
    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void testInit() {
        employeeRepository = new EmployeeRepositoryImpl();
        employeeDAO = new EmployeeDAOImpl(employeeRepository);
        employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @DisplayName("Get All Employees()")
    @Test
    void getAllEmployees() {
        List<Employee> expected =  new ArrayList<>();
        expected.add(
                new Employee("Linton", "male", "1 Fake Street", "m1 3ay", 1, "Tech", 20000.0f, "linton@linton.com" ));
        expected.add(
                new Employee("Bob", "male", "2 Fake Street", "m1 3ay", 2, "PR", 23000.0f, "notlinton@linton.com"));

        List<Employee> actual = employeeService.getAllEmployees();
        assertEquals(actual.size(), expected.size());
        assertTrue(EmployeeTestUtils.compareEmployees(actual, expected));
    }


}
