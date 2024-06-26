package com.guadarrama.app.routes.controllers;

import com.guadarrama.app.routes.models.Driver;
import com.guadarrama.app.routes.services.DriversService;
import com.guadarrama.app.routes.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/drivers/details")
public class DriversDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (Connection) request.getAttribute("connection");
        IService<Driver> service = new DriversService(connection);
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));
        }catch (NumberFormatException ex){
            id = 0L;
        }
        Driver driver = new Driver();
        if (id>0){
            Optional<Driver> optionalDriver = service.getByID(id);
            if (optionalDriver.isPresent()){
                driver = optionalDriver.get();
                request.setAttribute("driver", driver);
                getServletContext().getRequestDispatcher("/driverDetails.jsp").forward(request, response);
            }else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el chofer en la BDD");
            }
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Error en el ID");
        }
    }

}
