package com.softserve.dao;

import com.softserve.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoUser {
    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addClient(User user) throws SQLException {
        String sql = "insert into client(email,firstname,lastname,pass) values (?,?,?,?)";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getPass());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        return rowInserted;
    }
    public User checkLogin(String email, String pass) throws SQLException {
        String sql = "SELECT * FROM client WHERE email = ? and pass = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, pass);
        ResultSet result = statement.executeQuery();
        User user = null;
        if (result.next()) {
            user = new User(result.getString("firstname"), result.getString("lastname"));
        }
        return user;
    }
    public User checkRegisterEmail(User user) throws SQLException {
        String sql = "SELECT * FROM client WHERE email = ?";
        connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        ResultSet result = statement.executeQuery();
        User userFromDatabase = null;
        if (result.next()) {
            userFromDatabase = new User(result.getString("email"));
        }
        return userFromDatabase;
    }
}
