package com.podufalyy.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passportId;

    public User(String firstName, String lastName, String email, String password, String passportId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return "\n\nUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passportId='" + passportId;
    }
}
