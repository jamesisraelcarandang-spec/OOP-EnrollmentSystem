package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Student student = new Student();
//        student.setStudentID(0001);
//        student.setStudentName("John Doe");
//        student.setProgram("Information Technology");
//
//
//        Course course = new Course();
//        course.setCourseID(00001);
//        course.setProgram("Information technology");
//        course.setCourseName("Integrative Programming");
//
//        course.display();
//        student.display();

        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("James" , 99);
        students.add(student1);

        System.out.println(students.get(0));
        System.out.println(students.get(0).getStudentAge());

        students.get(0).setStudentName("Aso");
        System.out.println(students.get(0).getStudentName());

        students.remove(0);



    }

}