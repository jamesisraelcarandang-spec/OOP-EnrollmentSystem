package org.example.services;

import org.example.model.Department;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRegistrationService implements DepartmentReg{
    List<Department> departmentList;
    List<Instructor> instructorList;

    public DepartmentRegistrationService() {
        this.departmentList = new ArrayList<>();
        this.instructorList = new ArrayList<>();

    }

    public void saveDepartment(String)
}
