package org.example;

import org.example.model.*;
import org.example.services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Initialize Services
        StudentRegistrationIMPL studService = new StudentRegistrationIMPL();
        CourseRegistrationIMPL courseService = new CourseRegistrationIMPL();
        InstructorServiceIMPL instService = new InstructorServiceIMPL();
        EnrollmentServiceIMPL enrollService = new EnrollmentServiceIMPL();
        TuitionFeePayment tuitionService = new TuitionFeePayment();

        // Master Controller
        CampusRegistrar registrar = new CampusRegistrar(
                studService, courseService, instService, enrollService, tuitionService
        );

        // Interactive Setup
        System.out.println("=== University Enrollment System ===");


        System.out.print("Enter Department ID: "); String deptId = scan.nextLine();
        System.out.print("Enter Department Name: "); String deptName = scan.nextLine();
        Department dept = new Department();
        dept.setDepartmentId(deptId);
        dept.setDepartmentName(deptName);

        System.out.print("Enter Section ID: "); String secId = scan.nextLine();
        System.out.print("Enter Section Name: "); String secName = scan.nextLine();
        System.out.print("Enter Max Capacity: "); int cap = scan.nextInt(); scan.nextLine();
        Section section = new Section(secId, secName, cap);
        dept.getSections().add(section);

        System.out.print("Enter Instructor ID: "); String instId = scan.nextLine();
        System.out.print("Enter Instructor Name: "); String instName = scan.nextLine();
        System.out.print("Enter Instructor Department: "); String instDept = scan.nextLine();
        Instructor instructor = new Instructor(instId, instName, instDept);
        registrar.addInstructor(instructor);
        section.setInstructor(instructor);

        System.out.println("\nSetup Complete! Starting system...");

        while (true) {
            System.out.println("\n---------- MAIN MENU ----------");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Instructor Management");
            System.out.println("4. Enroll Student in Section");
            System.out.println("5. View Institutional Hierarchy");
            System.out.println("6. Tuition and Payment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.println("\n--- Student Management ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. View All Students");
                    System.out.println("3. Update Student");
                    System.out.println("4. Remove Student");
                    System.out.print("Choice: ");
                    int sOpt = scan.nextInt(); scan.nextLine();

                    if (sOpt == 1) {
                        System.out.print("Student ID: "); String sid = scan.nextLine();
                        System.out.print("Name: "); String sname = scan.nextLine();
                        System.out.print("Program: "); String sprog = scan.nextLine();
                        registrar.saveStudent(new Student(sprog, sid, sname));
                        System.out.println("Student registered.");
                    } else if (sOpt == 2) {
                        registrar.displayAllStudent();
                    } else if (sOpt == 3) {
                        System.out.print("Student ID to update: "); String uid = scan.nextLine();
                        System.out.print("New Name: "); String uname = scan.nextLine();
                        System.out.print("New Program: "); String uprog = scan.nextLine();
                        registrar.update(new Student(uprog, uid, uname));
                        System.out.println("Student updated.");
                    } else if (sOpt == 4) {
                        System.out.print("Student ID to remove: "); String rid = scan.nextLine();
                        String result = registrar.removeStudent(new Student("", rid, ""));
                        System.out.println(result);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Course Management ---");
                    System.out.println("1. Add Course");
                    System.out.println("2. View All Courses");
                    System.out.println("3. Update Course");
                    System.out.println("4. Remove Course");
                    System.out.print("Choice: ");
                    int cOpt = scan.nextInt(); scan.nextLine();

                    if (cOpt == 1) {
                        System.out.print("Course ID: "); String cid = scan.nextLine();
                        System.out.print("Course Name: "); String cn = scan.nextLine();
                        System.out.print("Program: "); String cp = scan.nextLine();
                        registrar.save(new Course(cid, cn, cp));
                        System.out.println("Course added.");
                    } else if (cOpt == 2) {
                        registrar.displayAll();
                    } else if (cOpt == 3) {
                        System.out.print("Course ID to update: "); String ucid = scan.nextLine();
                        System.out.print("New Course Name: "); String ucn = scan.nextLine();
                        System.out.print("Program: "); String ucp = scan.nextLine();
                        registrar.updateCourse(new Course(ucid, ucn, ucp));
                        System.out.println("Course updated.");
                    } else if (cOpt == 4) {
                        System.out.print("Course ID to remove: "); String rcid = scan.nextLine();
                        String result = registrar.removeCourse(new Course(rcid, "", ""));
                        System.out.println(result);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Instructor Management ---");
                    System.out.println("1. Add Instructor");
                    System.out.println("2. View All Instructors");
                    System.out.println("3. View Instructor Details");
                    System.out.println("4. Remove Instructor");
                    System.out.print("Choice: ");
                    int iOpt = scan.nextInt(); scan.nextLine();

                    if (iOpt == 1) {
                        System.out.print("Instructor ID: "); String iid = scan.nextLine();
                        System.out.print("Name: "); String iname = scan.nextLine();
                        System.out.print("Department: "); String idept = scan.nextLine();
                        registrar.addInstructor(new Instructor(iid, iname, idept));
                    } else if (iOpt == 2) {
                        registrar.getAllInstructor();
                    } else if (iOpt == 3) {
                        System.out.print("Enter Instructor ID: "); String did = scan.nextLine();
                        registrar.getInstructorDetails(did);
                    } else if (iOpt == 4) {
                        System.out.print("Instructor ID to remove: "); String rid = scan.nextLine();
                        registrar.removeInstructor(rid);
                    }
                    break;

                case 4:
                    System.out.print("Student ID: "); String eid = scan.nextLine();
                    System.out.print("Student Name: "); String ename = scan.nextLine();
                    registrar.enroll(new Student("BSIT", eid, ename), section);
                    break;

                case 5:
                    registrar.showHierarchy(dept);
                    break;

                case 6:
                    System.out.println("\n--- Tuition Management ---");
                    System.out.println("1. Calculate Tuition Fee");
                    System.out.println("2. Make Payment");
                    System.out.println("3. View Remaining Balance");
                    System.out.print("Choice: ");
                    int tOpt = scan.nextInt(); scan.nextLine();

                    if (tOpt == 1) {
                        System.out.print("Number of units: "); int units = scan.nextInt();
                        System.out.print("Discount rate (0 if none): "); double disc = scan.nextDouble();
                        scan.nextLine();
                        double fee = registrar.calculateTuition(units, disc);
                        System.out.println("Total Tuition Fee: " + fee);
                    } else if (tOpt == 2) {
                        System.out.print("Amount to pay: "); double pay = scan.nextDouble();
                        scan.nextLine();
                        registrar.payTuition(pay);
                        System.out.println("Remaining Balance: " + registrar.getBalance());
                    } else if (tOpt == 3) {
                        System.out.println("Remaining Balance: " + registrar.getBalance());
                    }
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("System closed. Goodbye!");
        scan.close();
    }
}
