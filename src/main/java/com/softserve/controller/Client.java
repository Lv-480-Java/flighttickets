package com.softserve.controller;

import java.util.Objects;

public class Client {
private int id;
private String firstName;
private String lastName;
private String pass;
private String email;

    public Client( String firstName, String lastName, String pass,String email) {
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
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(pass, client.pass) &&
                Objects.equals(email, client.email);
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
