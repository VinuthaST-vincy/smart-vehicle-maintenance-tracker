package com.smartvehicle.service;

import java.util.ArrayList;
import java.util.List;

import com.smartvehicle.api.VinLookupService;
import com.smartvehicle.exceptions.InvalidVinException;
import com.smartvehicle.models.Vehicle;

/**
 * VehicleManager Class
 * -----------------------------------------
 * This class manages all vehicle operations:
 * - Adding vehicles
 * - Searching vehicles
 * - Fetching details using VIN API
 * - Displaying all vehicles
 *
 * This demonstrates:
 * ✔ Collection (ArrayList)
 * ✔ Encapsulation
 * ✔ Composition (VehicleManager uses VIN Lookup)
 * ✔ Abstraction (Hides internal logic from main class)
 */

public class VehicleManager {

    // List to store vehicle objects
    // vehicleList is private and accessed only through methods(Encapsulation)
    // Collections framework(List,Vehicle> vehicleList = new ArrayList<>();)
    private List<Vehicle> vehicleList = new ArrayList<>();

    // Composition: VehicleManager uses VinLookupService
    // The user does not seehow VIN Lookup works internally(Abstraction)
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
     * This method fetches vehicle details using the VIN
     */
    public void addVehicle(String vin) {
        try {
            // Fetch details from simulated VIN API
            Vehicle v = vinService.fetchVehicleDetails(vin);
            vehicleList.add(v);

            System.out.println("Vehicle added via VIN Lookup!");
        } catch (InvalidVinException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Method 3: Search vehicle by VIN
     */
    public Vehicle searchByVin(String vin) {
        for (Vehicle v : vehicleList) {
            if (v.getVin().equals(vin)) {
                return v; // Vehicle found
            }
        }
        System.out.println("Vehicle not found!");
        return null;
    }

    /**
     * Method 4: Display all stored vehicles
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
