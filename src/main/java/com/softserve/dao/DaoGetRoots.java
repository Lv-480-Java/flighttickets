package com.softserve.dao;

import com.softserve.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGetRoots {
    private Connection connection;

    public List<Route> getRoots() throws SQLException {
        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT * FROM routs";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int id = result.getInt("id_root");
            String from_location = result.getString("from_location");
            String to_location = result.getString("to_location");
            int distance = result.getInt("distance");
            Route route = new Route(id, from_location, to_location, distance);
            routeList.add(route);
        }
        return routeList;
    }
}
