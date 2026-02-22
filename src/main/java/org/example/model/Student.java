package org.example.model;

import java.util.Scanner;

public class Student {
    static Scanner scan = new Scanner(System.in);
    private String studentID;
    private String studentName;
    private String program;

    public Student(String id, String studentName, String program) {
        this.studentID = id;
        this.studentName = studentName;
        this.program = program;
    }

    public String getStudentID() {
    return studentID;
    }
    public String getStudentName() {
    return studentName;
    }
    public String getProgram() {
    return program;
    }
    public void setStudentName(String studentName) {
    this.studentName = studentName;
    }
    public void setStudentID(String studentID) {
    this.studentID = studentID;
    }
    public void setProgram(String program) {
    this.program = program;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}

