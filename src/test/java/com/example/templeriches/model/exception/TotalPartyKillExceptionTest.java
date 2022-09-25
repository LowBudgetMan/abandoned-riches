package com.example.templeriches.model.exception;

import org.junit.jupiter.api.Test;

import static com.example.templeriches.model.room.hazard.HazardType.FIRE;
import static org.assertj.core.api.Assertions.assertThat;

class TotalPartyKillExceptionTest {

    @Test
    public void getHazardType_ReturnsHazard() {
        assertThat(new TotalPartyKillException(FIRE).getHazardType()).isEqualTo(FIRE);
    }

}