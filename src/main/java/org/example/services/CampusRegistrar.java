package org.example.services;

import org.example.model.*;

public class CampusRegistrar {
    private StudentRegistrationIMPL StudReg;
    private CourseRegistrationIMPL courseReg;
    private InstructorServiceIMPL instReg;
    private EnrollmentServiceIMPL enrollReg;
    private TuitionFeePaymentService tuitionReg;

    public CampusRegistrar(StudentRegistrationIMPL registration, CourseRegistrationIMPL courseReg,
                           InstructorServiceIMPL instReg, EnrollmentServiceIMPL enrollReg,
                           TuitionFeePaymentService tuitionReg) {
    this.StudReg = registration;
    this.courseReg =courseReg;
    this.instReg = instReg;
    this.enrollReg = enrollReg;
    this.tuitionReg = tuitionReg;
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
    public void addInstructor(Instructor instructor){
        instReg.addInstructor(instructor);
    }
    public void getAllInstructor() {
        instReg.getAllInstructors();
    }
    public void getInstructorDetails(String id) {
        instReg.getInstructorDetails(id);
    }
    public void assignInstructorToSection(Instructor i, Section s) {
        instReg.assignInstructorToSection(i,s);
    }
    public void removeInstructor(String Id) {
        instReg.removeInstructor(Id);
    }
    public void enroll(Student student, Section section) {
        enrollReg.enrollStudentInSection(student,section);
    }
    public void showHierarchy(Department dept) {
        enrollReg.viewDepartmentHierarchy(dept);
    }
    public void payTuition(double amount) {
        tuitionReg.makePayment(amount);
    }
    public double calculateTuition(int units, double discount) {
        return tuitionReg.calculateTuitionFee(units, discount);
    }
    public double getBalance() {
        return tuitionReg.getRemainingBalance();
    }
}
