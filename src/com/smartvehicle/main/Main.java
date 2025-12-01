package com.smartvehicle.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.smartvehicle.models.Vehicle;
import com.smartvehicle.service.VehicleManager;
import com.smartvehicle.service.ServiceManager;
import com.smartvehicle.service.RemainderManager;
import com.smartvehicle.models.MaintenanceRemainder;

public class Main {

    public static void main(String[] args) {

        // Managers (Abstraction)
        VehicleManager vehicleManager = new VehicleManager();
        ServiceManager serviceManager = new ServiceManager();
        RemainderManager remainderManager = new RemainderManager();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SMART VEHICLE MAINTENANCE TRACKER =====");
            System.out.println("1. Add Vehicle Manually");
            System.out.println("2. Add Vehicle Using VIN Lookup");
            System.out.println("3. View All Vehicles");
            System.out.println("4. Search Vehicle by VIN");
            System.out.println("5. Add Service Record to Vehicle");
            System.out.println("6. Check Service Remainder");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    // Add manually
                    System.out.print("Enter VIN (17 characters): ");
                    String manualVin = sc.nextLine();

                    System.out.print("Enter Make: ");
                    String make = sc.nextLine();

                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    Vehicle v1 = new Vehicle(manualVin, make, model, year, owner);
                    vehicleManager.addVehicle(v1);

                    break;

                case 2:
                    // VIN API Add
                    System.out.print("Enter VIN: ");
                    String vin = sc.nextLine();

                    vehicleManager.addVehicleUsingVIN(vin);
                    break;

                case 3:
                    // Display all vehicles
                    vehicleManager.displayAllVehicles();
                    break;

                case 4:
                    // Search
                    System.out.print("Enter VIN to search: ");
                    String searchVin = sc.nextLine();

                    Vehicle found = vehicleManager.searchByVin(searchVin);
                    if (found != null) {
                        found.displayVehicleInfo();
                    }
                    break;

                case 5:
                    // Add service record
                    System.out.print("Enter VIN: ");
                    String serviceVin = sc.nextLine();

                    Vehicle serviceVehicle = vehicleManager.searchByVin(serviceVin);

                    if (serviceVehicle == null) {
                        System.out.println("Vehicle not found!");
                        break;
                    }

                    System.out.print("Enter Service Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Cost: ");
                    double cost = sc.nextDouble();
                    sc.nextLine();

                    serviceManager.recordService(serviceVehicle, desc, cost);
                    System.out.println("Service record added.");

                    // Set next service date (default: +6 months)
                    serviceVehicle.setNextServiceDate(LocalDate.now().plusMonths(6));

                    break;

                case 6:
                    // Remainder
                    System.out.print("Enter VIN: ");
                    String remVin = sc.nextLine();

                    Vehicle remVehicle = vehicleManager.searchByVin(remVin);

                    if (remVehicle == null) {
                        System.out.println("Vehicle not found!");
                        break;
                    }

                    MaintenanceRemainder rem = remainderManager.checkRemainder(remVehicle);

                    if (rem != null) {
                        System.out.println("\n--- REMAINDER ALERT ---");
                        System.out.println(rem.getMessage());
                        System.out.println("Next Service Date: " + rem.getDueDate());

                    } else {
                        System.out.println("No remainder. Service is not due soon.");
                    }

                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
