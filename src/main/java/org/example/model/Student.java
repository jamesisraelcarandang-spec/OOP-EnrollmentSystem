package org.example.model;

import java.util.Scanner;

public class Student extends Person {
    private String program;

    public Student() {

    }

    public Student(String program, String personID, String name) {
        super(personID, name);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    @Override public void mainTask() {
        System.out.println("I sleep");
    }

    @Override
    public String toString() {
        return "Student{" +
                "program='" + program + '\'' +
                '}';
    }
}


