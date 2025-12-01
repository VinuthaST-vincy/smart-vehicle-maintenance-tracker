package com.smartvehicle.service;

import java.util.ArrayList;
import java.util.List;

import com.smartvehicle.api.VinLookupService;
import com.smartvehicle.exceptions.InvalidVinException;
import com.smartvehicle.models.Vehicle;

public class VehicleManager {

    // List to store vehicles
    private List<Vehicle> vehicleList = new ArrayList<>();

    // VIN Lookup service (Composition)
    private VinLookupService vinService = new VinLookupService();

    /**
     * Method 1: Add a manually created vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    /**
     * Method 2: Add a vehicle using VIN Lookup API
     * STEP 5.2 IMPLEMENTED ✔
     */
    public Vehicle addVehicleUsingVIN(String vin) {
        try {
            // Fetch details from simulated VIN API
            Vehicle v = vinService.fetchVehicleDetails(vin);

            // Add to list
            vehicleList.add(v);

            System.out.println("Vehicle added using VIN Lookup!");
            return v;

        } catch (InvalidVinException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Search vehicle by VIN
     */
    public Vehicle searchByVin(String vin) {
        for (Vehicle v : vehicleList) {
            if (v.getVin().equals(vin)) {
                return v;
            }
        }
        System.out.println("Vehicle not found!");
        return null;
    }

    /**
     * Display all stored vehicles
     */
    public void displayAllVehicles() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles stored yet.");
            return;
        }

        System.out.println("------ Stored Vehicles ------");
        for (Vehicle v : vehicleList) {
            v.displayVehicleInfo();
        }
    }
}
