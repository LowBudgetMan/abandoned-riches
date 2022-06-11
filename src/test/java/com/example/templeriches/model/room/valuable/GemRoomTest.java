package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.valuable.Gem;
import com.example.templeriches.model.valuable.Valuable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GemRoomTest {
    @Test
    public void getRoomValue_ReturnsTotalValueLeftInRoom() {
        var room = new GemRoom(7);
        assertThat(room.getRoomValue()).isEqualTo(7);
    }

    @Test
    public void splitValue_ReturnsModuleOfRoomValueByNumberOfPlayers() {
        var room = new GemRoom(7);
        Valuable actual = room.splitValue(3).orElse(new Gem(0));
        Gem expected = new Gem(2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void splitValue_ReducesRoomValueToRemainder() {
        var room = new GemRoom(7);
        room.splitValue(3);
        assertThat(room.getRoomValue()).isEqualTo(1);
    }

    @Test
    public void splitValue_WithMorePlayersThanGems_ReturnsEmpty() {
        var room = new GemRoom(7);
        var actual = room.splitValue(8);
        assertThat(actual).isEmpty();
    }

    @Test
    public void splitValue_WithMorePlayersThanGems_DoesNotChangeRoomValue() {
        var room = new GemRoom(7);
       room.splitValue(8);
        assertThat(room.getRoomValue()).isEqualTo(7);
    }
}