package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.room.RoomType;
import com.example.templeriches.model.valuable.Gem;
import com.example.templeriches.model.valuable.Valuable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GemRoomTest {
    @Test
    public void getRoomValue_ReturnsTotalValueLeftInRoom() {
        var room = new GemRoom(7);
        assertThat(room.getRoomValue()).isEqualTo(7);
    }

    @Test
    public void getRoomType_ReturnsValuable() {
        var room = new GemRoom(2);
        assertThat(room.getRoomType()).isEqualTo(RoomType.VALUABLE);
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

    @Test
    public void openRoom_SplitsGemsBetweenPlayers() {
        var player1 = Player.from("player1");
        var player2 = Player.from("player2");
        var playerList = List.of(player1, player2);
        var room = new GemRoom(9);

        room.openRoom(playerList);

        assertThat(room.getRoomValue()).isEqualTo(1);
        assertThat(player1.getValueOfTempleHaul()).isEqualTo(4);
        assertThat(player2.getValueOfTempleHaul()).isEqualTo(4);
    }

    @Test
    public void exitRoom_SplitsGemsBetweenPlayersLeaving() {
        var player1 = Player.from("player1");
        var player2 = Player.from("player2");
        var playerList = List.of(player1, player2);
        var room = new GemRoom(9);

        room.exitRoom(playerList);

        assertThat(room.getRoomValue()).isEqualTo(1);
        assertThat(player1.getValueOfTempleHaul()).isEqualTo(4);
        assertThat(player2.getValueOfTempleHaul()).isEqualTo(4);
    }
}