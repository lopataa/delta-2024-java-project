package org.delta.people;

public class Owner {
    public String firstname;
    public String lastname;
    public String id;


    public Owner(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
