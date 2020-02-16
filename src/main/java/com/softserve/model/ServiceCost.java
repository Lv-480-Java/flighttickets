package com.softserve.model;

import com.softserve.entity.Location;
import com.softserve.entity.Order;
import com.softserve.entity.Plane;
import com.softserve.entity.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServiceCost {

    public static List<Location> multicity = new ArrayList<>();
    public static List<Route> direct = new ArrayList<>();
    public static List<Plane> planes = new ArrayList<>();
    ServiceOrder serviceOrder;

    public ServiceCost() {
        serviceOrder = new ServiceOrder();
    }

    public void addRoute(int id) throws SQLException {

        direct.add(serviceOrder.getDirect(id));
    }

    public void addPlane(int id) throws SQLException {

        planes.add(serviceOrder.choosePlane(id));
    }

    public Order calculatePrice() {
        String from = null;
        String to = null;
        String routeFinal;
        int distance = 0;
        float comfort = 0;
        float price = 0;
        float ticketPrice;

        for (Route route : direct) {
            distance = route.getDistance();
            from = route.getFrom_Location();
            to = route.getTo_Location();
        }
        for (Plane plane : planes) {
            comfort = plane.getComfort();
            price = plane.getPrice();
        }
        routeFinal = from + " - " + to;
        ticketPrice = distance * comfort * price;

        return new Order(routeFinal, ticketPrice);
    }

    public Order calculateMulti() {
        String from_locationStart = null;
        String roots_to_location = null;
        int roots_distance = 0;
        String transfer = null;
        String to_location = null;
        int distance = 0;
        String routeFinal;
        float comfort = 0;
        float price = 0;
        float ticketPrice;
        for (Plane plane : planes) {
            comfort = plane.getComfort();
            price = plane.getPrice();
        }
        for (Location location : multicity) {
            from_locationStart = location.getFrom_locationStart();
            roots_to_location = location.getRoots_to_location();
            roots_distance = location.getRoots_distance();
            transfer = location.getTransfer();
            to_location = location.getTo_location();
            distance = location.getDistance();
        }
        routeFinal = from_locationStart + " - " + roots_to_location + " - " + transfer + " - " + to_location;
        ticketPrice = (roots_distance + distance) * comfort * price;
        return new Order(routeFinal, ticketPrice);
    }
}
