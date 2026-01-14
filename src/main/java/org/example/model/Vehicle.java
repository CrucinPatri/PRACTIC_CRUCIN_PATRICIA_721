package org.example.model;

public class Vehicle {
    private int id;
    private String licensePlate;
    private VehicleType vehicleType;
    private String ownerCity;
    private VehicleStatus vehicleStatus;

    public Vehicle() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getLicensePlate() {return licensePlate;}
    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}

    public VehicleType getVehicleType() {return vehicleType;}
    public void setVehicleType(VehicleType vehicleType) {this.vehicleType = vehicleType;}

    public String getOwnerCity() {return ownerCity;}
    public void setOwnerCity(String ownerCity) {this.ownerCity = ownerCity;}

    public VehicleStatus getVehicleStatus() {return vehicleStatus;}
    public void setVehicleStatus(VehicleStatus vehicleStatus) {this.vehicleStatus = vehicleStatus;}
}
