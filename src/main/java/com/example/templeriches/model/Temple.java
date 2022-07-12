package com.example.templeriches.model;

import com.example.templeriches.model.exception.NoMoreRoomsException;
import com.example.templeriches.model.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Temple {
    private final List<Room> rooms;
    private final ArrayList<Player> playersInTemple;
    private int currentRoom;

    public Temple(List<Room> rooms, List<Player> playersInTemple) {
        this.rooms = rooms;
        this.playersInTemple = new ArrayList<>(playersInTemple);
    }

    public int getNumberOfRooms() {
        return rooms.size();
    }

    public Optional<Room> getCurrentRoom() {
        try {
            return Optional.of(rooms.get(currentRoom - 1));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public void advanceToNextRoom() throws NoMoreRoomsException {
        try {
            rooms.get(currentRoom).openRoom(playersInTemple);
            currentRoom = currentRoom + 1;
        } catch (IndexOutOfBoundsException e) {
            throw new NoMoreRoomsException();
        }
    }

    public void retreatPlayersFromTemple(List<Player> players) {
        rooms.subList(0, currentRoom).forEach(room -> room.exitRoom(players));
        for(var player : players) {
            player.moveTempleHaulToStorage();
            playersInTemple.remove(player);
        }
    }

    //TODO: Add method to show already revealed rooms

    //TODO: Add method to see how many Trinkets are left over
}
