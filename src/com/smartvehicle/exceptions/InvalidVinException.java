package com.smartvehicle.exceptions;

//Custom Exception for Invalid VIN
public class InvalidVinException extends Exception {
    public InvalidVinException(String message) {
        super(message);
    }

}
