package com.example.templeriches.model.room;

import com.example.templeriches.model.Player;

import java.util.List;

public interface Room {
    RoomType getRoomType();
    // My theory is that if everything can be handled by the room interface, interactions will be much easier
    //TODO: Add method for opening a room
    void openRoom(List<Player> players);

    //TODO: Add method for leaving a room
//    void exitRoom();
}
