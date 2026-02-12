package org.example.controller;

import org.example.model.TrafficEvent;
import org.example.model.VehicleType;
import org.example.model.VehicleStatus;
import org.example.model.Vehicle;
import org.example.service.TrafficControlService;
import java.util.Scanner;
import java.util.List;

public class TraficControlController {
    private final TrafficControlService trafficControlService;

    public TraficControlController() {this.trafficControlService = new TrafficControlService();}

    public void run(){
        System.out.println("--- TASK 1 ---");
        trafficControlService.loadData();
        trafficControlService.printAllVehicles();

        // Cerinta 2: filter input
        System.out.println("\n--- TASK 2 ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input VehicleType: ");
        String v = scanner.nextLine().trim();
        System.out.print("Input VehicleStatus: ");
        String t = scanner.nextLine().trim();

        // convert inputs to enums and call the service method and print results
        try {
            VehicleType vt = VehicleType.valueOf(v.toUpperCase());
            VehicleStatus vs = VehicleStatus.valueOf(t.toUpperCase());
            List<Vehicle> filtered = trafficControlService.filterByVehicleTypeAndStatus(vt, vs);
            if (filtered == null || filtered.isEmpty()) {
                System.out.println("No vehicles matched the filter.");
            } else {
                filtered.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid vehicle type or status provided.");
        }


        System.out.println("\n--- TASK 3 ---");
        //foloseste aici metoda de sortare sortCarsByOwnerandCItyId
        List<Vehicle> sortedVehicles = trafficControlService.sortCarsByOwnerCityAndId();
        if(sortedVehicles.isEmpty()){
            System.out.println("No vehicles to sort.");
        }else{
            sortedVehicles.forEach(System.out::println);
        }

        // --- TASK 4 ---
        System.out.println("\n--- TASK 4 ---");
        // Salvăm lista sortată obținută la Task 3 în fișierul cerut
        trafficControlService.saveVehiclesToFile(sortedVehicles, "vehicles_sorted.txt");

        // --- TASK 5 ---
        System.out.println("\n--- TASK 5 ---");
        List<TrafficEvent> firstFive = trafficControlService.getFirstFiveEvents();

        for(TrafficEvent e: firstFive){
            int riskScore = e.calculateRiskScore();
            System.out.println("Event " + e.getId() +
                    " -> severity=" + e.getSeverity() +
                    " -> riskScore=" + riskScore);
        }
    }

}
