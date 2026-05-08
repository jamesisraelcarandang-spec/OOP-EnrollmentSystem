package org.example;

import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.services.TuitionFeePayment;

public class Main {
    public static void main(String[] args) {
//        StudentRegistration studentRegistration = new StudentRegistration();
//        CourseRegistration courseRegistration = new CourseRegistration();
//
//        Student student1 = new Student("123", "John Doe", "Information Technology");
//        studentRegistration.saveStudent(student1);
//
//        System.out.println("Student");
//        studentRegistration.displayAllStudent();
//
//        Student updatedStudent1 = new Student("123", "Jane Smith", "Computer Engineering");
//        studentRegistration.update(updatedStudent1);
//
//        System.out.println("New Student");
//        studentRegistration.displayAllStudent();
//
//        studentRegistration.removeStudent(student1);
//        System.out.println("Current Student");
//        studentRegistration.displayAllStudent();
//
//        Course course1 = new Course("01","Information Technology", "Cite");
//        courseRegistration.save(course1);
//
//        System.out.println("Courses");
//        courseRegistration.displayAll();
//
//        Course updatedCourse1 = new Course("01", "Computer Engineering", "Cite");
//        courseRegistration.updateCourse(updatedCourse1);
//
//        courseRegistration.removeCourse(course1);
//        System.out.println("Current Courses");
//        courseRegistration.displayAll();

//        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();
//        System.out.println(tuitionFeePayment.calculateTuitionFee(3, 10.0));
        Student student = new Student();
        student.mainTask();

        Instructor instructor = new Instructor();
        instructor.mainTask();

        Department department = new Department();










    }

}