package com.softserve.model;

import com.softserve.entity.Order;
import com.softserve.entity.Plane;
import com.softserve.entity.Route;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServiceCost {

  public  static List<Route> direct = new ArrayList<>();
  public  static List<Plane> planes = new ArrayList<>();
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
}
