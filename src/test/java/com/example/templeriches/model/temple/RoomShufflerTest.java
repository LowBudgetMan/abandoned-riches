package com.example.templeriches.model.temple;

import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.room.valuable.GemRoom;
import com.example.templeriches.model.room.valuable.TrinketRoom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoomShufflerTest {

    @Test
    public void shuffle_doesNotChangeOriginalList() {
        List<Room> expectedList = List.of(new TrinketRoom(), new GemRoom(1), new GemRoom(2));
        List<Room> listToShuffle = new ArrayList<>(expectedList);
        new RoomShuffler().shuffle(listToShuffle);
        assertThat(listToShuffle).isEqualTo(expectedList);
    }

}