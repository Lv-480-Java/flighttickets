package com.softserve.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoRoot {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public DaoRoot(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
        }
        jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/flighttickets?" + "serverTimezone=UTC&amp" +
                        "useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false",
                "root", "boris21352");
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

}
