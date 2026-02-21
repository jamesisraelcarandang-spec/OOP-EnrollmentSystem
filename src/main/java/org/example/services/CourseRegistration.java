package org.example.services;
import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;
public class CourseRegistration {
    private ArrayList<Course> courseList = new ArrayList<>();

    public void save(Course course) {
        courseList.add(course);
    }

    public void displayAll() {
        System.out.println(courseList);
    }

    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(course.getCourseID())) {
                courseList.set(i, new Course());
                break;
            }
        }
    }

    public String removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(course.getCourseID())) {
                courseList.remove(i);

                return "Successfully Deleted";
            }
        }
        return "Error";
    }
}

