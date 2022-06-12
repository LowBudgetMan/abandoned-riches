package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RocksRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.ROCKS;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.HAZARD;
    }
}
