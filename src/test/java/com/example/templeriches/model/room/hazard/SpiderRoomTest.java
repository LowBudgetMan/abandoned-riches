package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpiderRoomTest {
    @Test
    public void getHazardType_ReturnsSpider() {
        var room = new SpiderRoom();
        assertThat(room.getHazardType()).isEqualTo(HazardType.SPIDER);
    }

    @Test
    public void getRoomType_ReturnsHazard() {
        var room = new SpiderRoom();
        assertThat(room.getRoomType()).isEqualTo(RoomType.HAZARD);
    }
}