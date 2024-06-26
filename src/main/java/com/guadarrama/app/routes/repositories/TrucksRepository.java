package com.guadarrama.app.routes.repositories;

import com.guadarrama.app.routes.models.Truck;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TrucksRepository implements IRepository<Truck>{
    private Connection connection;

    public TrucksRepository(Connection connection){
        this.connection = connection;
    }

    @Override
    public List toList() throws SQLException {
        return List.of();
    }

    @Override
    public Truck getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void save(Truck truck) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
