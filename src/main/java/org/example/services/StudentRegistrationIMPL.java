package org.example.services;

import org.example.exceptions.DuplicateIdException;
import org.example.model.Student;
import java.util.List;
import java.util.ArrayList;

public class StudentRegistrationIMPL implements StudentRegistration {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void saveStudent(Student student) throws DuplicateIdException {
        for (Student s : studentList) {
            if (s.getPersonID().equals(student.getPersonID())) {
                throw new DuplicateIdException("Student with ID " + student.getPersonID() + " already exists.");
            }
        }
        studentList.add(student);
        System.out.println("Student " + student.getName() + " registered successfully.");
    }

    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.set(i, student);
                System.out.println("Student updated successfully.");
                return;
            }
        }
    }

    @Override
    public String removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.remove(i);
                return "Successfully Deleted";
            }
        }
        return "Error: Student not found";
    }
}
