package com.softserve.dao;

import com.softserve.controller.Client;
import java.sql.*;


public class DaoClient   {
Connection connection;

        public boolean addClient(Client client) throws SQLException{
            String sql="insert into client(email,firstname,lastname,pass) values (?,?,?,?)";
            connection=DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,client.getEmail());
            statement.setString(2,client.getFirstName());
            statement.setString(3,client.getLastName());
            statement.setString(4,client.getPass());
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            return rowInserted;
        }

        }
