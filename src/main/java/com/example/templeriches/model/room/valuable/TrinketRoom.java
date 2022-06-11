package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.valuable.Trinket;
import com.example.templeriches.model.valuable.Valuable;

import java.util.Optional;

public class TrinketRoom implements ValuableRoom {
    private Trinket roomTrinket;

    @Override
    public int getRoomValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Valuable> splitValue(int numberOfPlayersRunning) {
        throw new UnsupportedOperationException();
    }
}
