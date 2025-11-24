package com.smartvehicle.models;

public class Vehicle {

    // Encapsulation: Private variables
    private String vin;
    private String make;
    private String model;
    private int year;
    private String ownerName;

    // Default Constructor
    public Vehicle() {
        System.out.println("Vehicle object created.");
    }

    // Parameterized Constructor
    public Vehicle(String vin, String make, String model, int year, String ownerName) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerName = ownerName;
    }

    // Getters & Setters (Encapsulation)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        if (vin.length() == 17) { // Basic VIN validation
            this.vin = vin;
        } else {
            System.out.println("Invalid VIN! VIN must be 17 characters.");
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1990 && year <= 2025) {
            this.year = year;
        } else {
            System.out.println("Invalid year! Must be between 1990 and 2025.");
        }
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Utility method
    public void displayVehicleInfo() {
        System.out.println("----- Vehicle Details -----");
        System.out.println("VIN: " + vin);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Owner: " + ownerName);
        System.out.println("---------------------------");
    }
}
