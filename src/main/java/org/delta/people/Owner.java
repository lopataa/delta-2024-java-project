package org.delta.people;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("name_that_his_mom_gave_him")
    public String firstname;
    @SerializedName("name_that_he_got_after_his_mom")
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
