package org.example;

import org.example.model.*;
import org.example.services.*;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static CampusRegistrar registrar;

    public static void main(String[] args) {
        StudentRegistrationIMPL studService = new StudentRegistrationIMPL();
        CourseRegistrationIMPL courseService = new CourseRegistrationIMPL();
        InstructorServiceIMPL instService = new InstructorServiceIMPL();
        EnrollmentServiceIMPL enrollService = new EnrollmentServiceIMPL();
        TuitionFeePayment tuitionService = new TuitionFeePayment();

        registrar = new CampusRegistrar(studService, courseService, instService, enrollService, tuitionService);

        // Interactive Setup
        System.out.println("=== University Enrollment System ===");
        System.out.print("Department ID: "); String dId = scan.nextLine();
        System.out.print("Department Name: "); String dName = scan.nextLine();
        Department dept = new Department();
        dept.setDepartmentId(dId);
        dept.setDepartmentName(dName);

        System.out.print("Section ID: "); String sId = scan.nextLine();
        System.out.print("Section Name: "); String sName = scan.nextLine();
        System.out.print("Max Capacity: "); int cap = scan.nextInt(); scan.nextLine();
        Section section = new Section(sId, sName, cap);
        dept.getSections().add(section);

        System.out.println("\nSetup Complete!");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Students  2. Courses");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int c = scan.nextInt(); scan.nextLine();
            if (c == 0) break;

            switch (c) {
                case 1: studentMenu(); break;
                case 2: courseMenu(); break;
                default: System.out.println("Invalid.");
            }
        }
        System.out.println("Goodbye!");
    }

    private static void studentMenu() {
        System.out.println("1.Add 2.ViewAll 3.Update 4.Remove");
        int o = scan.nextInt(); scan.nextLine();
        if (o == 1) {
            System.out.print("ID: "); String id = scan.nextLine();
            System.out.print("Name: "); String n = scan.nextLine();
            System.out.print("Program: "); String p = scan.nextLine();
            registrar.saveStudent(new Student(p, id, n));
        } else if (o == 2) registrar.displayAllStudent();
        else if (o == 3) {
            System.out.print("ID: "); String id = scan.nextLine();
            System.out.print("New Name: "); String n = scan.nextLine();
            System.out.print("New Program: "); String p = scan.nextLine();
            registrar.update(new Student(p, id, n));
        } else if (o == 4) {
            System.out.print("ID: "); String id = scan.nextLine();
            System.out.println(registrar.removeStudent(new Student("", id, "")));
        }
    }

    private static void courseMenu() {
        System.out.println("1.Add 2.ViewAll 3.Update 4.Remove");
        int o = scan.nextInt(); scan.nextLine();
        if (o == 1) {
            System.out.print("Course ID: "); String id = scan.nextLine();
            System.out.print("Name: "); String n = scan.nextLine();
            System.out.print("Program: "); String p = scan.nextLine();
            registrar.save(new Course(id, n, p));
        } else if (o == 2) registrar.displayAll();
        else if (o == 3) {
            System.out.print("Course ID: "); String id = scan.nextLine();
            System.out.print("New Name: "); String n = scan.nextLine();
            System.out.print("Program: "); String p = scan.nextLine();
            registrar.updateCourse(new Course(id, n, p));
        } else if (o == 4) {
            System.out.print("Course ID: "); String id = scan.nextLine();
            System.out.println(registrar.removeCourse(new Course(id, "", "")));
        }
    }
}
