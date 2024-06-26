package com.guadarrama.app.routes.services;

import com.guadarrama.app.routes.models.Truck;
import com.guadarrama.app.routes.repositories.IRepository;
import com.guadarrama.app.routes.repositories.TrucksRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TrucksService implements IService<Truck> {
    private IRepository<Truck> truckRepository;

    public TrucksService(Connection connection) {
        truckRepository = new TrucksRepository(connection);
    }

    @Override
    public List<Truck> toList() {
        try {
            return truckRepository.toList();
        }catch (SQLException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Truck> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Truck truck) {
        try{
            truckRepository.save(truck);
        }catch (SQLException e){
            throw  new RuntimeException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void delete(Truck truck) {

    }
}
