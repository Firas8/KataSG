package com.sg.kata.model;

public class Holder {

    private String lastname;

    private String firstname;

    public Holder(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "Lastname = '" + lastname + ", Firstname = '" + firstname;
    }
}
