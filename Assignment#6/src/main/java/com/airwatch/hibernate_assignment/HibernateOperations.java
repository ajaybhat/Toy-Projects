package com.airwatch.hibernate_assignment;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */
public class HibernateOperations {
    private SessionFactory sessionFactory;

    public static void main(String[] args) {

        HibernateOperations hibernateOperations = new HibernateOperations();
        hibernateOperations.doCRUDOperations();
    }

    private void doCRUDOperations() {
        //     sessionFactory = new AnnotationConfiguration().configure().
        //           addAnnotatedClass(Employee.class).addAnnotatedClass(Certificate.class).buildSessionFactory();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        int empIDs[] = new int[4];

        empIDs[0] = addEmployee("Ajay", "Bhat", 90000);
        empIDs[1] = addEmployee("Aparna", "Manu", 20000);
        empIDs[2] = addEmployee("Priyanka", "Suresh", 440000);
        empIDs[3] = addEmployee("Jubin", "Benny", 92000);


    }

    private Integer addEmployee(String firstName, String lastName, int salary) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setSalary(salary);

//            session.persist(employee);
            transaction.commit();
            return (Integer) session.save(employee);
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }


    private void addCertificate(String name, int employeeID) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Certificate certificate = new Certificate();
            certificate.setName(name);
            certificate.setEmployeeID(employeeID);
            session.save(certificate);
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
