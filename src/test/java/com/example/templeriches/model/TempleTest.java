package com.example.templeriches.model;

import com.example.templeriches.model.exception.NoMoreRoomsException;
import com.example.templeriches.model.room.hazard.HazardRoom;
import com.example.templeriches.model.room.hazard.HazardTracker;
import com.example.templeriches.model.room.valuable.GemRoom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.templeriches.model.room.hazard.HazardType.ROCKS;
import static com.example.templeriches.model.room.hazard.HazardType.ZOMBIE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TempleTest {

    @Test
    public void getNumberOfRooms_ReturnsNumberOfRoomsProvided() {
        var empty = new Temple(List.of(), List.of());
        var one = new Temple(List.of(new HazardRoom(null, ZOMBIE)), List.of());
        var many = new Temple(List.of(new GemRoom(2), new HazardRoom(null, ROCKS)), List.of());

        assertThat(empty.getNumberOfRooms()).isEqualTo(0);
        assertThat(one.getNumberOfRooms()).isEqualTo(1);
        assertThat(many.getNumberOfRooms()).isEqualTo(2);
    }

    @Test
    public void getCurrentRoom_WhenRoomsHaveNotAdvanced_ReturnsNull() {
        var temple = new Temple(List.of(new HazardRoom(null ,ZOMBIE)), List.of());
        var actual = temple.getCurrentRoom();
        assertThat(actual).isEmpty();
    }

    @Test
    public void getCurrentRoom_WhenRoomsHaveAdvancedOnce_ReturnsFirstRoom() throws NoMoreRoomsException {
        var player1 = Player.from("player1");
        var hazardTracker = new HazardTracker();
        var temple = new Temple(List.of(new HazardRoom(hazardTracker, ZOMBIE)), List.of(player1));
        temple.advanceToNextRoom();
        var actual = temple.getCurrentRoom().orElseThrow();
        assertThat(actual).isEqualTo(new HazardRoom(hazardTracker, ZOMBIE));
    }

    @Test
    public void getCurrentRoom_WhenRoomHasAdvancedNTimes_ReturnsNthRoom() throws NoMoreRoomsException {
        var player1 = Player.from("player1");
        var player2 = Player.from("player2");
        var temple = new Temple(
                List.of(new GemRoom(2), new GemRoom(4), new GemRoom(7)),
                List.of(player1, player2)
        );
        temple.advanceToNextRoom();
        temple.advanceToNextRoom();
        temple.advanceToNextRoom();
        assertThat(temple.getCurrentRoom().orElseThrow()).isEqualTo(new GemRoom(1));
    }

    @Test
    public void advanceToNextRoom_WhenNoMoreRooms_ThrowsNoMoreRoomsException() {
        var player1 = Player.from("player1");
        assertThatThrownBy(() -> {
            var temple = new Temple(List.of(new GemRoom(3)), List.of(player1));
            temple.advanceToNextRoom();
            temple.advanceToNextRoom();
        }).isInstanceOf(NoMoreRoomsException.class);
    }

    @Test
    public void advanceToNextRoom_OpensNextRoom() throws NoMoreRoomsException{
        var player1 = Player.from("player1");
        var temple = new Temple(List.of(new GemRoom(2)), List.of(player1));
        temple.advanceToNextRoom();
        assertThat(player1.getValueOfTempleHaul()).isEqualTo(2);
    }

    @Test
    public void retreatPlayersFromTemple_RemovesPlayersFromPlayersInTemple() throws NoMoreRoomsException {
        var player1 = Player.from("player1");
        var player2 = Player.from("player2");
        var player3 = Player.from("player3");
        var player4 = Player.from("player4");
        var temple = new Temple(List.of(new GemRoom(2)), List.of(player1, player2, player3, player4));

        temple.retreatPlayersFromTemple(List.of(player2, player3));
        temple.advanceToNextRoom();

        assertThat(player1.getValueOfTempleHaul()).isEqualTo(1);
        assertThat(player2.getValueOfTempleHaul()).isEqualTo(0);
        assertThat(player3.getValueOfTempleHaul()).isEqualTo(0);
        assertThat(player4.getValueOfTempleHaul()).isEqualTo(1);
    }

    @Test
    public void retreatPlayersFromTemple_AddsTreasureOnGroundToFleeingPlayers() throws NoMoreRoomsException {
        var player1 = Player.from("player1");
        var player2 = Player.from("player2");
        var player3 = Player.from("player3");
        var player4 = Player.from("player4");
        var temple = new Temple(List.of(new GemRoom(2), new GemRoom(2)), List.of(player1, player2, player3, player4));

        temple.advanceToNextRoom();
        temple.advanceToNextRoom();
        temple.retreatPlayersFromTemple(List.of(player2, player3));

        assertThat(player1.getValueOfTempleHaul()).isEqualTo(0);
        assertThat(player2.getValueOfTempleHaul()).isEqualTo(2);
        assertThat(player3.getValueOfTempleHaul()).isEqualTo(2);
        assertThat(player4.getValueOfTempleHaul()).isEqualTo(0);
    }
}