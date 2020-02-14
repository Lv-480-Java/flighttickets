package com.softserve.dao;

import com.softserve.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoGetDirectRoot {
    private Connection connection;

    public Route getDirectRoot(String from_Location, String to_Location) throws SQLException {
        String sql = "SELECT from_location,to_location,distance FROM routs WHERE from_location = ? and to_location = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, from_Location);
        statement.setString(2, to_Location);
        ResultSet result = statement.executeQuery();
        Route route = null;
        if (result.next()) {
            route = new Route(result.getString("from_location"), result.getString("to_location"), result.getInt("distance"));
        }
        return route;
    }
}