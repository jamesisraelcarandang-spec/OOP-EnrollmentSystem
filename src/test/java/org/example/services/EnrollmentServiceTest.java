package org.example.services;

import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {
    private EnrollmentServiceIMPL enrollmentService;

    @BeforeEach
    void setup() {
        enrollmentService = new EnrollmentServiceIMPL();
    }

    @Test
    @DisplayName("Should enroll student when section has capacity")
    void shouldEnrollStudent() throws Exception {
        Section section = new Section("SEC01", "Section A", 2);
        Student student = new Student("BSIT", "S01", "Alice");
        enrollmentService.enrollStudentInSection(student, section);
        assertEquals(1, section.getEnrolledStudents().size());
    }

    @Test
    @DisplayName("Should reject enrollment when section is full")
    void shouldRejectWhenFull() throws Exception {
        Section section = new Section("SEC01", "Section A", 1);
        Student student1 = new Student("BSIT", "S01", "Alice");
        Student student2 = new Student("BSIT", "S02", "Bob");

        enrollmentService.enrollStudentInSection(student1, section);
        assertThrows(SectionFullException.class, () -> {
            enrollmentService.enrollStudentInSection(student2, section);
        });
    }
}