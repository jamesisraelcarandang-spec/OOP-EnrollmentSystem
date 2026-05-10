package org.example.services;

import org.example.model.*;
import org.example.exceptions.*;

public class CampusRegistrar {
    private StudentRegistration StudReg;
    private CourseRegistration courseReg;
    private InstructorService instReg;
    private EnrollmentService enrollReg;
    private TuitionFeePaymentService tuitionReg;
    private DepartmentService deptReg;

    public CampusRegistrar(StudentRegistration registration, CourseRegistration courseReg,
                           InstructorService instReg, EnrollmentService enrollReg,
                           TuitionFeePaymentService tuitionReg, DepartmentService deptReg) {
        this.StudReg = registration;
        this.courseReg = courseReg;
        this.instReg = instReg;
        this.enrollReg = enrollReg;
        this.tuitionReg = tuitionReg;
        this.deptReg = deptReg;
    }

    public void save(Course course) throws DuplicateIdException {
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

    public void saveStudent(Student student) throws DuplicateIdException {
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

    public void addInstructor(Instructor instructor) throws DuplicateIdException {
        instReg.addInstructor(instructor);
    }

    public void getAllInstructor() {
        instReg.getAllInstructors();
    }

    public void getInstructorDetails(String id) {
        instReg.getInstructorDetails(id);
    }

    public void assignInstructorToSection(Instructor i, Section s) {
        instReg.assignInstructorToSection(i, s);
    }

    public void removeInstructor(String Id) {
        instReg.removeInstructor(Id);
    }

    public void enroll(Student student, Section section) throws SectionFullException {
        enrollReg.enrollStudentInSection(student, section);
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

    public void addDepartment(Department department) {
        deptReg.addDepartment(department);
    }

    public Department findDepartment(String id) {
        return deptReg.findDepartmentById(id);
    }

    public void addSectionToDepartment(String deptId, Section section) {
        deptReg.addSectionToDepartment(deptId, section);
    }

    public void displayAllDepartments() {
        deptReg.displayAllDepartments();
    }
}