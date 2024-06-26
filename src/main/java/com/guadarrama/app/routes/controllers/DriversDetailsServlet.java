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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (Connection) request.getAttribute("connection");
        IService<Driver> service = new DriversService(connection);

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String lastName = request.getParameter("lastname");
        String licence = request.getParameter("licence");
        String phone = request.getParameter("phone");
        String birthDate = request.getParameter("birthdate");
        LocalDate date;

        try {
            date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeParseException ex){
            date = null;
        }
        String checkbox[];

        checkbox = request.getParameterValues("availability");
        Boolean habilitar;
        if(checkbox != null)
            habilitar = true;
        else
            habilitar = false;

        Map<String, String> errors = new HashMap<>();
        //un mapa es como si fueran pares, p ej. Map<String, Float> = {("maths": 7.23), ("spanish": 4.66)}
        if (name == null || name.isBlank())
            errors.put("name", "el nombre es requerido");

        if (surname == null && surname.isBlank())
            errors.put("surname", "el apellido paterno es requerido");

        if (lastName == null && lastName.isBlank())
            errors.put("lastname", "el apellido materno es requerido");

        if (licence == null && licence.isBlank())
            errors.put("licence", "el campo de licencia es requerido");

        if (phone == null && phone.isBlank())
            errors.put("phone", "el teléfono es requerido");

        if (birthDate == null && birthDate.isBlank())
            errors.put("birthdate", "La fecha de nacimiento es requerida");

        if (errors.isEmpty()){
            Driver driver = new Driver();
            driver.setId_driver(1003L);
            driver.setName(name);
            driver.setSurname(surname);
            driver.setLastName(lastName);
            driver.setLicence(licence);
            driver.setPhone(phone);
            driver.setBirthDate(date);
            driver.setAvailability(habilitar);
            service.save(driver);
            response.sendRedirect(request.getContextPath() + "/drivers/toList");
        }else {
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/addDriver.jsp").forward(request, response);
        }
    }
}
