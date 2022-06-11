package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZombieRoomTest {
    @Test
    public void getHazardType_ReturnsZombies() {
        var room = new ZombieRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.ZOMBIE);
    }
}