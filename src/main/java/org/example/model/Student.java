package org.example.model;

import java.util.Scanner;

public class Student extends Person {
    static Scanner scan = new Scanner(System.in);
    private String program;

    public Student(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "program='" + program + '\'' +
                '}';
    }
}

