package com.example.templeriches.model;

import com.example.templeriches.model.exception.NoMoreRoomsException;
import com.example.templeriches.model.room.Room;

import java.util.List;
import java.util.Optional;

public class Temple {
    private final List<Room> rooms;
    private int currentRoom;

    public Temple(List<Room> rooms) {
        this.rooms = rooms;
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

    public void advanceToNextRoom(List<Player> players) throws NoMoreRoomsException {
            try {
                rooms.get(currentRoom).openRoom(players);
                currentRoom = currentRoom + 1;
            } catch (IndexOutOfBoundsException e) {
                throw new NoMoreRoomsException();
            }
    }

    //TODO: Add method to have people leave the temple

    //TODO: Add method to show already revealed rooms

    //TODO: Add method to see how many Trinkets are left over
}
