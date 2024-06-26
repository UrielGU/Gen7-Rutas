package com.guadarrama.app.routes.repositories;

import java.sql.SQLException;
import java.util.List;

//vamos a usar una interface cuando más de una clase implementa los mismos métodos, de manera diferente
public interface IRepository<T> {
    List<T> toList () throws SQLException;
    T getById(Long id) throws SQLException;
    void save(T t) throws SQLException;
    void delete(Long id) throws SQLException;
}
