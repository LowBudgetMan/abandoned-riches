package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.exception.TotalPartyKillException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.templeriches.model.room.RoomType.HAZARD;
import static com.example.templeriches.model.room.hazard.HazardType.*;
import static org.assertj.core.api.Assertions.assertThat;

class HazardRoomTest {
    @Test
    public void getHazardType_ReturnsHazardType() {
        var room = new HazardRoom(null, FIRE);
        assertThat(room.getHazardType()).isEqualTo(FIRE);
    }

    @Test
    public void getRoomType_ReturnsHazardRoom() {
        var room = new HazardRoom(null, ROCKS);
        assertThat(room.getRoomType()).isEqualTo(HAZARD);
    }

    @Test
    public void openRoom_IncreasesHazardCount() throws TotalPartyKillException {
        var tracker = new HazardTracker();
        var room = new HazardRoom(tracker, SNAKE);

        room.openRoom(List.of());

        assertThat(tracker.getCountForHazard(SNAKE)).isEqualTo(1);
    }
}