package com.softserve.model;

import com.softserve.dao.*;
import com.softserve.entity.Location;
import com.softserve.entity.Route;
import com.softserve.entity.User;
import com.softserve.exceptions.MissingRootException;
import com.softserve.exceptions.ValidationException;
import com.softserve.sort.SortCity;
import validation.LoginValidator;
import validation.RegisterValidator;
import validation.RootValidator;
import validation.UserValidator;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

public class Service {

    private DaoUser daoUser;
    private UserValidator userValidator;
    private DaoLogin daoLogin;
    private LoginValidator loginValidator;
    private DaoCheckUser daoCheckUser;
    private RegisterValidator registerValidator;
    private DaoGetRoots daoGetRoots;
    private DaoGetDirectRoot daoGetDirectRoot;
    private RootValidator rootValidator;
    private DaoMultiCity daoMultiCity;
    private SortCity sortCity;

    public Service() {

    }

    public void chekcClient(User userFromRegistration) throws SQLException {
        registerValidator = new RegisterValidator();
        daoCheckUser = new DaoCheckUser();
        User checkEmail = daoCheckUser.checkRegisterEmail(userFromRegistration);
        registerValidator.validate(checkEmail);
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

    public TreeSet<String> getDeparutres() throws SQLException {
        daoGetRoots = new DaoGetRoots();
        sortCity = new SortCity();
        List<Route> routeList = daoGetRoots.getRoots();
        TreeSet<String> sortedCities = sortCity.uniqueCity(routeList);
        return sortedCities;
    }

    public Route takeDirectRoot(String from_Location, String to_Location) throws SQLException, MissingRootException {
        daoGetDirectRoot = new DaoGetDirectRoot();
        rootValidator = new RootValidator();
        Route route = daoGetDirectRoot.getDirectRoot(from_Location, to_Location);
        rootValidator.validate(route);
        return route;
    }

    public Location takeMultiCity(String from_Location, String to_Location) throws SQLException, MissingRootException {
        daoMultiCity = new DaoMultiCity();
        Location location = daoMultiCity.getMultiCity(from_Location, to_Location);
        return location;
    }
}