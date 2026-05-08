package org.example.model;

public abstract class Person {
    private String personID;
    private String name;


    public Person() {
        this(0, "Unknown");
    }

    public Person (int personID, String name) {
        this(personID,name, 0);
    }
    public Person(int personID,String name, int age) {
        this.personID = personID;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;

    }

    public void display() {
        System.out.println(getName());

    }
    public abstract void mainTask();

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", name='" + name +

                '}';
    }
}
