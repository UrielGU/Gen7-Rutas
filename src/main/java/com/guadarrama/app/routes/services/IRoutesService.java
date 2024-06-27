package com.guadarrama.app.routes.services;

import com.guadarrama.app.routes.models.Driver;
import com.guadarrama.app.routes.models.Route;
import com.guadarrama.app.routes.models.Truck;

import java.util.List;

public interface IRoutesService extends IService<Route> {
    List<Truck> listTrucks();
    List<Driver> listDrivers();
    Long saveReturnID(Route route);

}
