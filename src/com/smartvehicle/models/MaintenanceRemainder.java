package com.smartvehicle.models;

import java.time.LocalDate;

public class MaintenanceRemainder {

    private String vin; // vehicle VIN
    private LocalDate dueDate; // next service date
    private String message; // reminder message

    public MaintenanceRemainder(String vin, LocalDate dueDate, String message) {
        this.vin = vin;
        this.dueDate = dueDate;
        this.message = message;
    }

    public String getVin() {
        return vin;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getMessage() {
        return message;
    }
}
