package com.airwatch.employee;


public class QAEngineer extends Employee {
    private String knownAutomationTool;

    public QAEngineer(String name, int salary, int age) {
        super(name, salary, age);
    }

    public String getKnownAutomationTool() {
        return knownAutomationTool;
    }

    public void setKnownAutomationTool(String knownAutomationTool) {
        this.knownAutomationTool = knownAutomationTool;
    }
}
