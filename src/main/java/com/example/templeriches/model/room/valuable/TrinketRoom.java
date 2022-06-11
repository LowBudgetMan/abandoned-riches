package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.valuable.Trinket;
import com.example.templeriches.model.valuable.Valuable;

import java.util.Optional;

public class TrinketRoom implements ValuableRoom {
    private boolean roomHasTrinket = true;

    @Override
    public int getRoomValue() {
        return roomHasTrinket ? 5 : 0;
    }

    @Override
    public Optional<Valuable> splitValue(int numberOfPlayersRunning) {
        if(numberOfPlayersRunning == 1) {
            roomHasTrinket = false;
            return Optional.of(new Trinket());
        } else {
            return Optional.empty();
        }
    }
}
