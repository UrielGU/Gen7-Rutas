package com.guadarrama.app.routes.controllers;

import com.guadarrama.app.routes.models.Truck;
import com.guadarrama.app.routes.models.enums.TruckBrands;
import com.guadarrama.app.routes.models.enums.TruckTypes;
import com.guadarrama.app.routes.services.IService;
import com.guadarrama.app.routes.services.TrucksService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class AddTruckServler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addTruck.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (Connection) request.getAttribute("connection");

        IService<Truck> service = new TrucksService(connection);

        String licencePlate =request.getParameter("licencePlate");
        String truckType = request.getParameter("truckType");
        String model = request.getParameter("model");
        String truckBrand = request.getParameter("truckBrand");
        String capacity = request.getParameter("capacity");
        String mileage = request.getParameter("mileage");

        String checkbox[];
        checkbox=request.getParameterValues("availability");
        Boolean habilitar;
        if(checkbox!=null){
            habilitar=true;
        }
        else{
            habilitar=false;
        }

        Map<String, String> errors = new HashMap<>();
        if(licencePlate == null || licencePlate.isBlank())
            errors.put("licencePlate: ", "No se ha ingresado la matrícula del Camión!");
        if(truckType == null || truckType.isBlank())
            errors.put("truckType: ", "No se ha ingresado el tipo de Camión!");
        if(model == null || model.isBlank())
            errors.put("model: ", "No se ha ingresado el modelo del Camión!");
        if(truckBrand == null || truckBrand.isBlank())
            errors.put("truckBrand: ", "No se ha ingresado la marca del Camión!");
        if(capacity == null || capacity.isBlank())
            errors.put("capacity: ", "No se ha ingresado la capacidad del Camión!");
        if(mileage == null || mileage.isBlank())
            errors.put("mileage: ", "No se ha ingresado el kilometraje del Camión!");

        if (errors.isEmpty()){
            Truck truck = new Truck();
            truck.setId_truck(0L);
            truck.setLicencePlate(licencePlate);
            truck.setTruckType(TruckTypes.valueOf(truckType));
            truck.setModel(Integer.valueOf(model));
            truck.setTruckBrand(TruckBrands.valueOf(truckBrand));
            truck.setCapacity(Integer.valueOf(capacity));
            truck.setMileage(Double.valueOf(mileage));
            truck.setAvailability(habilitar);
            service.save(truck);
            response.sendRedirect(request.getContextPath()+"/trucks/toList");
        }else {
            request.setAttribute("errors: ", errors);
            getServletContext().getRequestDispatcher("/addTruck.jsp").forward(request, response);
        }
    }
}
