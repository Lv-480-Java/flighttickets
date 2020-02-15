package com.softserve.dao;

import com.softserve.entity.Plane;
import com.softserve.entity.Route;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoOrder {
    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Route getRoute(int id) throws SQLException {
        String sql = "SELECT * FROM routs WHERE id_root = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        Route route = null;
        if (result.next()) {
            route = new Route(result.getString("from_Location"), result.getString("to_Location"), result.getInt("distance"));
        }
        return route;
    }

    public List<Plane> getPlanes() throws SQLException {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT * FROM plane";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int id = result.getInt("id_plane");
            String name_type = result.getString("name_type");
            float comfort = result.getFloat("comfort");
            float price = result.getFloat("price");
            Plane plane = new Plane(id, name_type, comfort, price);
            planeList.add(plane);
        }
        return planeList;
    }

    public Plane choosePlane(int id) throws SQLException {

        String sql = "SELECT * FROM plane WHERE id_plane = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        Plane plane = null;
        if (result.next()) {
           plane = new Plane(result.getInt("id_plane"), result.getString("name_type"), result.getFloat("comfort"),result.getFloat("price"));
        }
        return plane;

    }
}