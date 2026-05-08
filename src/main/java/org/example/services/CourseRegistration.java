package org.example.services;

import org.example.model.Course;

public interface CourseRegistration {
    void save (Course course);
    void displayAll();
    void updateCourse(Course course);
    String removeCourse(Course course);
}
