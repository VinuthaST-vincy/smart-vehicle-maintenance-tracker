package com.smartvehicle.service;

import java.time.LocalDate;

import com.smartvehicle.models.MaintenanceRemainder;
import com.smartvehicle.models.Vehicle;

public class RemainderManager {

    // This method checks if the vehicle’s next service date is near.
    public MaintenanceRemainder checkRemainder(Vehicle vehicle) {

        LocalDate nextService = vehicle.getNextServiceDate();
        LocalDate today = LocalDate.now();

        // If next service date is not set
        if (nextService == null) {
            return null;
        }

        // Calculate days left for service
        long daysLeft = java.time.temporal.ChronoUnit.DAYS.between(today, nextService);

        // If service is within 15 days, generate a remainder
        if (daysLeft <= 15 && daysLeft >= 0) {
            return new MaintenanceRemainder(
                    vehicle.getVin(),
                    nextService,
                    "Service due in " + daysLeft + " days!");
        }

        // If service is overdue
        if (daysLeft < 0) {
            return new MaintenanceRemainder(
                    vehicle.getVin(),
                    nextService,
                    "⚠ Your service is OVERDUE by " + Math.abs(daysLeft) + " days!");
        }

        // No remainder needed
        return null;
    }
}
