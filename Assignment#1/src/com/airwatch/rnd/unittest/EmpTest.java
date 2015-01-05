/**
 * Created by ABhat on 11 Aug 2014 - 11/08/14.
 */
package com.airwatch.rnd.unittest;

import com.airwatch.rnd.Developer;
import com.airwatch.rnd.Employee;
import com.airwatch.rnd.Manager;
import com.airwatch.rnd.QAEngineer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmpTest {
    public static void main(String[] args) throws Exception {
        Employee employee[] = new Employee[10];
        Manager manager = new Manager();

        float sum = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Salary of Manager : ");
        float managerSalary = Float.parseFloat(reader.readLine());
        sum += managerSalary;
        for (int i = 0; i < 5; i++) {
            Employee emp = new Developer();
            System.out.println("Salary of Employee #" + (i + 1) + ":");
            float sal = Float.parseFloat(reader.readLine());
            emp.setSalary(sal);
            emp.setAge(i % 5 * 10);
            manager.setEmployee(i, emp);
        }
        for (int i = 5; i < 10; i++) {
            Employee emp = new QAEngineer();
            System.out.println("Salary of Employee #" + (i + 1) + ":");
            float sal = Float.parseFloat(reader.readLine());
            emp.setSalary(sal);
            emp.setAge(i % 10 * 5);
            s.equalsIgnoreCase("f");
            manager.setEmployee(i, emp);
        }

        for (int i = 0; i < 10; i++) {
            Employee emp = manager.getEmployee(i);
            sum += emp.getSalary();
        }

        System.out.println("Sum of all salaries : " + sum);
    }
}
