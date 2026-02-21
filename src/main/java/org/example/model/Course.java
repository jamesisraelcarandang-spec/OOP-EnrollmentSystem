package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String program;

    public Course() {

    }
    public void setProgram(String program) {
        this.program =program;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getCourseID() {
        return courseID;
    }
    public String getProgram() {
        return program;
    }
    public void display() {
        System.out.println("Course Name:" + getCourseName());
        System.out.println("Course ID" + getCourseID());
        System.out.println("Program:" + getProgram());
    }

}
