package org.example.services;

import org.example.model.Student;

public interface StudentRegistration {
    void saveStudent(Student student);
    void displayAllStudent();
    void update(Student student);
    String removeStudent(Student student);
}
