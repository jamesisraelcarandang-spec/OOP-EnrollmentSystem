package org.example.services;

import org.example.exceptions.SectionFullException;
import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;

public interface EnrollmentService {
    void enrollStudentInSection(Student student, Section section) throws SectionFullException;
    void viewDepartmentHierarchy(Department department);
}
