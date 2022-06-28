package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.RoomType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HazardRoom implements Room {

    private final HazardTracker hazardTracker;
    private final HazardType hazardType;

    public HazardRoom(HazardTracker hazardTracker, HazardType hazardType) {
        this.hazardTracker = hazardTracker;
        this.hazardType = hazardType;
    }

    public HazardType getHazardType() {
        return hazardType;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.HAZARD;
    }

    @Override
    public void openRoom() {
        hazardTracker.incrementCount(hazardType);
    }
}
