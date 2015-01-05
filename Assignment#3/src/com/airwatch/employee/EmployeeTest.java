package com.airwatch.employee;

import java.util.*;

/**
 * Created by ABhat on 12 Aug 2014 - 12/08/14.
 */
public class EmployeeTest {
    public static void main(String[] args) {

        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (o1.getSalary() > o2.getSalary()) ? -1 : (o1.getSalary() < o2.getSalary()) ? 1 : 0;
            }
        };

        Employee e1 = new Employee("Ajay", 2350, 30);
        Employee e2 = new Employee("Lazim", 3520, 31);
        Employee e3 = new Employee("Piya", 3520, 32);
        Employee e4 = new Employee("Ammu", 6320, 63);
        Employee e5 = new Employee("Sharon", 5120, 30);
        Employee e6 = new Developer("Jubin", 3320, 34);
        Employee e7 = new Developer("Sruthi", 2701, 31);
        Employee e8 = new Developer("Priyanka", 2604, 21);
        Developer e9 = new Developer("Tobit", 2021, 32);
        Developer e10 = new Developer("Arif", 2434, 32);
        Employee e11 = new QAEngineer("Alan", 2032, 31);
        Employee e12 = new QAEngineer("JK", 2704, 30);
        Employee e13 = new QAEngineer("Deepu", 2601, 29);
        QAEngineer e14 = new QAEngineer("Girish", 5202, 30);
        QAEngineer e15 = new QAEngineer("Athma", 2022, 31);
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);
        employeeList.add(e8);
        employeeList.add(e9);
        employeeList.add(e10);
        employeeList.add(e11);
        employeeList.add(e12);
        employeeList.add(e13);
        employeeList.add(e14);
        employeeList.add(e15);


        //Creating a HashMap to store the details of employees
        HashMap<Integer, List<String>> employeeMap = new HashMap<Integer, List<String>>();

        for (Employee e : employeeList) {
            List<String> names;
            int key = e.getAge();
            if (employeeMap.containsKey(key)) {
                names = employeeMap.get(key);
                names.add(e.getName());
            } else {
                names = new ArrayList<String>();
                names.add(e.getName());
            }
            employeeMap.put(key, names);
        }


        //Testing HashMap with null values
//        employeeMap.get(null);//exception thrown
        System.out.println(employeeMap.get(3944));//null o/p
  //      employeeMap.put(21, null); //causes more than half of the values in the HashMap to become nulled + exception on reading below

        //Displaying the HashMap
        for (int key : employeeMap.keySet()) {
            List<String> names = employeeMap.get(key);
            System.out.println(key + " : " + Arrays.toString(names.toArray()));
        }


        //Using iterator to iterate over the employees list
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (employee.getSalary() < 2500)
                employeeIterator.remove();
        }
        Collections.sort(employeeList, employeeComparator);

        //Displaying list of employees with salary over 2500
        for (Employee e : employeeList) {
            System.out.println(e);
        }


        //TreeSet test
        Employee emp1 = new Employee("ABC", 20000, 20);
        Employee emp2 = new Employee("ABC", 20000, 20);
        Employee emp3 = new Employee("ABC", 20000, 20);
        Employee emp4 = new Employee("ABC", 20000, 20);
        Employee emp5 = new Employee("ABC", 20000, 20);


        TreeSet<Employee> employeeTreeSet = new TreeSet<Employee>();

        employeeTreeSet.add(emp1);
        employeeTreeSet.add(emp2);
        employeeTreeSet.add(emp3);
        employeeTreeSet.add(emp4);
        employeeTreeSet.add(emp5);

/*
        For employee not done as comparable
        Exception in thread "main" java.lang.ClassCastException: com.airwatch.employee.Employee cannot be cast to java.lang.Comparable
         */
    }
}
