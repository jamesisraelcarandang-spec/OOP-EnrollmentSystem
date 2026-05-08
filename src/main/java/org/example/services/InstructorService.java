package org.example.services;

import org.example.model.Instructor;
import org.example.model.Section;
public interface InstructorService {

    void addInstructor(Instructor instructor);
    void assignInstructorToSection(Instructor instructor, Section section);
    void getInstructorDetails(String instructorID);
}
