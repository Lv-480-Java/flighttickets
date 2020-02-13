package com.softserve.controller;

import com.softserve.entity.Root;
import com.softserve.entity.User;
import com.softserve.exceptions.LoginException;
import com.softserve.exceptions.MissingRootException;
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


public class ServletOrder extends HttpServlet {
    private Service serviceServlet;

    public ServletOrder() {
        this.serviceServlet = new Service();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new ServletRegister();
        String from_Location = request.getParameter("from_Location");
        String to_Location = request.getParameter("to_Location");
        try {

           Root root=serviceServlet.takeDirectRoot(from_Location,to_Location);
            request.setAttribute("root",root);

            RequestDispatcher dispatcher = request.getRequestDispatcher("orderPlane.jsp");
            dispatcher.forward(request, response);
        }
        catch (MissingRootException | SQLException exc){

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("missingRoot.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    }




