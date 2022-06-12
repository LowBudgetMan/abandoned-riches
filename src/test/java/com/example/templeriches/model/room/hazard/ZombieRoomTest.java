package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZombieRoomTest {
    @Test
    public void getHazardType_ReturnsZombies() {
        var room = new ZombieRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.ZOMBIE);
    }

    @Test
    public void getRoomType_ReturnsHazard() {
        var room = new ZombieRoom();
        assertThat(room.getRoomType()).isEqualTo(RoomType.HAZARD);
    }
}