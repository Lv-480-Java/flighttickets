package com.softserve.model;

import com.softserve.dao.DaoCheckUser;
import com.softserve.dao.DaoLogin;
import com.softserve.dao.DaoUser;
import com.softserve.entity.User;
import com.softserve.exceptions.ValidationException;
import validation.LoginValidator;
import validation.RegisterValidator;
import validation.UserValidator;


import java.sql.SQLException;

public class Service {
    private User checkExist;
    private DaoUser daoUser;
    private UserValidator userValidator;
    private DaoLogin daoLogin;
    private LoginValidator loginValidator;
    private DaoCheckUser daoCheckUser;
    private RegisterValidator registerValidator;
    public Service() {

    }

    public void chekcClient(User userFromRegistration) throws SQLException {
        registerValidator=new RegisterValidator();
        checkExist = new User();
        daoCheckUser = new DaoCheckUser();
        User checkEmail = daoCheckUser.checkRegisterEmail(userFromRegistration);
        registerValidator.validate(userFromRegistration,checkEmail);
    }

    public void insertClient(User user) throws SQLException, ValidationException {
        userValidator = new UserValidator();
        daoUser = new DaoUser();
        userValidator.validate(user);
        daoUser.addClient(user);
    }

    public User getLogin(String email, String pass) throws SQLException {
        daoLogin = new DaoLogin();
        loginValidator = new LoginValidator();
        User user = daoLogin.checkLogin(email, pass);
        loginValidator.validate(user);
        return user;
    }
}