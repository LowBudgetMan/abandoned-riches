package com.example.templeriches.model;

import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.hazard.HazardRoom;
import com.example.templeriches.model.room.hazard.HazardTracker;
import com.example.templeriches.model.room.hazard.HazardType;
import com.example.templeriches.model.room.valuable.GemRoom;
import com.example.templeriches.model.room.valuable.TrinketRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempleFactory {

    private final RoomShuffler roomShuffler;
    private static final List<Room> gemRoomList = List.of(
            new GemRoom(17),
            new GemRoom(15),
            new GemRoom(14),
            new GemRoom(13),
            new GemRoom(11),
            new GemRoom(11),
            new GemRoom(9),
            new GemRoom(7),
            new GemRoom(7),
            new GemRoom(5),
            new GemRoom(5),
            new GemRoom(4),
            new GemRoom(3),
            new GemRoom(2),
            new GemRoom(1)
    );

    public TempleFactory(RoomShuffler roomShuffler) {
        this.roomShuffler = roomShuffler;
    }

    public Temple create(TempleOptions options, List<Player> players) {
        var hazardTracker = new HazardTracker();
        List<Room> roomsList = new ArrayList<>(gemRoomList);
        addHazardRooms(hazardTracker, HazardType.FIRE, options.fireHazardCount, roomsList);
        addHazardRooms(hazardTracker, HazardType.ROCKS, options.rocksHazardCount, roomsList);
        addHazardRooms(hazardTracker, HazardType.SNAKE, options.snakesHazardCount, roomsList);
        addHazardRooms(hazardTracker, HazardType.SPIDER, options.spiderHazardCount, roomsList);
        addHazardRooms(hazardTracker, HazardType.ZOMBIE, options.zombieHazardCount, roomsList);
        addTrinketRooms(options.trinketCount, roomsList);
        roomsList = roomShuffler.shuffle(roomsList);
        return new Temple(roomsList, players);
    }

    private void addHazardRooms(HazardTracker hazardTracker, HazardType hazardType, int hazardCount, List<Room> roomsList) {
        for (int count = 0; count < hazardCount; count++) {
            roomsList.add(new HazardRoom(hazardTracker, hazardType));
        }
    }

    private void addTrinketRooms(int trinketCount, List<Room> roomsList) {
        for (int count = 0; count < trinketCount; count++) {
            roomsList.add(new TrinketRoom());
        }
    }
}
