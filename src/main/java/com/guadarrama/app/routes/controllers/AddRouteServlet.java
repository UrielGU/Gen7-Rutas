package com.guadarrama.app.routes.controllers;

import com.guadarrama.app.routes.services.IRoutesService;
import com.guadarrama.app.routes.services.RouteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/routes/add")
public class AddRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (Connection) request.getAttribute("connection");
        IRoutesService service = new RouteService(connection);
        request.setAttribute("trucks", service.listTrucks());
        request.setAttribute("drivers", service.listTrucks());
        getServletContext().getRequestDispatcher("/addRoute.jsp").forward(request, response);

    }
}
