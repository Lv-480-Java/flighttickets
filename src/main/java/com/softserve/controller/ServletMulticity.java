package com.softserve.controller;

import com.softserve.entity.Location;
import com.softserve.entity.Plane;
import com.softserve.exceptions.MissingRootException;
import com.softserve.model.Service;
import com.softserve.model.ServiceCost;
import com.softserve.model.ServiceOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ServletMulticity extends HttpServlet {

    private Service servletMulticity;
    public ServletMulticity() {

        this.servletMulticity=new Service();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{

            RequestDispatcher dispatcher = request.getRequestDispatcher("selectPlaneMulti.jsp");
            dispatcher.forward(request, response);
        } catch (MissingRootException ex) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("missingRoot.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
