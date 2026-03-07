package org.example.model;

public class Person {
    private int ID;
    private String Name;

    public Person(int ID, String Name) {
    this.ID = ID;
    this.Name = Name;
    }

    public Person() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
