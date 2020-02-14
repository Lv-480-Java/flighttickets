package com.softserve.entity;

import java.util.Objects;

public class Location {
    private int id_location;
    private String from_locationStart;
    private String roots_to_location;
    private int roots_distance;
    private String transfer;
    private String to_location;
    private int distance;


    public Location(String transfer, String to_location, int distance) {
        this.transfer = transfer;
        this.to_location = to_location;
        this.distance = distance;
    }

    public Location(int id_location, String transfer, String to_location, int distance) {
        this.id_location = id_location;
        this.transfer = transfer;
        this.to_location = to_location;
        this.distance = distance;
    }

    public Location(String from_locationStart, String roots_to_location, int roots_distance, String transfer, String to_location, int distance) {
        this.from_locationStart = from_locationStart;
        this.roots_to_location = roots_to_location;
        this.roots_distance = roots_distance;
        this.transfer = transfer;
        this.to_location = to_location;
        this.distance = distance;
    }

    public String getFrom_locationStart() {
        return from_locationStart;
    }

    public String getRoots_to_location() {
        return roots_to_location;
    }

    public int getRoots_distance() {
        return roots_distance;
    }

    public int getId_location() {
        return id_location;
    }

    public String getTransfer() {
        return transfer;
    }

    public String getTo_location() {
        return to_location;
    }

    public int getDistance() {
        return distance;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public void setTo_location(String to_location) {
        this.to_location = to_location;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setFrom_locationStart(String from_locationStart) {
        this.from_locationStart = from_locationStart;
    }

    public void setRoots_to_location(String roots_to_location) {
        this.roots_to_location = roots_to_location;
    }

    public void setRoots_distance(int roots_distance) {
        this.roots_distance = roots_distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id_location == location.id_location &&
                distance == location.distance &&
                transfer.equals(location.transfer) &&
                to_location.equals(location.to_location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_location, transfer, to_location, distance);
    }
}
