package com.example.templeriches.model.room;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.exception.TotalPartyKillException;

import java.util.List;

public interface Room {
    RoomType getRoomType();
    void openRoom(List<Player> players) throws TotalPartyKillException;
    void exitRoom(List<Player> players);
}
