package com.example.templeriches.model.room.hazard;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RocksRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.ROCKS;
    }
}
