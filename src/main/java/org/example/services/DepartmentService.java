package org.example.services;

import org.example.model.Department;
import org.example.model.Section;

public interface DepartmentService {
    void addDepartment(Department department);
    Department findDepartmentById(String id);
    void addSectionToDepartment(String departmentId, Section section);
    void displayAllDepartments();
}
