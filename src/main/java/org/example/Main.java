package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.services.CourseRegistration;
import org.example.services.StudentRegistration;

public class Main {
    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();

        Student student1 = new Student("Information Technology");
        Instructor instructor1 = new Instructor();
        studentRegistration.saveStudent(student1);

        System.out.println("Student");
        studentRegistration.displayAllStudent();

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