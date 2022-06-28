package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.room.RoomType;
import com.example.templeriches.model.valuable.Trinket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrinketRoomTest {
    @Test
    public void getRoomValue_ReturnsTrinketValue() {
        var room = new TrinketRoom();
        assertThat(room.getRoomValue()).isEqualTo(new Trinket().getValue());
    }

    @Test
    public void getRoomType_ReturnsValuable() {
        var room = new TrinketRoom();
        assertThat(room.getRoomType()).isEqualTo(RoomType.VALUABLE);
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

    @Test
    public void exitRoom_WillSplitTrinketWithPlayersLeaving() {
        var player1 = Player.from("player1");
        var room = new TrinketRoom();

        room.exitRoom(List.of(player1));

        assertThat(player1.getValueOfTempleHaul()).isEqualTo(5);
        assertThat(room.getRoomValue()).isEqualTo(0);
    }

    @Test
    public void exitRoom_WithMoreThanOnePlayerLeaving_WillGiveNeitherPlayerTrinket() {
        var player1 = Player.from("player1");
        var player2 = Player.from("player1");
        var room = new TrinketRoom();

        room.exitRoom(List.of(player1, player2));

        assertThat(player1.getValueOfTempleHaul()).isEqualTo(0);
        assertThat(player2.getValueOfTempleHaul()).isEqualTo(0);
        assertThat(room.getRoomValue()).isEqualTo(Trinket.getTrinketValue());
    }
}