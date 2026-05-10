package org.example.services;

import org.example.exceptions.SectionFullException;
import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;

public class EnrollmentServiceIMPL implements EnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException("Enrollment Failed: Section " + section.getSectionName() + " is already Full.");
        }
        section.getEnrolledStudents().add(student);
        System.out.println("Success: " + student.getName() + " has been enrolled in " + section.getSectionName());
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("Institutional Hierarchy ");
        System.out.println("Department: " + department.getDepartmentName());
        for (Section section : department.getSections()) {
            System.out.println("Section " + section.getSectionName() + " (Instructor: "
                    + (section.getInstructor() != null ? section.getInstructor().getName() : "TBA") + ")");

            for (Student s : section.getEnrolledStudents()) {
                System.out.println(" Student " + s.getName() + " (" + s.getPersonID() + ")");
            }
        }
    }
}
