package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.room.RoomType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SnakeRoomTest {
    @Test
    public void getHazardType_ReturnsSnake() {
        var snakeRoom = new SnakeRoom();
        assertThat(snakeRoom.getHazardType()).isEqualTo(HazardType.SNAKE);
    }

    @Test
    public void getRoomType_ReturnsHazard() {
        var room = new SnakeRoom();
        assertThat(room.getRoomType()).isEqualTo(RoomType.HAZARD);
    }
}