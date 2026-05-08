package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionID;
    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private List <Student> enrolledStudents;

    public String getSectionID() {
        return sectionID;
    }

    public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Section (String sectionID, String sectionName, int maxCapacity) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();

    }
    public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }
    public boolean enrollStudent (Student student) {
        if (isFull()) return false;
        enrolledStudents.add(student);
        return true;
    }

    public Section() {
        super();
    }

    @Override
    public String toString() {
        return "Section{id='" + sectionID + "', name='" + sectionName +
                "', capacity=" + enrolledStudents.size() + "/" + maxCapacity + "}";
    }
}
