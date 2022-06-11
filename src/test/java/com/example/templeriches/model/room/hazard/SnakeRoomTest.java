package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SnakeRoomTest {
    @Test
    public void getHazardType_ReturnsSnake() {
        var snakeRoom = new SnakeRoom();
        assertThat(snakeRoom.getHazardType()).isEqualTo(HazardType.SNAKE);
    }
}