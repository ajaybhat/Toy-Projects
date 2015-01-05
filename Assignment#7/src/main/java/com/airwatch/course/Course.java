package com.airwatch.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABhat on 19 Aug 2014 - 19/08/14.
 */
public class Course {
    private String subject;

    @Autowired
    @Qualifier("teacher_ml")
    private Teacher teacherOfCourse;

    @Autowired
    List<Student> studentList = new ArrayList<Student>(25);

    public Course(){
    }

    public Course(Teacher teacher, List<Student> list) {
        teacherOfCourse = teacher;
        studentList = list;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacherOfCourse() {
        return teacherOfCourse;
    }

    public void setTeacherOfCourse(Teacher teacherOfCourse) {
        this.teacherOfCourse = teacherOfCourse;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void printSummary() {

        System.out.println("Course : " + subject);
        System.out.println(teacherOfCourse.toString());
        for (Student student : studentList)
            System.out.println(student.toString());

    }

    public void initializeCourse() {
        System.out.println("Initialized course");
    }

    public void destroyCourse() {
        System.out.println("Destroyed course");
    }
}
