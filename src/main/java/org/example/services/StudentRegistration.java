package org.example.services;
import org.example.model.Student;
import java.util.*;
import java.util.ArrayList;
public class StudentRegistration {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student) {
        studentList.add(student);
    }
    public void displayAllStudent() {
        System.out.println(studentList);
    }
    public void update(Student student) {
        for (int i = 0; i <studentList.size(); i++) {
            if(studentList.get(i).getStudentID().equals(student.getStudentID())) {
                studentList.set(i, student);
                break;
            }
        }
    }
    public String removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getStudentID().equals(student.getStudentID())) {
                studentList.remove(i);

                return "Successfully Deleted";
            }
        }
        return "Error";
    }
}
