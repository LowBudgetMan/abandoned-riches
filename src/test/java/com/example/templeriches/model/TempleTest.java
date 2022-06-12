package com.example.templeriches.model;

import com.example.templeriches.model.exception.NoMoreRoomsException;
import com.example.templeriches.model.room.hazard.RocksRoom;
import com.example.templeriches.model.room.hazard.ZombieRoom;
import com.example.templeriches.model.room.valuable.GemRoom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TempleTest {

    @Test
    public void getNumberOfRooms_ReturnsNumberOfRoomsProvided() {
        var empty = new Temple(List.of());
        var one = new Temple(List.of(new ZombieRoom()));
        var many = new Temple(List.of(new GemRoom(2), new RocksRoom()));

        assertThat(empty.getNumberOfRooms()).isEqualTo(0);
        assertThat(one.getNumberOfRooms()).isEqualTo(1);
        assertThat(many.getNumberOfRooms()).isEqualTo(2);
    }

    @Test
    public void getCurrentRoom_WhenRoomsHaveNotAdvanced_ReturnsNull() {
        var temple = new Temple(List.of(new ZombieRoom()));
        var actual = temple.getCurrentRoom();
        assertThat(actual).isEmpty();
    }

    @Test
    public void getCurrentRoom_WhenRoomsHaveAdvancedOnce_ReturnsFirstRoom() throws NoMoreRoomsException {
        var temple = new Temple(List.of(new ZombieRoom()));
        temple.advanceToNextRoom();
        var actual = temple.getCurrentRoom().orElseThrow();
        assertThat(actual).isEqualTo(new ZombieRoom());
    }

    @Test
    public void getCurrentRoom_WhenRoomHasAdvancedNTimes_ReturnsNthRoom() throws NoMoreRoomsException {
        var temple = new Temple(List.of(new GemRoom(2), new GemRoom(4), new GemRoom(6)));
        temple.advanceToNextRoom();
        temple.advanceToNextRoom();
        temple.advanceToNextRoom();
        assertThat(temple.getCurrentRoom().orElseThrow()).isEqualTo(new GemRoom(6));
    }

    @Test
    public void advanceToNextRoom_WhenNoMoreRooms_ThrowsNoMoreRoomsException() {
        assertThatThrownBy(() -> {
            var temple = new Temple(List.of(new GemRoom(3)));
            temple.advanceToNextRoom();
            temple.advanceToNextRoom();
        }).isInstanceOf(NoMoreRoomsException.class);
    }
}