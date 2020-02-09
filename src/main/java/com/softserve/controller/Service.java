package com.softserve.controller;

import com.softserve.dao.DaoClient;
import interfaces.RegisterValidate;

import java.sql.SQLException;

public class Service implements RegisterValidate {
    public static int validFields = 0;
    private DaoClient daoClient;
    private Service service;

    public Service() {
        this.daoClient = new DaoClient();

    }

    public boolean insertClient(Client client) throws SQLException {
        service=new Service();
        validFields=service.checkRegister(client);
        if (validFields == 8) {
            validFields = 0;
            daoClient.addClient(client);
            return true;
        } else {
            validFields = 0;
            return false;
        }
    }
}