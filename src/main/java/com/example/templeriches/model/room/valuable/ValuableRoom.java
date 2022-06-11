package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.room.Room;
import com.example.templeriches.model.valuable.Valuable;

import java.util.Optional;

public interface ValuableRoom extends Room {
    int getRoomValue();
    Optional<Valuable> splitValue(int numberOfPlayersRunning);
}
