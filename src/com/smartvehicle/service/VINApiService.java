package com.smartvehicle.service;

import com.smartvehicle.models.Vehicle;

// This class simulates calling a VIN Lookup API
public class VINApiService {

    // Method 1 - basic lookup (method overloading)
    public Vehicle decodeVIN(String vin) {
        // Simulated API response
        Vehicle v = new Vehicle();
        v.setVin(vin);
        v.setMake("Toyota");
        v.setModel("Camry");
        v.setYear(2020);
        v.setOwnerName("Unknown (From VIN API)");
        return v;
    }

    // Method 2 - overloaded (returns JSON or raw API response)
    public String decodeVIN(String vin, boolean rawResponse) {

        if (rawResponse) {
            // Simulated JSON
            return "{ 'make': 'Toyota', 'model': 'Camry', 'year': 2020 }";
        }

        return "Invalid parameter!";
    }
}
