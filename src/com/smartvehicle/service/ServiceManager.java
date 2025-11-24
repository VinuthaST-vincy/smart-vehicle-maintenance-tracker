package com.smartvehicle.service;

import java.time.LocalDate;
import com.smartvehicle.models.ServiceRecord;
import com.smartvehicle.models.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class ServiceManager {

    // Field list to store service records
    private List<ServiceRecord> serviceRecords = new ArrayList<>();

    public void addServiceRecord(ServiceRecord record) {
        serviceRecords.add(record);

    }

    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecords;
    }

    // Add a new service entry
    public void recordService(Vehicle vehicle, String description, double cost) {
        ServiceRecord record = new ServiceRecord(LocalDate.now(), description, cost);
        vehicle.addServicesRecord(record);
    }

    // Overloaded method (method overloading)
    public void recordService(Vehicle vehicle, LocalDate date, String description, double cost) {
        ServiceRecord record = new ServiceRecord(date, description, cost);
        vehicle.addServicesRecord(record);
    }

    // Show service history
    public void printServiceHistory(Vehicle vehicle) {
        System.out.println("\nService History for " + vehicle.getMake() + " " + vehicle.getModel());
        for (ServiceRecord rec : vehicle.getServiceHistory()) {
            System.out.println(rec);
        }
    }
}
