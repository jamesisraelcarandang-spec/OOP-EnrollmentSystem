package org.example.model;

public class Student extends Person {
    private String program;
    private String scholarshipType;

    public Student() {

    }

    public Student(String program, String personID, String name) {
        super(personID, name);
        this.program = program;
        this.scholarshipType = "None";
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    @Override public void mainTask() {
        System.out.println("I sleep");
    }

    @Override
    public String toString() {
        return "Student: " + getName() + " (ID: " + getPersonID() + ", Program: " + program + ", Scholarship: " + scholarshipType + ")";
    }

}
