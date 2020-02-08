package com.softserve.controller;

import com.softserve.dao.DaoClient;


import java.sql.SQLException;

public class Service   {
    private DaoClient daoClient;

    public Service(){
        this.daoClient=new DaoClient();
    }

    public void insertClient(Client client) throws SQLException {
        daoClient.addClient(client);

    }
}