package com.guadarrama.app.routes.services;

import com.guadarrama.app.routes.models.Driver;
import com.guadarrama.app.routes.repositories.DriversRepository;
import com.guadarrama.app.routes.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DriversService implements IService<Driver> {
    private IRepository<Driver> driversRepository;

    public DriversService(Connection connection) {
        this.driversRepository = new DriversRepository(connection);
    }

    @Override
    public List<Driver> toList() {
        try {
            return driversRepository.toList();
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }


    @Override
    public Optional<Driver> getByID(Long id) {
        try {
            return Optional.ofNullable(driversRepository.getById(id));
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void save(Driver driver) {
        try {
            driversRepository.save(driver);
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void delete(Driver driver) {
        try{
           driversRepository.delete(driver.getId_driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
