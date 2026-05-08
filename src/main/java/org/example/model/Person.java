package org.example.model;

public abstract class Person {
    private String personID;
    private String name;

    public Person() {
        this("023","Unknown");
    }

    public Person(String personID, String name) {
        this.personID = personID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
    public abstract void  mainTask();

}
