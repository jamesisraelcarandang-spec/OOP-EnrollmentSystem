package org.example.services;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistrationIMPL StudReg;
    private CourseRegistrationIMPL courseReg;

    public CampusRegistrar(StudentRegistrationIMPL registration, CourseRegistrationIMPL courseReg) {
    this.StudReg = registration;
    this.courseReg =courseReg;
    }

    public void save(Course course){
        courseReg.save(course);
    }
    public void displayAll() {
        courseReg.displayAll();
    }
    public void updateCourse(Course course) {
        courseReg.updateCourse(course);
    }
    public String removeCourse(Course course) {
        return courseReg.removeCourse(course);
    }
    public void saveStudent(Student student) {
        StudReg.saveStudent(student);
    }
    public void displayAllStudent() {
        StudReg.displayAllStudent();
    }
    public void update(Student student) {
        StudReg.update(student);
    }
    public String removeStudent(Student student) {
        return StudReg.removeStudent(student);
    }
}
