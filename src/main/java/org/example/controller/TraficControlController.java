package org.example.controller;

import org.example.service.TrafficControlService;
import java.util.Scanner;

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
        System.out.println(" ");
        System.out.print("Input VehicleStatus: ");
        String v = scanner.nextLine();
        String t = scanner.nextLine();

        trafficControlService.filterByVehicleTypeAndStatus(v, t);


        System.out.println("\n--- TASK 3 ---");
        //trafficControlService.printAllVehicles();

    }

}
