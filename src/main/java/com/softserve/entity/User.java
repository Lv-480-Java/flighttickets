package com.softserve.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
private int id;
private String firstName;
private String lastName;
private String pass;
private String email;
public List<User> checkDuplicate=new ArrayList<>();

    public User(){
    }

    public User(String email) {
        this.email = email;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String pass, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public List<User> getCheckDuplicate() {
        return checkDuplicate;
    }

    public void setCheckDuplicate() {
        this.checkDuplicate = checkDuplicate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(pass, user.pass) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, pass, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
