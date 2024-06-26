package com.guadarrama.app.routes.services;

import java.util.List;
import java.util.Optional;

public interface IService<T>{
    List<T> toList();
    Optional<T> getByID(Long id);
    void save(T t);
    void delete(T t);
}
