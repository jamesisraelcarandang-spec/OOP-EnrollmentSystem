package org.example.services;

import org.example.model.Department;
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
    public void addDepartmentService(Department department) {

    }

    @Override
    public Department findDepartmentById(String id) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equals(id)) {
                return d;
            }
        }
        System.out.println(" Error: Department ID " + id + " not found.");
        return null;
    }
}
