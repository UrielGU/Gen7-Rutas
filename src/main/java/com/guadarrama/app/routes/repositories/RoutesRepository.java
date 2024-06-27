package com.guadarrama.app.routes.repositories;

import com.guadarrama.app.routes.models.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoutesRepository implements IRoutesRepository {
    private Connection connection;

    public RoutesRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long saveReturnId(Route route) throws SQLException {
        String sql = "";
        Long result = 1l;

        sql = "INSERT INTO ROUTES(ID_ROUTE, ID_TRUCK, ID_DRIVER, " +
                "ID_DEPARTUREDATE, ID_SOURCEADDRESS, ID_DESTINATIONADDRESS, DISTANCE, " +
                "DEPARTUREDATE, ESTIMATED_ARRIVAL_DATE, REAL_ARRIVAL_DATE, ON_TIME" +
                "VALUES (SEQUENCE4.NEXTVAL, ?,?,?,?,?,?,?,?,?";
        try (PreparedStatement statement = connection.prepareStatement(sql,
                new String[]{"ID_ROUTE"})){
            statement.setLong(1, route.getId_truck());
            statement.setLong(2, route.getId_driver());
            statement.setLong(3, route.getId_sourceAddress());
            statement.setLong(4, route.getId_destinationAddress());


        }return result;
    }

    @Override
    public List<Route> toList() throws SQLException {
        return List.of();
    }

    @Override
    public Route getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void save(Route route) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
