package org.example.services;

import org.example.model.Instructor;
import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceIMPL implements InstructorService{
    private List<Instructor>instructorList= new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {

        instructorList.add(instructor);
        System.out.println("Instructor" + instructor.getName()+ "added to the system.");
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {

        section.setInstructor(instructor);
        System.out.println("Instructor" + instructor.getName() + "is now teaching at Section : " + section.getSectionName());
    }

    @Override
    public void getInstructorDetails(String instructorID) {

        for(Instructor i : instructorList) {
            if (i.getPersonID().equals(instructorID)) {
                System.out.println("Instructor Details");
                System.out.println("Name" + i.getName());
                System.out.println("Department" + i.getDepartment());
                return;
            }
        }
        System.out.println("Error: Instructor with ID of " + instructorID + "not found");
    }
}
