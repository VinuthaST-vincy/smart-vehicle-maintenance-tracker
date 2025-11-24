package com.smartvehicle.api;

//Simulated a real-world VIN API response.
import com.smartvehicle.interfaces.VinLookup;
import com.smartvehicle.models.Vehicle;
import com.smartvehicle.exceptions.InvalidVinException;

public class VinLookupService implements VinLookup {

    @Override
    public Vehicle fetchVehicleDetails(String vin) throws InvalidVinException {

        // Validate VIN Format
        if (vin == null || vin.length() != 17) {
            throw new InvalidVinException("VIN must be exactly 17 characters.");
        }

        // -------- Simulated API Output --------
        // Later this will be replaced with a real VIN API (Step 10)
        System.out.println("Fetching data from VIN API... (simulated)");

        // Dummy data map - Replace with API response later
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(vin);
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setYear(2020);
        vehicle.setOwnerName("Unknown");

        return vehicle;
    }
}
