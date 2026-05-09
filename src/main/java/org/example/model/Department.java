package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private List<Section>sections;
    private List<Instructor>instructorList;

    public Department() {
        this.sections = new ArrayList<>();
        this.instructorList = new ArrayList<>();
    }
    public Department(String departmentId, String departmentName, List<Instructor>instructorList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.sections = new ArrayList<>();
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
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
