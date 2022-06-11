package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RocksRoomTest {
    @Test
    public void getHazardType_ReturnsRocks() {
        var room = new RocksRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.ROCKS);
    }
}