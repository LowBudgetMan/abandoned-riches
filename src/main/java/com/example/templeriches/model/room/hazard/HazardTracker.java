package com.example.templeriches.model.room.hazard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HazardTracker {
    private final Map<HazardType, Integer> hazardCountMap = new HashMap<>();

    public void incrementCount(HazardType hazard) {
        hazardCountMap.put(hazard, getCountForHazard(hazard) + 1);
    }

    public int getCountForHazard(HazardType hazard) {
        Optional<Integer> optionalInteger = Optional.ofNullable(hazardCountMap.get(hazard));
        return optionalInteger.orElse(0);
    }
}
