package org.example.services;

import org.example.model.Instructor;
import org.example.model.Section;
import org.example.exceptions.DuplicateIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorServiceTest {
    private InstructorServiceIMPL instructorService;

    @BeforeEach
    void setup() {
        instructorService = new InstructorServiceIMPL();
    }

    @Test
    @DisplayName("Instructor should be added successfully")
    void shouldAddInstructor() throws Exception {
        instructorService.addInstructor(new Instructor("INS01", "John", "IT"));
        instructorService.addInstructor(new Instructor("INS02", "Jane", "CS"));
        assertEquals(2, instructorService.getInstructorCount());
    }

    @Test
    @DisplayName("Duplicate instructor ID should be rejected")
    void shouldRejectDuplicateInstructor() throws Exception {
        instructorService.addInstructor(new Instructor("INS01", "John", "IT"));
        assertThrows(DuplicateIdException.class, () -> {
            instructorService.addInstructor(new Instructor("INS01", "Jane", "CS"));
        });
    }

    @Test
    @DisplayName("Instructor should be assigned to a section")
    void shouldAssignInstructorToSection() {
        Instructor instructor = new Instructor("INS01", "John", "IT");
        Section section = new Section("SEC01", "Section A", 30);
        instructorService.assignInstructorToSection(instructor, section);
        assertEquals(instructor, section.getInstructor());
    }
}