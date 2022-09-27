package com.example.templeriches.model.temple;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.hazard.HazardRoom;
import com.example.templeriches.model.room.hazard.HazardTracker;
import com.example.templeriches.model.room.hazard.HazardType;
import com.example.templeriches.model.room.valuable.GemRoom;
import com.example.templeriches.model.room.valuable.TrinketRoom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TempleFactoryTest {
    //Gem Rooms: 17, 15, 14, 13, 11, 11, 9, 7, 7, 5, 5, 4, 3, 2, 1
    private final RoomShuffler mockRoomShuffler = mock(RoomShuffler.class);
    private final TempleFactory templeFactory = new TempleFactory(mockRoomShuffler);
    private final List<Room> gemRoomList = List.of(
            new GemRoom(17),
            new GemRoom(15),
            new GemRoom(14),
            new GemRoom(13),
            new GemRoom(11),
            new GemRoom(11),
            new GemRoom(9),
            new GemRoom(7),
            new GemRoom(7),
            new GemRoom(5),
            new GemRoom(5),
            new GemRoom(4),
            new GemRoom(3),
            new GemRoom(2),
            new GemRoom(1)
    );

    @Test
    public void create_ReturnsTempleWithCorrectNumberOfGemRooms() {
        var expectedTemple = new Temple(gemRoomList, List.of());
        when(mockRoomShuffler.shuffle(gemRoomList)).thenReturn(gemRoomList);
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 0, 0, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_WithPlayers_ReturnsTempleWithPlayers() {
        var players = List.of(Player.from("Player 1"), Player.from("Player 2"));
        var expectedTemple = new Temple(gemRoomList, players);
        when(mockRoomShuffler.shuffle(gemRoomList)).thenReturn(gemRoomList);
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 0, 0, 0), players);
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_WithFireHazardOptions_ReturnsTempleWithSameNumberOfFireHazardRooms() {
        var expectedHazardTracker = new HazardTracker();
        var fireHazards = List.of(
                new HazardRoom(expectedHazardTracker, HazardType.FIRE),
                new HazardRoom(expectedHazardTracker, HazardType.FIRE),
                new HazardRoom(expectedHazardTracker, HazardType.FIRE),
                new HazardRoom(expectedHazardTracker, HazardType.FIRE),
                new HazardRoom(expectedHazardTracker, HazardType.FIRE)
        );
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(fireHazards);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(5, 0, 0, 0, 0, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_withRocksHazardOptions_ReturnsTempleWithSameNumberOfRocksHazardRooms() {
        var expectedHazardTracker = new HazardTracker();
        var fireHazards = List.of(
                new HazardRoom(expectedHazardTracker, HazardType.ROCKS),
                new HazardRoom(expectedHazardTracker, HazardType.ROCKS)
        );
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(fireHazards);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(0, 2, 0, 0, 0, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_withSnakeHazardOptions_ReturnsTempleWithSameNumberOfSnakeHazardRooms() {
        var expectedHazardTracker = new HazardTracker();
        var fireHazards = List.of(
                new HazardRoom(expectedHazardTracker, HazardType.SNAKE),
                new HazardRoom(expectedHazardTracker, HazardType.SNAKE),
                new HazardRoom(expectedHazardTracker, HazardType.SNAKE)
        );
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(fireHazards);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 3, 0, 0, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_withSpiderHazardOptions_ReturnsTempleWithSameNumberOfSpiderHazardRooms() {
        var expectedHazardTracker = new HazardTracker();
        var fireHazards = List.of(
                new HazardRoom(expectedHazardTracker, HazardType.SPIDER),
                new HazardRoom(expectedHazardTracker, HazardType.SPIDER),
                new HazardRoom(expectedHazardTracker, HazardType.SPIDER),
                new HazardRoom(expectedHazardTracker, HazardType.SPIDER)
        );
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(fireHazards);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 4, 0, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_withZombieHazardOptions_ReturnsTempleWithSameNumberOfZombieHazardRooms() {
        var expectedHazardTracker = new HazardTracker();
        var fireHazards = List.of(
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE),
                new HazardRoom(expectedHazardTracker, HazardType.ZOMBIE)
        );
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(fireHazards);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 0, 7, 0), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_withTrinketOptions_ReturnsTempleWithSameNumberOfTrinketRooms() {
        var trinketRooms = List.of(new TrinketRoom(), new TrinketRoom());
        var expectedRooms = new ArrayList<>(gemRoomList);
        expectedRooms.addAll(trinketRooms);
        when(mockRoomShuffler.shuffle(expectedRooms)).thenReturn(expectedRooms);
        var expectedTemple = new Temple(expectedRooms, List.of());
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 0, 0, 2), List.of());
        assertThat(temple).isEqualTo(expectedTemple);
    }

    @Test
    public void create_shufflesTheRoomsList() {
        Temple temple = templeFactory.create(new TempleOptions(0, 0, 0, 0, 0, 0), List.of());
        verify(mockRoomShuffler).shuffle(gemRoomList);
    }
}