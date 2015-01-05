/**
 * Created by ABhat on 11 Aug 2014 - 11/08/14.
 */
package com.airwatch.rnd;
public class Manager extends Employee{
    String name;
    int age;
    float salary;
    Employee employeeList[] = new Employee[10];

    public void setEmployee(int index,Employee employee)
    {
        employeeList[index] = employee;
    }
    public Employee getEmployee(int index)
    {
        return employeeList[index];
    }
}
