package com.example.templeriches.model.room.valuable;

import com.example.templeriches.model.Player;
import com.example.templeriches.model.room.RoomType;
import com.example.templeriches.model.valuable.Gem;
import com.example.templeriches.model.valuable.Valuable;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode
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

    @Override
    public RoomType getRoomType() {
        return RoomType.VALUABLE;
    }

    @Override
    public void openRoom(List<Player> players) {
        var gems = splitValue(players.size()).orElse(new Gem(0));
        players.forEach(player -> player.addValuableFromTemple(gems));
    }

    @Override
    public void exitRoom() {
        throw new UnsupportedOperationException();
    }
}
