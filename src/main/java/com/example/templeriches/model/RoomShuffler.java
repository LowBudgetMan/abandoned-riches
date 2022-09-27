package com.example.templeriches.model;

import com.example.templeriches.model.room.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomShuffler {

    public List<Room> shuffle(List<Room> roomsToShuffle) {
        var arrayToShuffle = new ArrayList<>(roomsToShuffle);
        Collections.shuffle(arrayToShuffle);
        return arrayToShuffle;
    }

}
