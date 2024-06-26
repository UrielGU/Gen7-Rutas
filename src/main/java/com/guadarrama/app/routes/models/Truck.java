package com.guadarrama.app.routes.models;

import com.guadarrama.app.routes.models.enums.TruckBrands;
import com.guadarrama.app.routes.models.enums.TruckTypes;

public class Truck {
    private Long id_truck;
    private String licencePlate;
    private TruckTypes truckType;
    private Integer model;
    private TruckBrands truckBrand;
    private Integer capacity;
    private Double mileage;
    private Boolean availability;

    public Long getId_truck() {
        return id_truck;
    }

    public void setId_truck(Long id_truck) {
        this.id_truck = id_truck;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public TruckTypes getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckTypes truckType) {
        this.truckType = truckType;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public TruckBrands getTruckBrand() {
        return truckBrand;
    }

    public void setTruckBrand(TruckBrands truckBrand) {
        this.truckBrand = truckBrand;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
