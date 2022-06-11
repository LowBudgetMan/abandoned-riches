package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpiderRoomTest {
    @Test
    public void getHazardType_ReturnsSpider() {
        var room = new SpiderRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.SPIDER);
    }
}