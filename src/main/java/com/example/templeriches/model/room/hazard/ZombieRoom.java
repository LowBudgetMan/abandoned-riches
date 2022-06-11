package com.example.templeriches.model.room.hazard;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ZombieRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.ZOMBIE;
    }
}
