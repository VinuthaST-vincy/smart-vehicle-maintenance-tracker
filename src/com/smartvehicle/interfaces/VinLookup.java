package com.smartvehicle.interfaces;

//This defined what service must do.
import com.smartvehicle.models.Vehicle;

public interface VinLookup {
    Vehicle fetchVehicleDetails(String vin) throws Exception;

}
