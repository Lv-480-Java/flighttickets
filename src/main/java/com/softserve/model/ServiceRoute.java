package com.softserve.model;

import com.softserve.dao.DaoGetRoute;
import com.softserve.entity.Location;
import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;

import validation.RootValidator;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

public class ServiceRoute {

    private DaoGetRoute daoGetRoute;
    private RootValidator rootValidator;

    public  ServiceRoute(){
        daoGetRoute=new DaoGetRoute();
    }
    public TreeSet<String> getDeparutres() throws SQLException {
        TreeSet<String> sortedCities = daoGetRoute.getRoots();
        return sortedCities;
    }

    public List<Route> takeDirectRoot(String from_Location, String to_Location) throws SQLException, MissingRootException {
        rootValidator = new RootValidator();
        List<Route> route = daoGetRoute.getDirectRoot(from_Location, to_Location);
        if(route.size()==0){
            route= daoGetRoute.getApproxRoute(from_Location,to_Location);
        }
        rootValidator.validate(route);
        return route;
    }

    public Location takeMultiCity(String from_Location, String to_Location) throws SQLException, MissingRootException {
        Location location = daoGetRoute.getMultiCity(from_Location, to_Location);
        return location;
    }
}
