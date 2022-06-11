package com.example.templeriches.model.room.hazard;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpiderRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.SPIDER;
    }
}
