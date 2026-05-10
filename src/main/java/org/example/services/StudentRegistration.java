package org.example.services;

import org.example.exceptions.DuplicateIdException;
import org.example.model.Student;

public interface StudentRegistration {
    void saveStudent(Student student) throws DuplicateIdException;
    void displayAllStudent();
    void update(Student student);
    String removeStudent(Student student);
}
