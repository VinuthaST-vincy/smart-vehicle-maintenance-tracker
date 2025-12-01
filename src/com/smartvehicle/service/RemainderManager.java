package com.smartvehicle.service;

import com.smartvehicle.models.Vehicle;
import com.smartvehicle.models.MaintenanceRemainder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RemainderManager {

    // Generate a remainder if service is due soon
    public MaintenanceRemainder checkRemainder(Vehicle vehicle) {
        LocalDate nextService = vehicle.getNextServiceDate();
        LocalDate today = LocalDate.now();

        if (nextService == null) {
            return null;
        }

        // If service is withins

    }

}
