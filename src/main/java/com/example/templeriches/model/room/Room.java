package com.example.templeriches.model.room;

import com.example.templeriches.model.Player;

import java.util.List;

public interface Room {
    RoomType getRoomType();
    void openRoom(List<Player> players);
    void exitRoom(List<Player> players);
}
