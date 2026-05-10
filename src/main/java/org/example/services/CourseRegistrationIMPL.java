package org.example.services;

import org.example.exceptions.DuplicateIdException;
import org.example.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationIMPL implements CourseRegistration {
    private List<Course> courses = new ArrayList<>();

    @Override
    public void save(Course course) throws DuplicateIdException {
        for (Course c : courses) {
            if (c.getCourseID().equals(course.getCourseID())) {
                throw new DuplicateIdException("Course with ID " + course.getCourseID() + " already exists.");
            }
        }
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    @Override
    public void displayAll() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course c : courses) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(course.getCourseID())) {
                courses.set(i, course);
                System.out.println("Course updated successfully.");
                return;
            }
        }
    }

    @Override
    public String removeCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(course.getCourseID())) {
                courses.remove(i);
                return "Successfully Deleted";
            }
        }
        return "Error: Course not found";
    }
}
