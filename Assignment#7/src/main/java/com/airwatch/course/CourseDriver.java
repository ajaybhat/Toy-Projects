package com.airwatch.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABhat on 19 Aug 2014 - 19/08/14.
 */
public class CourseDriver {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        String address[] = {"Bangalore", "Kollam", "Trivandrum", "Kolkata", "Delhi"};
        List<Student> studentList = new ArrayList<Student>();
        Student student;
        for (int i = 0; i < 10; i++) {
            student = (Student) context.getBean("student" + (i + 1));
            student.setHasScholarship(i % 2 == 0 ? true : false);
            student.setName("Student #" + (i + 1));
            student.setAddress(address[i % 5]);
            studentList.add(student);
        }
        Course course = (Course) context.getBean("course");
        course.setSubject("Artificial Intelligence");
        course.setStudentList(studentList);

        Teacher teacher = course.getTeacherOfCourse();
        teacher.setAddress("Bangalore");

        course.printSummary();

        ((ConfigurableApplicationContext) context).close();
    }
}

