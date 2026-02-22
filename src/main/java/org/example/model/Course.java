package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String program;

    public Course(String courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public void setProgram(String program) {
        this.program = program;
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
    public void display () {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}

