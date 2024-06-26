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
import java.util.List;

//Servlet son objetos (como las clases controllers) que se encargan de recibir las peticiones
//del usuario
@WebServlet("/drivers/toList")
public class DriversListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //We get the connection provided by the filter
        Connection connection = (Connection) request.getAttribute("connection");
        //We declarate an object from Service
        IService<Driver> service = new DriversService(connection);
        List<Driver> drivers = service.toList();
        //response.getWriter().println();
        /*drivers.forEach(driver->{response.getWriter().println("<h1>" + driver.getId_drver()
                + " -> " + driver.getName() + " -> " + driver.getSurname() + "</h1>"});
        for(Driver driver : drivers)
            response.getWriter().println();*/

        request.setAttribute("drivers", drivers);
        getServletContext().getRequestDispatcher("/driversList.jsp").forward(request,response);

    }
}
