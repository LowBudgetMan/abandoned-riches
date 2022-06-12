package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class FireRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.FIRE;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.HAZARD;
    }
}
