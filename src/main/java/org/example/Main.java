package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setStudentID(0001);
        student.setStudentName("John Doe");
        student.setProgram("Information Technology");


        Course course = new Course();
        course.setCourseID(00001);
        course.setProgram("Information technology");
        course.setCourseName("Integrative Programming");

        course.display();
        student.display();
    }

}