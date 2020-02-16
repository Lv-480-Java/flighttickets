package com.softserve.model;

import com.softserve.dao.DaoUser;
import com.softserve.entity.User;
import com.softserve.exceptions.ValidationException;
import validation.LoginValidator;
import validation.RegisterValidator;
import validation.UserValidator;

import java.sql.SQLException;

public class ServiceUser {

    private DaoUser daoUser;
    private UserValidator userValidator;
    private LoginValidator loginValidator;
    private RegisterValidator registerValidator;

    public ServiceUser() {
        daoUser = new DaoUser();
    }

    public void chekcClient(User userFromRegistration) throws SQLException {
        registerValidator = new RegisterValidator();
        User checkEmail = daoUser.checkRegisterEmail(userFromRegistration);
        registerValidator.validate(checkEmail);
    }

    public void insertClient(User user) throws SQLException, ValidationException {
        userValidator = new UserValidator();
        userValidator.validate(user);
        daoUser.addClient(user);
    }

    public User getLogin(String email, String pass) throws SQLException {
        loginValidator = new LoginValidator();
        User user = daoUser.checkLogin(email, pass);
        loginValidator.validate(user);
        return user;
    }

}