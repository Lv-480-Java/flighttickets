package com.softserve.dao;

import com.softserve.controller.Client;
import java.sql.*;


    public class DaoClient {
        private String jdbcURL;
        private String jdbcUsername;
        private String jdbcPassword;
        private Connection jdbcConnection;

        public DaoClient(String jdbcURL, String jdbcUsername, String jdbcPassword) {
            this.jdbcURL = jdbcURL;
            this.jdbcUsername = jdbcUsername;
            this.jdbcPassword = jdbcPassword;
        }
        protected void connect () throws SQLException{
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                }
                jdbcConnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/flighttickets?" +"serverTimezone=UTC&amp"+
                                "useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "boris21352");
            }

        protected void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        }
        public boolean addClient(Client client) throws SQLException{
            String sql="insert into client(email,firstname,lastname,pass) values (?,?,?,?)";
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1,client.getEmail());
            statement.setString(2,client.getFirstName());
            statement.setString(3,client.getLastName());
            statement.setString(4,client.getPass());

            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowInserted;
        }

        }
