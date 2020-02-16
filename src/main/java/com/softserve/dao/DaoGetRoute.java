package com.softserve.dao;

import com.softserve.entity.Location;
import com.softserve.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DaoGetRoute {
    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Route> getDirectRoot(String from_Location, String to_Location) throws SQLException {
        List<Route> routeDirect = new ArrayList<>();
        String sql = "SELECT id_root,from_location,to_location,distance FROM routs WHERE from_location = ? and to_location = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, from_Location);
        statement.setString(2, to_Location);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id_root");
            String from_location = result.getString("from_location");
            String to_location = result.getString("to_location");
            int distance = result.getInt("distance");
            Route route = new Route(id, from_location, to_location, distance);
            routeDirect.add(route);
       break;
        }
        return routeDirect;
    }

    public List<Route> getApproxRoute(String from_Location, String to_Location) throws SQLException {
        List<Route> routsApproux = new ArrayList<>();
        String sqlSecond = "SELECT id_root, from_location,to_location,distance FROM routs WHERE from_location = ? or to_location = ?";
        PreparedStatement statement = connection.prepareStatement(sqlSecond);
        statement.setString(1, from_Location);
        statement.setString(2, to_Location);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id_root");
            String from_location = result.getString("from_location");
            String to_location = result.getString("to_location");
            int distance = result.getInt("distance");
            Route route = new Route(id, from_location, to_location, distance);
            routsApproux.add(route);
        }
        return routsApproux;
    }

    public Location getMultiCity(String from_Location, String to_Location) throws SQLException {
        String sql = "SELECT from_location, routs.to_location, routs.distance, transfer, location.to_location, location.distance " +
                "from routs  join  location on routs.id_root = location.root_id " +
                "where from_location = ? and location.to_location = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, from_Location);
        statement.setString(2, to_Location);
        ResultSet result = statement.executeQuery();
        Location location = null;
        if (result.next()) {
            location = new Location(result.getString("from_location"), result.getString("routs.to_location"), result.getInt("routs.distance"),
                    result.getString("transfer"), result.getString("location.to_location"), result.getInt("location.distance"));
        }
        return location;
    }
    public TreeSet<String> getRoots() throws SQLException {
        TreeSet<String> routeList = new TreeSet<>();
        String sql = "SELECT * FROM city";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String city = result.getString("City");
            routeList.add(city);
        }
        return routeList;
    }
}