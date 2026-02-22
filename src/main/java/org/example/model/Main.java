package org.example.model;

import org.example.services.CourseRegistration;
import org.example.services.StudentRegistration;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();

        Student student1 = new Student("123", "John Doe", "Information Technology");
        studentRegistration.saveStudent(student1);

        System.out.println("Student");
        studentRegistration.displayAllStudent();

        Student updatedStudent1 = new Student("123", "Jane Smith", "Computer Engineering");
        studentRegistration.update(updatedStudent1);

        System.out.println("New Student");
        studentRegistration.displayAllStudent();

        studentRegistration.removeStudent(student1);
        System.out.println("Current Student");
        studentRegistration.displayAllStudent();

        Course course1 = new Course("01","Information Technology", "Cite");
        courseRegistration.save(course1);

        System.out.println("Courses");
        courseRegistration.displayAll();

        Course updatedCourse1 = new Course("01", "Computer Enginnering", "Cite");
        courseRegistration.updateCourse(updatedCourse1);

        courseRegistration.removeCourse(course1);
        System.out.println("Current Courses");
        courseRegistration.displayAll();








    }

}