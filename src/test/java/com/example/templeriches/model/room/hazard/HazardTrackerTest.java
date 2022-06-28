package com.example.templeriches.model.room.hazard;

import org.junit.jupiter.api.Test;

import static com.example.templeriches.model.room.hazard.HazardType.FIRE;
import static com.example.templeriches.model.room.hazard.HazardType.ROCKS;
import static org.assertj.core.api.Assertions.assertThat;

class HazardTrackerTest {
    @Test
    public void getCountForHazard_InitializesToZero() {
        var tracker = new HazardTracker();
        assertThat(tracker.getCountForHazard(ROCKS)).isEqualTo(0);
    }

    @Test
    public void updateHazardCount_IncreasesCountForHazard() {
        var tracker = new HazardTracker();
        tracker.incrementCount(ROCKS);
        assertThat(tracker.getCountForHazard(ROCKS)).isEqualTo(1);
    }

    @Test
    public void updateHazardCount_IncreasesCountForPreviouslyIncreasedHazard() {
        var tracker = new HazardTracker();
        tracker.incrementCount(FIRE);
        tracker.incrementCount(FIRE);
        assertThat(tracker.getCountForHazard(FIRE)).isEqualTo(2);
    }

}