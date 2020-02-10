package com.softserve.model;

import com.softserve.dao.DaoLogin;
import com.softserve.dao.DaoUser;
import com.softserve.entity.User;
import com.softserve.exceptions.ValidationException;
import validation.LoginValidator;
import validation.UserValidator;


import java.sql.SQLException;

public class Service {

    private DaoUser daoUser;
    private UserValidator userValidator;
    private DaoLogin daoLogin;
    private LoginValidator loginValidator;

    public Service() {
        this.daoUser = new DaoUser();
        this.userValidator = new UserValidator();
        this.daoLogin = new DaoLogin();
        this.loginValidator = new LoginValidator();
    }

    public void insertClient(User user) throws SQLException, ValidationException {
        userValidator.validate(user);
        daoUser.addClient(user);
    }

    public User getLogin(String email, String pass) throws SQLException {
        User user = daoLogin.checkLogin(email, pass);
        loginValidator.validate(user);
        return user;
    }
}