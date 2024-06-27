package com.guadarrama.app.routes.models;

import java.time.LocalDate;

public class Route {
    private Long id_route;
    private Long id_truck;
    private Long id_driver;
    private Long id_sourceAddress;
    private Long id_destinationAddress;
    private Float distance;
    private LocalDate departureDate;
    private LocalDate estimatedArrivalDate;
    private Integer onTime;

    public Long getId_route() {
        return id_route;
    }

    public void setId_route(Long id_route) {
        this.id_route = id_route;
    }

    public Long getId_truck() {
        return id_truck;
    }

    public void setId_truck(Long id_truck) {
        this.id_truck = id_truck;
    }

    public Long getId_driver() {
        return id_driver;
    }

    public void setId_driver(Long id_driver) {
        this.id_driver = id_driver;
    }

    public Long getId_sourceAddress() {
        return id_sourceAddress;
    }

    public void setId_sourceAddress(Long id_sourceAddress) {
        this.id_sourceAddress = id_sourceAddress;
    }

    public Long getId_destinationAddress() {
        return id_destinationAddress;
    }

    public void setId_destinationAddress(Long id_destinationAddress) {
        this.id_destinationAddress = id_destinationAddress;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(LocalDate estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }
}
