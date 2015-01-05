package com.airwatch.employee;


public class Developer extends Employee {
    private String knownProgrammingLanguage;

    public Developer(String name, int salary, int age) {
        super(name, salary, age);
    }

    public String getKnownProgrammingLanguage() {
        return knownProgrammingLanguage;
    }

    public void setKnownProgrammingLanguage(String knownProgrammingLanguage) {
        this.knownProgrammingLanguage = knownProgrammingLanguage;
    }
}
