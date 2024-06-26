package com.guadarrama.app.routes.controllers;

import com.guadarrama.app.routes.models.Truck;
import com.guadarrama.app.routes.services.IService;
import com.guadarrama.app.routes.services.TrucksService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/trucks/toList")
public class TruckListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=(Connection) request.getAttribute("connection");
        IService<Truck> service=new TrucksService(connection);
        List<Truck> trucks= service.toList();

        request.setAttribute("trucks",trucks);
        getServletContext().getRequestDispatcher("/trucksList.jsp").forward(request,response);
    }

}
