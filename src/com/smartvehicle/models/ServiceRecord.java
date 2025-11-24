package com.smartvehicle.models;

// SCreating ServiceRecord model to store individual service entries

import java.time.LocalDate;

public class ServiceRecord {

    // Encapsulated fields
    private LocalDate serviceDate;
    private String description;
    private double cost;

    // Constructor
    public ServiceRecord(LocalDate serviceDate, String description, double cost) {
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    // Getters
    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return serviceDate + " - " + description + " | Cost: ₹" + cost;
    }
}
