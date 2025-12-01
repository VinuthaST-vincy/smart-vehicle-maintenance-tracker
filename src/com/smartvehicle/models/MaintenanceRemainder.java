package com.smartvehicle.models;

import java.time.LocalDate;

public class MaintenanceRemainder {

    private String message;
    private LocalDate dueDate;

    public MaintenanceRemainder(String message, LocalDate dueDate) {
        this.message = message;
        this.dueDate = dueDate;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return message + " | Due: " + dueDate;
    }
}
