package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.exception.TotalPartyKillException;
import org.junit.jupiter.api.Test;

import static com.example.templeriches.model.room.hazard.HazardType.FIRE;
import static com.example.templeriches.model.room.hazard.HazardType.ROCKS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HazardTrackerTest {
    @Test
    public void getCountForHazard_InitializesToZero() {
        var tracker = new HazardTracker();
        assertThat(tracker.getCountForHazard(ROCKS)).isEqualTo(0);
    }

    @Test
    public void incrementCount_IncreasesCountForHazard() throws TotalPartyKillException {
        var tracker = new HazardTracker();
        tracker.incrementCount(ROCKS);
        assertThat(tracker.getCountForHazard(ROCKS)).isEqualTo(1);
    }

    @Test
    public void incrementCount_WhenHazardCountIsGreaterThanOne_ThrowsTotalPartyKillException() throws TotalPartyKillException {
        var tracker = new HazardTracker();
        tracker.incrementCount(FIRE);
        assertThatThrownBy(() -> tracker.incrementCount(FIRE))
                .isInstanceOf(TotalPartyKillException.class)
                .hasFieldOrPropertyWithValue("hazard", FIRE);
    }

}