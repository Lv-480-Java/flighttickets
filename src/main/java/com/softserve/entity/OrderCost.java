package com.softserve.entity;

import com.softserve.model.ServiceOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderCost {
 List<Route> direct=new ArrayList<>();
 List<Plane> planes =new ArrayList<>();
 ServiceOrder serviceOrder;
public OrderCost(){
    serviceOrder=new ServiceOrder();
}

public void addRoute(int id) throws SQLException {
  serviceOrder=new ServiceOrder();
    direct.add( serviceOrder.getDirect(id));
}
    public void addPlane(int id) throws SQLException {
        serviceOrder=new ServiceOrder();
        direct.add( serviceOrder.getDirect(id));
    }
}
