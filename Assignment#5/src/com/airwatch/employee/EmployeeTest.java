package com.airwatch.employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ABhat on 14 Aug 2014 - 14/08/14.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        final ConcurrentHashMap<Integer, Employee> employeeConcurrentHashMap = new ConcurrentHashMap<Integer, Employee>();
        System.out.println("ConcurrentHashMap : ");
        Thread thread[] = new Thread[40];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            final int finalI = i + 1;
            final Employee emp = new Employee();
            emp.setAge(random.nextInt(100));
            emp.setSalary(random.nextFloat()*1000);
            emp.setName("Ajay " + finalI);
            emp.setEmployeeID("E00" + finalI);
            thread[i] = new Thread(() -> {
                employeeConcurrentHashMap.put(finalI, emp);
                System.out.print(employeeConcurrentHashMap.size() + " ");
            });
            thread[i].start();
        }

        // for (int i = 0; i < 30; i++)
        //     try {
        //         thread[i].join();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //   System.out.println("\nHashMap : ");
        //   final HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        //   for (int i = 0; i < 30; i++) {
        //       final Employee emp = new Employee();
        //       final int finalI = i + 1;
        //       new Thread(() -> {
        //           employeeHashMap.put(finalI, emp);
        //           System.out.print(employeeHashMap.size() + " ");
        //       }).start();

        //  Real :  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        //With join
        //  ConcurrentHashMap :
        //          1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 19 21 22 23 24 25 26 27 28 29 30
        //  HashMap :
        //          1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        //Without join
        //   ConcurrentHashMap :
        //           1 2 3 4 5 6 7 9 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 25 26 25 27 28
        //   HashMap :
        //           29 30 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30

        for (int key : employeeConcurrentHashMap.keySet()) {
            Employee employee = employeeConcurrentHashMap.get(key);
            System.out.println("===============");
            JAXBContext context = null;
            try {
                context = JAXBContext.newInstance(Employee.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(employee, System.out);
                Annotation[] annotations = employee.getClass().getAnnotations();
                for (Annotation an : annotations) {
                    Retention retention = an.annotationType().getAnnotation(Retention.class);
                    RetentionPolicy retentionPolicy = retention.value();
                    System.out.println(retentionPolicy.toString());
                }

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}