package com.softserve.controller;

import com.softserve.entity.Location;
import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;
import com.softserve.model.Service;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ServletOrder extends HttpServlet {
    private Service serviceServlet;

    public ServletOrder() {
        this.serviceServlet = new Service();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new ServletRegister();
        String from_Location = request.getParameter("from_Location");
        String to_Location = request.getParameter("to_Location");
        try {

            Route route = serviceServlet.takeDirectRoot(from_Location, to_Location);
            request.setAttribute("route", route);
            Location location = serviceServlet.takeMultiCity(from_Location, to_Location);
            request.setAttribute("location", location);

            RequestDispatcher dispatcher = request.getRequestDispatcher("orderPlane.jsp");
            dispatcher.forward(request, response);
        } catch (MissingRootException | SQLException exc) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("missingRoot.jsp");
            requestDispatcher.forward(request, response);
        }


    }

}




