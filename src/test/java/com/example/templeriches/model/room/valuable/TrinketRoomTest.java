package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.valuable.Trinket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrinketRoomTest {
    @Test
    public void getRoomValue_ReturnsFive() {
        var room = new TrinketRoom();
        assertThat(room.getRoomValue()).isEqualTo(5);
    }

    @Test
    public void splitRoomValue_ReturnsNewTrinket() {
        var room = new TrinketRoom();
        var actual = room.splitValue(1).orElseThrow();
        assertThat(actual).isEqualTo(new Trinket());
    }

    @Test
    public void splitRoomValue_SetsRoomValueToZero() {
        var room = new TrinketRoom();
        room.splitValue(1);
        assertThat(room.getRoomValue()).isEqualTo(0);
    }

    @Test
    public void splitRoomValue_WithMoreThanOnePlayer_ReturnsEmpty() {
        var room = new TrinketRoom();
        var actual = room.splitValue(2);
        assertThat(actual).isEmpty();
    }

    @Test
    public void splitRoomValue_WithMoreThanOnePlayer_DoesNotChangeRoomValue() {
        var room = new TrinketRoom();
        room.splitValue(2);
        assertThat(room.getRoomValue()).isEqualTo(5);
    }
}