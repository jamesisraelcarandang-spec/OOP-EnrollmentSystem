package org.example.services;

import org.example.exceptions.DuplicateIdException;
import org.example.model.Instructor;
import org.example.model.Section;

public interface InstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIdException;
    void assignInstructorToSection(Instructor instructor, Section section);
    void getInstructorDetails(String instructorID);
    void updateInstructor(Instructor instructor);
    void removeInstructor(String instructorID);
    void getAllInstructors();
    int getInstructorCount();
}
