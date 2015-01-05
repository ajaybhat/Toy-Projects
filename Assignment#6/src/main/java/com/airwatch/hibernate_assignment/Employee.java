package com.airwatch.hibernate_assignment;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
    @Id
@GeneratedValue
    @Column(name = "employeeID")
    private int employeeID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
