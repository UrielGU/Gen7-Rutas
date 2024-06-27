package com.guadarrama.app.routes.repositories;

import com.guadarrama.app.routes.models.Route;

import java.sql.SQLException;

public interface IRoutesRepository extends IRepository<Route> {
    Long saveReturnId(Route route) throws SQLException;
}
