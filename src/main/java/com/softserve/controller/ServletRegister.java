package com.softserve.controller;

import com.softserve.entity.User;
import com.softserve.exceptions.DuplicateException;
import com.softserve.exceptions.ValidationException;
import com.softserve.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

public class ServletRegister extends HttpServlet {

    private Service serviceServlet;

    public ServletRegister() {
        this.serviceServlet = new Service();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        try {
            switch (action) {
                case "/index":
                    connectService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void connectService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String pass = request.getParameter("pass");

        User userRegister = new User(firstName, lastName, pass, email);
        try {
            serviceServlet.chekcClient(userRegister);
            serviceServlet.insertClient(userRegister);
            TreeSet<String> routeList = serviceServlet.getDeparutres();

            request.setAttribute("routeList", routeList);
            HttpSession session = request.getSession();
            session.setAttribute("user", userRegister);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginSuccess.jsp");
            requestDispatcher.forward(request, response);

        } catch (ValidationException userValidator) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("notvalid.jsp");
            requestDispatcher.forward(request, response);
        } catch (DuplicateException duplicateUser) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("alreadyRegistered.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}