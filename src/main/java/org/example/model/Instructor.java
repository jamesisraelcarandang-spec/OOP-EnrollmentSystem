package org.example.model;

public class Instructor extends Person {
    int instructorID;
    String instructorName;
    String department;

    public Instructor() {

    }

    public Instructor(int instructorID, String instructorName, String department) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.department = department;



    }
    public void display () {
        System.out.printf("Instructor ID: %d %n" , instructorID );
        System.out.printf("Instructor Name: %s %n" , instructorName);
        System.out.printf("Instructor Department: %s %n" , department);

    }

    @Override
    public void mainTask() {
        System.out.println("I teach");
    }
}
