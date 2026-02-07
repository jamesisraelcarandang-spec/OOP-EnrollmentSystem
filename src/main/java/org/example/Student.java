package org.example;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

        public Student () {
         }

    public void setStudentID(int studentID) {
            this.studentID = studentID;
    }
    public void setStudentName(String studentName) {
            this.studentName = studentName;
    }
    public void setProgram(String program) {
            this.program = program;
    }
    public int getStudentID() {
            return studentID;
    }
    public String getStudentName() {
            return studentName;
    }
    public String getProgram() {
            return program;
    }
    public void display() {
        System.out.println("Student ID:" + getStudentID());
        System.out.println("Student Name:" + getStudentName());
        System.out.println("Program:" + getProgram());
    }
}

