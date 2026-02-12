package org.example.service;

import org.example.model.*;
import org.example.repository.VehicleRepository;
import org.example.repository.FineRepository;
import org.example.repository.TrafficEventRepository;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TrafficControlService {
    private List<Vehicle> vehicles;
    private List<TrafficEvent> events;
    private final VehicleRepository vehicleRepository;
    private final FineRepository fineRepository;
    private final TrafficEventRepository trafficEventRepository;

    public TrafficControlService() {
        this.vehicleRepository = new VehicleRepository();
        this.fineRepository = new FineRepository();
        this.trafficEventRepository = new TrafficEventRepository();
    }

    public void loadData() {
        this.vehicles = vehicleRepository.loadVehicles("vehicles.json");
        List<TrafficEvent> events = trafficEventRepository.loadTrafficEvents("events.json");
        List<Fine> fines = fineRepository.loadFines("fines.json");

        System.out.println("Vehicles loaded:" + vehicles.size());
        System.out.println("Fines loaded:" + fines.size());
        System.out.println("Traffic events loaded:" + events.size());
    }

    public void printAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public List<Vehicle> filterByVehicleTypeAndStatus(VehicleType vehicleType, VehicleStatus status) {
        return vehicles.stream()
                       .filter(vehicle -> vehicle.getType().equals(vehicleType) && vehicle.getStatus().equals(status))
                       .toList();
    }

    //  METODA PENTRU SORTAREA AUTOTURISMELOR CRESCATOR DUPA ownerCity si tot la acelasi ownerCity descrescator dupa id
    public List<Vehicle> sortCarsByOwnerCityAndId() {
        return vehicles.stream()
               // .filter(vehicle -> vehicle.getType() == VehicleType.CAR)
                .sorted(Comparator.comparing(Vehicle::getOwnerCity)
                        .thenComparing(Comparator.comparing(Vehicle::getId).reversed()))
                .toList();
    }

//    4. (1 Punkt)  Schreiben in eine Datei
//    Schreiben Sie die in Aufgabe 3 sortierte Liste der
//    Fahrzeuge in die Datei vehicles_sorted.txt. Jeder
//    Fahrzeuge soll in einer eigenen Zeile gespeichert werden,
//    im selben Format wie bei der Konsolenausgabe.
    public void saveVehiclesToFile(List<Vehicle> sortedVehicles, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : sortedVehicles) {
                writer.write(vehicle.toString());
                writer.newLine(); // Adaugă o linie nouă după fiecare vehicul
            }
            System.out.println("Successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public List<TrafficEvent> getFirstFiveEvents() {
        // events este lista încărcată în loadData()
        if (this.events == null) {
            return new ArrayList<>();
        }
        return this.events.stream()
                .limit(5)
                .toList();
    }


}
