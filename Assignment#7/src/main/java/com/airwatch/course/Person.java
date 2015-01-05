package com.airwatch.course;

import java.util.List;

/**
 * Created by ABhat on 19 Aug 2014 - 19/08/14.
 */
public class Person {
    private String name;
    private String address;
    List<String> phoneNumberList;

    public Person(String name, String address, List<String> phones) {
        this.name = name;
        this.address = address;
        phoneNumberList = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }
}
