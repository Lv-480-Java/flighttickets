package com.softserve.controller;
import com.softserve.dao.DaoClient;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ControllerServlet extends HttpServlet {

    private DaoClient daoClient;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:8888/flighttickets?" + "serverTimezone=UTC&amp" +
                "useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("boris21352");

        daoClient = new DaoClient(jdbcURL, jdbcUsername, jdbcPassword);

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
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    addClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client.jsp");
        dispatcher.forward(request, response);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String pass = request.getParameter("pass");

        Client clientRegister = new Client(firstName, lastName, pass, email);
        daoClient.addClient(clientRegister);

    }

}