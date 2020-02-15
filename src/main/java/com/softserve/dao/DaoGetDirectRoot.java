package com.softserve.dao;

import com.softserve.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGetDirectRoot {
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
}