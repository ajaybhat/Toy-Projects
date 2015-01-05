package com.airwatch.course;

import java.util.List;

/**
 * Created by ABhat on 19 Aug 2014 - 19/08/14.
 */
public class Student extends Person {


    private boolean hasScholarship;

    public Student(String name, String address, List<String> phones, boolean hasScholarship) {
        super(name, address, phones);
        this.hasScholarship = hasScholarship;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    @Override
    public String toString() {
        String summary = "Student\n=========\nName : " + getName() + "\nAddress : " + getAddress() + "\nHas scholarship : " + ((hasScholarship) ? "Yes" : "No");
        return summary;
    }
}
