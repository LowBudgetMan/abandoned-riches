package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FireRoomTest {
    @Test
    public void getHazardType_ReturnsFire() {
        var room = new FireRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.FIRE);
    }
}