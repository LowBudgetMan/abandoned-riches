package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FireRoomTest {
    @Test
    public void getHazardType_ReturnsFire() {
        var room = new FireRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.FIRE);
    }

    @Test
    public void getRoomType_ReturnsHazard() {
        var room = new FireRoom();
        assertThat(room.getRoomType()).isEqualTo(RoomType.HAZARD);
    }
}