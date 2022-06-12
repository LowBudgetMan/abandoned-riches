package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SnakeRoom implements HazardRoom {
    @Override
    public HazardType getHazardType() {
        return HazardType.SNAKE;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.HAZARD;
    }
}
