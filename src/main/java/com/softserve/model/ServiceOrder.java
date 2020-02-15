package com.softserve.model;

import com.softserve.dao.DaoOrder;
import com.softserve.entity.Plane;
import com.softserve.entity.Route;

import java.sql.SQLException;
import java.util.List;

public class ServiceOrder {
    private DaoOrder daoOrder;

    public ServiceOrder() {
        daoOrder = new DaoOrder();
    }

    public Route getDirect(int id) throws SQLException {
        Route route = daoOrder.getRoute(id);
        return route;
    }

    public List<Plane> getPlanes() throws SQLException {
        List<Plane> planeList = daoOrder.getPlanes();
        return planeList;
    }
    public Plane choosePlane(int id) throws SQLException {
        Plane plane=daoOrder.choosePlane(id);
        return plane;
    }
}
