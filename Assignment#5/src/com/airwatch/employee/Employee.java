package com.airwatch.employee;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ABhat on 14 Aug 2014 - 14/08/14.
 */
@XmlRootElement
@XmlType(propOrder = {"name", "age", "salary"})
public class Employee {
    private String name;
    private int age;
    private float salary;
    private String employeeID;

    public Employee() {
        name = "Ajay";
        age = 22;
        salary = 500;
    }

    @XmlAttribute
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name : " + name + " Age : " + age + " Salary : " + salary;
    }
}
