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

    @Override
    public void updateInstructor(Instructor instructor) {
    for (int i = 0; i < instructorList.size(); i++) {
        if (instructorList.get(i).getPersonID().equals(instructor.getPersonID())) {
            instructorList.set(i,instructor);
            System.out.println("Instructor Updated Successfully.");
          }
       }
    }

    @Override
    public void removeInstructor(String instructorID) {
    for (Instructor i : instructorList) {
        if (i.getPersonID().equals(instructorID)) {
            instructorList.remove(i);
            System.out.println("Instructor Removed");
            return;
        }
    }
        System.out.println("Instructor not found");
    }

    @Override
    public void getAllInstructors() {
        if (instructorList.isEmpty()) {
            System.out.println("No instructors found.");
        }else{
            for (Instructor i : instructorList) {
                System.out.println(i);
            }
        }
    }
}
