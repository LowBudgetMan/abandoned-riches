package com.example.templeriches.model.temple;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.exception.NoMoreRoomsException;
import com.example.templeriches.model.exception.TotalPartyKillException;
import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.valuable.TrinketRoom;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode
@ToString
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

    public void advanceToNextRoom() throws NoMoreRoomsException, TotalPartyKillException {
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

    public long getNumberOfTrinketsLeft() {
        return rooms.stream()
                .filter(room -> room instanceof TrinketRoom)
                .map(room -> (TrinketRoom) room)
                .filter(TrinketRoom::hasTrinket)
                .count();
    }

    //TODO: Add method to show already revealed rooms
}
