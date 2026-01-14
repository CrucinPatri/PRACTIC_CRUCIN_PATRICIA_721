package org.example.service;

import org.example.model.*;
import org.example.repository.VehicleRepository;
import org.example.repository.FineRepository;
import org.example.repository.TrafficEventRepository;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class TrafficControlService {
    private List<Vehicle> vehicles;
    private List<Fine> fines;
    private List<TrafficEvent> events;
    private final VehicleRepository vehicleRepository;
    private final FineRepository fineRepository;
    private final TrafficEventRepository trafficEventRepository;

    public TrafficControlService() {this.vehicleRepository = new VehicleRepository();
    this.fineRepository = new FineRepository();
    this.trafficEventRepository = new TrafficEventRepository();
    }

    public void loadData(){
        this.vehicles = vehicleRepository.loadVehicles("vehicles.json");
        this.events = trafficEventRepository.loadTrafficEvents("events.json");
        this.fines = fineRepository.loadFines("fines.json");

        System.out.println("Vehicles loaded:" + vehicles.size());
        System.out.println("Fines loaded:" + fines.size());
        System.out.println("Traffic events loaded:" + events.size());
    }

    public void printAllVehicles(){
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public void filterByVehicleTypeAndStatus(String vehicleType, String status){
        System.out.println("Vehicle Type : " + vehicleType);
        System.out.println("\nVehicle Status : " + status);
        vehicles.stream()
                .filter(v -> v.getVehicleType().equals(vehicleType) && v.getVehicleStatus() == VehicleStatus.ACTIVE)
                .forEach(System.out::println);


    }

}
