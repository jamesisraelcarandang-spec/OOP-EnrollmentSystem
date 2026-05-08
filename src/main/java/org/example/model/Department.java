package org.example.model;

import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private List<Instructor>instructorList;

    public Department(String departmentId, String departmentName, List<Instructor>instructorList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", instructorList=" + instructorList +
                '}';
    }
}
