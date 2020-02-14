package com.softserve.dao;
import com.softserve.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLogin {
    private Connection connection;

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
}
