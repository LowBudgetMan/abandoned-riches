package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.room.RoomType;
import com.example.templeriches.model.valuable.Trinket;
import com.example.templeriches.model.valuable.Valuable;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@EqualsAndHashCode
public class TrinketRoom implements ValuableRoom {
    private boolean roomHasTrinket = true;

    @Override
    public int getRoomValue() {
        return roomHasTrinket ? Trinket.getTrinketValue() : 0;
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

    @Override
    public RoomType getRoomType() {
        return RoomType.VALUABLE;
    }
}
