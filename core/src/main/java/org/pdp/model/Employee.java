package org.pdp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Person {
    private int employeeNumber;
    private String department;
    private float salary;
    private String email;

    public Employee(String name, String gender, String address, String postcode, int employeeNumber, String department, float salary, String email) {
        super(name, gender, address, postcode);
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }


//    public Employee(String name, String gender, String address, String postcode, int employeeNumber) {
//        super(name, gender, address, postcode);
//        this.employeeNumber = employeeNumber;
//    }
}
