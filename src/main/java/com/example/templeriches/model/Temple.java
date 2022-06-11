package com.example.templeriches.model;

import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.hazard.HazardRoom;

import java.util.List;
import java.util.Map;

public class Temple {
    private List<Room> rooms;
    private int currentRoom;
    private Map<HazardRoom, Integer> hazardRoomsRevealedCount;
}
