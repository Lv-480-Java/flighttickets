package com.softserve.dao;

import com.softserve.entity.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGetRoots {
    private Connection connection;

    public List<Root> getRoots() throws SQLException {
        List<Root> rootList=new ArrayList<>();
        String sql = "SELECT * FROM roots";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int id=result.getInt("id_root");
            String from_location=result.getString("from_location");
            String to_location=result.getString("to_location");
            int distance=result.getInt("distance");
            Root root=new Root(id,from_location,to_location,distance);
            rootList.add(root);
        }
        return rootList;
    }
}
