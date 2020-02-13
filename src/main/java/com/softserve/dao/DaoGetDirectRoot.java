package com.softserve.dao;

import com.softserve.entity.Root;
import com.softserve.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoGetDirectRoot {
    private Connection connection;

    public Root getDirectRoot(String from_Location, String to_Location) throws SQLException {
        String sql = "SELECT from_location,to_location,distance FROM roots WHERE from_location = ? and to_location = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, from_Location);
        statement.setString(2, to_Location);
        ResultSet result = statement.executeQuery();
        Root root = null;
        if (result.next()) {
            root = new Root(result.getString("from_location"), result.getString("to_location"), result.getInt("distance"));
        }
        return root;
    }
}