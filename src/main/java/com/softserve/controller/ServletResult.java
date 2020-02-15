package com.softserve.controller;

import com.softserve.entity.Order;
import com.softserve.model.ServiceCost;
import com.softserve.exceptions.MissingRootException;
import com.softserve.model.ServiceOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ServletResult extends HttpServlet {

    private ServiceOrder serviceOrder;
    private ServiceCost serviceCost;

    public ServletResult() {
        this.serviceCost = new ServiceCost();
        this.serviceOrder = new ServiceOrder();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Id_plane = Integer.parseInt(request.getParameter("id_plane"));
        try {
            serviceCost.addPlane(Id_plane);
            Order order= serviceCost.calculatePrice();
            request.setAttribute("order",order);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ticketResult.jsp");
            dispatcher.forward(request, response);

        } catch (MissingRootException | SQLException exc) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("missingRoot.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}