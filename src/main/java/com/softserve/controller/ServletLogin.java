package com.softserve.controller;

import com.softserve.entity.Root;
import com.softserve.entity.User;
import com.softserve.exceptions.LoginException;
import com.softserve.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ServletLogin extends HttpServlet {
    private Service serviceServlet;

    public ServletLogin() {
        this.serviceServlet = new Service();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new ServletRegister();
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        try {
            User user= serviceServlet.getLogin(email, password);
            List<Root> rootList=serviceServlet.getDeparutres();
            request.setAttribute("rootList",rootList);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
            dispatcher.forward(request, response);
        }
        catch (LoginException | SQLException loginexception){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("notvalid.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}