package com.softserve.entity;
import java.util.Objects;

public class Root {
    private int id_root;
    private String from_Location;
    private String to_Location;
    private int distance;

    public Root(int id_root,String from_Location, String to_Location, int distance) {
        this.id_root=id_root;
        this.from_Location = from_Location;
        this.to_Location = to_Location;
        this.distance = distance;
    }

    public int getId_root() {
        return id_root;
    }

    public String getFrom_Location() {
        return from_Location;
    }

    public String getTo_Location() {
        return to_Location;
    }

    public int getDistance() {
        return distance;
    }

    public void setFrom_Location(String from_Location) {
        this.from_Location = from_Location;
    }

    public void setTo_Location(String to_Location) {
        this.to_Location = to_Location;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setId_root(int id_root) {
        this.id_root = id_root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return distance == root.distance &&
                Objects.equals(from_Location, root.from_Location) &&
                Objects.equals(to_Location, root.to_Location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from_Location, to_Location, distance);
    }

    @Override
    public String toString() {
        return "Location{" +
                "from_Location='" + from_Location + '\'' +
                ", to_Location='" + to_Location + '\'' +
                ", distance=" + distance +
                '}';
    }
}
