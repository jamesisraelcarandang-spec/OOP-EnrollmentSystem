package org.example.services;

import org.example.model.Department;

public interface DepartmentService {
    void addDepartment(Department department);

    void addDepartmentService(Department department);
    Department findDepartmentById(String id);
}
