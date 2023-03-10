package com.example.templeriches.model.room.hazard;

import com.example.templeriches.model.exception.TotalPartyKillException;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@EqualsAndHashCode
public class HazardTracker {
    private final Map<HazardType, Integer> hazardCountMap = new HashMap<>();

    public void incrementCount(HazardType hazard) throws TotalPartyKillException{
        var hazardCount = getCountForHazard(hazard) + 1;
        if(hazardCount >= 2) {
            throw new TotalPartyKillException(hazard);
        } else {
            hazardCountMap.put(hazard, hazardCount);
        }
    }

    public int getCountForHazard(HazardType hazard) {
        Optional<Integer> optionalInteger = Optional.ofNullable(hazardCountMap.get(hazard));
        return optionalInteger.orElse(0);
    }
}
