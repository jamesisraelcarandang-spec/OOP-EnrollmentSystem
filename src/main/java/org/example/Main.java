package org.example;

import org.example.model.*;
import org.example.services.*;
import org.example.exceptions.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StudentRegistrationIMPL studService = new StudentRegistrationIMPL();
        CourseRegistrationIMPL courseService = new CourseRegistrationIMPL();
        InstructorServiceIMPL instService = new InstructorServiceIMPL();
        EnrollmentServiceIMPL enrollService = new EnrollmentServiceIMPL();
        TuitionFeePayment tuitionService = new TuitionFeePayment();
        DepartmentServiceIMPL deptService = new DepartmentServiceIMPL();


        CampusRegistrar registrar = new CampusRegistrar(
                studService, courseService, instService, enrollService, tuitionService, deptService
        );


        System.out.println("=== University Enrollment System ===");


        System.out.print("Enter Department ID: "); String deptId = scan.nextLine();
        System.out.print("Enter Department Name: "); String deptName = scan.nextLine();
        Department dept = new Department();
        dept.setDepartmentId(deptId);
        dept.setDepartmentName(deptName);
        registrar.addDepartment(dept);

        System.out.print("Enter Section ID: "); String secId = scan.nextLine();
        System.out.print("Enter Section Name: "); String secName = scan.nextLine();
        System.out.print("Enter Max Capacity: "); int cap = scan.nextInt(); scan.nextLine();
        Section section = new Section(secId, secName, cap);
        registrar.addSectionToDepartment(deptId, section);

        System.out.print("Enter Instructor ID: "); String instId = scan.nextLine();
        System.out.print("Enter Instructor Name: "); String instName = scan.nextLine();
        System.out.print("Enter Instructor Department: "); String instDept = scan.nextLine();
        Instructor instructor = new Instructor(instId, instName, instDept);
        try {
            registrar.addInstructor(instructor);
        } catch (DuplicateIdException e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
        section.setInstructor(instructor);

        System.out.println("\nSetup Complete! Starting system...");

        while (true) {
            System.out.println("\n---------- MAIN MENU ----------");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Instructor Management");
            System.out.println("4. Section Management");
            System.out.println("5. View Institutional Hierarchy");
            System.out.println("6. Tuition and Payment");
            System.out.println("7. Enroll Student in Section");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.println("\n--- Student Management ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. View All Students");
                    System.out.println("3. Update Student");
                    System.out.println("4. Remove Student");
                    System.out.print("Choice: ");
                    int sOpt;
                    try {
                        sOpt = scan.nextInt(); scan.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scan.nextLine();
                        break;
                    }

                    if (sOpt == 1) {
                        System.out.print("Student ID: "); String sid = scan.nextLine();
                        System.out.print("Name: "); String sname = scan.nextLine();
                        System.out.print("Program: "); String sprog = scan.nextLine();
                        try {
                            registrar.saveStudent(new Student(sprog, sid, sname));
                        } catch (DuplicateIdException e) {
                            System.out.println("Error: " + e.getMessage());
                        }

                    } else if (sOpt == 2) {
                        registrar.displayAllStudent();

                    } else if (sOpt == 3) {
                        System.out.print("Student ID to update: "); String uid = scan.nextLine();
                        System.out.print("New Name: "); String uname = scan.nextLine();
                        System.out.print("New Program: "); String uprog = scan.nextLine();
                        registrar.update(new Student(uprog, uid, uname));

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

                    int cOpt;
                    try {
                        cOpt = scan.nextInt(); scan.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scan.nextLine();
                        break;
                    }

                    if (cOpt == 1) {
                        System.out.print("Course ID: "); String cid = scan.nextLine();
                        System.out.print("Course Name: "); String cn = scan.nextLine();
                        System.out.print("Program: "); String cp = scan.nextLine();
                        try {
                            registrar.save(new Course(cid, cn, cp));
                        } catch (DuplicateIdException e) {
                            System.out.println("Error: " + e.getMessage());
                        }

                    } else if (cOpt == 2) {
                        registrar.displayAll();

                    } else if (cOpt == 3) {
                        System.out.print("Course ID to update: "); String ucid = scan.nextLine();
                        System.out.print("New Course Name: "); String ucn = scan.nextLine();
                        System.out.print("Program: "); String ucp = scan.nextLine();
                        registrar.updateCourse(new Course(ucid, ucn, ucp));

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
                    int iOpt;
                    try {
                        iOpt = scan.nextInt(); scan.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scan.nextLine();
                        break;
                    }


                    if (iOpt == 1) {
                        System.out.print("Instructor ID: "); String iid = scan.nextLine();
                        System.out.print("Name: "); String iname = scan.nextLine();
                        System.out.print("Department: "); String idept = scan.nextLine();
                        try {
                            registrar.addInstructor(new Instructor(iid, iname, idept));
                        } catch (DuplicateIdException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
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
                    System.out.println("\n--- Section Management ---");
                    System.out.println("1. Add Section to Department");
                    System.out.println("2. View All Departments");
                    System.out.print("Choice: ");
                    int secOpt;
                    try {
                        secOpt = scan.nextInt(); scan.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scan.nextLine();
                        break;
                    }


                    if (secOpt == 1) {
                        System.out.print("Department ID: "); String sdId = scan.nextLine();
                        System.out.print("Section ID: "); String newSecId = scan.nextLine();
                        System.out.print("Section Name: "); String newSecName = scan.nextLine();
                        System.out.print("Max Capacity: "); int newCap = scan.nextInt(); scan.nextLine();
                        Section newSection = new Section(newSecId, newSecName, newCap);
                        registrar.addSectionToDepartment(sdId, newSection);
                    } else if (secOpt == 2) {
                        registrar.displayAllDepartments();
                    }
                    break;

                case 5:
                    System.out.print("Department ID: "); String hierDeptId = scan.nextLine();
                    Department hierDept = registrar.findDepartment(hierDeptId);
                    if (hierDept != null) {
                        registrar.showHierarchy(hierDept);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Tuition Management ---");
                    System.out.println("1. Calculate Tuition Fee");
                    System.out.println("2. Calculate with Scholarship");
                    System.out.println("3. Make Payment");
                    System.out.println("4. View Remaining Balance");
                    System.out.print("Choice: ");
                    int tOpt;
                    try {
                        tOpt = scan.nextInt(); scan.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scan.nextLine();
                        break;
                    }

                    if (tOpt == 1) {
                        try {
                            System.out.print("Number of units: "); int units = scan.nextInt();
                            System.out.print("Discount rate (0 if none): "); double disc = scan.nextDouble();
                            scan.nextLine();
                            double fee = registrar.calculateTuition(units, disc);
                            System.out.println("Total Tuition Fee: " + fee);
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scan.nextLine();
                        }
                    } else if (tOpt == 2) {
                        try {
                            System.out.print("Number of units: "); int units = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Scholarship Types:");
                            System.out.println("1. Dean's Lister (25% off)");
                            System.out.println("2. Academic Scholar (50% off)");
                            System.out.println("3. Presidential Scholar (100% off)");
                            System.out.print("Select scholarship: "); int schOpt = scan.nextInt();
                            scan.nextLine();
                            String schType;
                            if (schOpt == 1) schType = "Dean's Lister";
                            else if (schOpt == 2) schType = "Academic Scholar";
                            else if (schOpt == 3) schType = "Presidential Scholar";
                            else { System.out.println("Invalid scholarship."); break; }
                            double fee = tuitionService.applyScholarshipDiscount(schType, units);
                            System.out.println("Scholarship: " + schType);
                            System.out.println("Total Tuition Fee: " + fee);
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scan.nextLine();
                        }
                    } else if (tOpt == 3) {
                        try {
                            System.out.print("Amount to pay: "); double pay = scan.nextDouble();
                            scan.nextLine();
                            registrar.payTuition(pay);
                            System.out.println("Remaining Balance: " + registrar.getBalance());
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scan.nextLine();
                        }
                    } else if (tOpt == 4) {
                        System.out.println("Remaining Balance: " + registrar.getBalance());
                    }
                    break;

                case 7:
                    System.out.print("Student ID: "); String eid = scan.nextLine();
                    System.out.print("Student Name: "); String ename = scan.nextLine();
                    System.out.print("Program: "); String eprog = scan.nextLine();
                    System.out.print("Department ID: "); String enrollDeptId = scan.nextLine();
                    System.out.print("Section ID: "); String enrollSecId = scan.nextLine();
                    Department enrollDept = registrar.findDepartment(enrollDeptId);
                    if (enrollDept != null) {
                        Section targetSection = null;
                        for (Section s : enrollDept.getSections()) {
                            if (s.getSectionID().equals(enrollSecId)) {
                                targetSection = s;
                                break;
                            }
                        }
                        if (targetSection != null) {
                            try {
                                registrar.enroll(new Student(eprog, eid, ename), targetSection);
                            } catch (SectionFullException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Error: Section ID " + enrollSecId + " not found.");
                        }
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
