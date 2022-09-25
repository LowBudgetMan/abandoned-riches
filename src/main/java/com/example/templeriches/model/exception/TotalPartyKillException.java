package com.example.templeriches.model.exception;

import com.example.templeriches.model.room.hazard.HazardType;

public class TotalPartyKillException extends Exception{
    private final HazardType hazard;

    public TotalPartyKillException(HazardType hazard) {
        this.hazard = hazard;
    }

    public HazardType getHazardType() {
        return hazard;
    }
}
