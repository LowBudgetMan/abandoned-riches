package com.example.templeriches.model.room.hazard;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SnakeRoom implements HazardRoom {
    @Override
    public HazardType getHazardType() {
        return HazardType.SNAKE;
    }
}
