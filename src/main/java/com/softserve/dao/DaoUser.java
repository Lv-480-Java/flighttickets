package com.softserve.dao;

import com.softserve.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DaoUser {
    private Connection connection;

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

}
