package com.softserve.controller;

import com.softserve.entity.User;
import com.softserve.exceptions.LoginException;
import com.softserve.model.ServiceRoute;
import com.softserve.model.ServiceUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;


public class ServletLogin extends HttpServlet {
    private ServiceUser serviceUserServlet;
    private ServiceRoute serviceRoute;

    public ServletLogin() {
        this.serviceUserServlet = new ServiceUser();
        this.serviceRoute = new ServiceRoute();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        try {
            User user = serviceUserServlet.getLogin(email, password);
            TreeSet<String> routeList = serviceRoute.getDeparutres();
            request.setAttribute("routeList", routeList);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
            dispatcher.forward(request, response);
        } catch (LoginException | SQLException loginexception) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("notvalid.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}