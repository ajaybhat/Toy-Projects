package com.airwatch.course;

import java.util.List;

/**
 * Created by ABhat on 19 Aug 2014 - 19/08/14.
 */
public class Teacher extends Person {

    public Teacher(String name, String address, List<String> phones, String expertise) {
        super(name, address, phones);
        this.expertise = expertise;
    }

    private String expertise;

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        String summary = "Teacher\n========\nName : " + this.getName() + "\nAddress : " + getAddress()
                + "\nExpertise : " + getExpertise();
        return summary;
    }
}
