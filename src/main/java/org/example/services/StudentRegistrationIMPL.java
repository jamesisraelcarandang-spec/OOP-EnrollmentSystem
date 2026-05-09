package org.example.services;
import org.example.model.Student;
import java.util.List;
import java.util.ArrayList;
public class StudentRegistrationIMPL implements StudentRegistration {
    private List<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student) {
        for (Student s : studentList) {
            if (s.getPersonID().equals(student.getPersonID())) {
                System.out.println("Error: Student with ID " + student.getPersonID() + " already exists.");
                return;
            }
        }
        studentList.add(student);
    }

    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    public void update(Student student) {
        for (int i = 0; i <studentList.size(); i++) {
            if(studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.set(i, student);
                break;
            }
        }
    }
    public String removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.remove(i);

                return "Successfully Deleted";
            }
        }
        return "Error";
    }
}
