package com.guadarrama.app.routes.services;

import com.guadarrama.app.routes.models.Driver;
import com.guadarrama.app.routes.models.Route;
import com.guadarrama.app.routes.models.Truck;
import com.guadarrama.app.routes.repositories.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RouteService implements IRoutesService{

    private IRepository<Driver> driverRepository;
    private IRepository<Truck> truckRepository;
    private IRoutesRepository routesRepository;

    public RouteService(Connection connection) {
        this.driverRepository = new DriversRepository(connection);
        this.truckRepository = new TrucksRepository(connection);
        this.routesRepository = new RoutesRepository(connection);
    }

    @Override
    public List<Truck> listTrucks() {
        try {
            return truckRepository.toList();
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public List<Driver> listDrivers() {
        try {
            return driverRepository.toList();
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Long saveReturnID(Route route) {
        try {
            return routesRepository.saveReturnId(route);
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public List<Route> toList() {
        return List.of();
    }

    @Override
    public Optional<Route> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Route route) {

    }

    @Override
    public void delete(Long id) {

    }
}
