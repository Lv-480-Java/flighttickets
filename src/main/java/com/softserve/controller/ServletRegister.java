package com.softserve.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletRegister extends HttpServlet {
    boolean flag;
    public static int state=0;
    private Service serviceServlet;

    public ServletRegister() {
        this.serviceServlet = new Service();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new ServletRegister();
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

        Client clientRegister = new Client(firstName, lastName, pass, email);

        flag = serviceServlet.insertClient(clientRegister);

        if(flag==true) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("root.jsp");
            requestDispatcher.forward(request, response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("notvalid.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}