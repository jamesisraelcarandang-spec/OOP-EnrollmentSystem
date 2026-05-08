package org.example.model;

public class Instructor extends Person {
    private String department;

    public Instructor() {

    }

    public Instructor(String personID, String name, String department) {
       super(personID, name);
       this.department =department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void mainTask() {
        System.out.println("Teaching and Managing Courses");
    }
}
