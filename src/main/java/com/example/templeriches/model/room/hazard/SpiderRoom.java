package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpiderRoom implements HazardRoom{
    @Override
    public HazardType getHazardType() {
        return HazardType.SPIDER;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.HAZARD;
    }
}
