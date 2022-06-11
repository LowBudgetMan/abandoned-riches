package com.example.templeriches.model.room.hazard;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class FireRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.FIRE;
    }
}
