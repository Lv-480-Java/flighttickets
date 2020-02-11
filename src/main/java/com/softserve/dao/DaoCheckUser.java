package com.softserve.dao;

import com.softserve.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCheckUser {
    private Connection connection;

    public User checkRegisterEmail(User user) throws SQLException {
        String sql = "SELECT * FROM client WHERE email = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,user.getEmail());
        ResultSet result = statement.executeQuery();
        User userFromDatabase=null;
        if (result.next()) {
            userFromDatabase = new User(result.getString("email"));
        }
        return userFromDatabase;
    }
}
