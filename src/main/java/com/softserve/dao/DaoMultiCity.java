package com.softserve.dao;

import com.softserve.entity.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoMultiCity {
    private Connection connection;

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
}
