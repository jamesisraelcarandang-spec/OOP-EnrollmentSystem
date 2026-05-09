package org.example.services;

import org.example.model.Department;
import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceIMPL implements DepartmentService {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void addDepartment(Department department) {
        departmentList.add(department);
        System.out.println("Department Registered: " + department.getDepartmentName());
    }

    @Override
    public Department findDepartmentById(String id) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equals(id)) {
                return d;
            }
        }
        System.out.println("Error: Department ID " + id + " not found.");
        return null;
    }

    @Override
    public void addSectionToDepartment(String departmentId, Section section) {
        Department dept = findDepartmentById(departmentId);
        if (dept != null) {
            dept.getSections().add(section);
            System.out.println("Section " + section.getSectionName() + " added to " + dept.getDepartmentName());
        }
    }

    @Override
    public void displayAllDepartments() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department d : departmentList) {
                System.out.println(d);
            }
        }
    }
}
