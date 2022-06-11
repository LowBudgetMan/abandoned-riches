package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.valuable.Gem;
import com.example.templeriches.model.valuable.Valuable;

import java.util.Optional;

public class GemRoom implements ValuableRoom {
    private int numberOfGems;

    public GemRoom(int numberOfGems) {
        this.numberOfGems = numberOfGems;
    }

    @Override
    public int getRoomValue() {
        return numberOfGems;
    }

    @Override
    public Optional<Valuable> splitValue(int numberOfPlayers) {
        var gemsTaken = numberOfGems / numberOfPlayers;
        if(gemsTaken > 0) {
            numberOfGems = numberOfGems % numberOfPlayers;
            return Optional.of(new Gem(gemsTaken));
        } else {
            return Optional.empty();
        }
    }
}
