package com.softserve.entity;

public class Plane {
private int id_plane;
private String name_type;
private float comfort;
private float price;
private int root_id;

    public Plane(String name_type, float comfort, float price) {
        this.name_type = name_type;
        this.comfort = comfort;
        this.price = price;
    }

    public Plane(int id_plane, String name_type, float comfort, float price) {
        this.id_plane = id_plane;
        this.name_type = name_type;
        this.comfort = comfort;
        this.price = price;
    }

    public int getId_plane() {
        return id_plane;
    }

    public String getName_type() {
        return name_type;
    }

    public float getComfort() {
        return comfort;
    }

    public float getPrice() {
        return price;
    }

    public int getRoot_id() {
        return root_id;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public void setComfort(float comfort) {
        this.comfort = comfort;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRoot_id(int root_id) {
        this.root_id = root_id;
    }
}
