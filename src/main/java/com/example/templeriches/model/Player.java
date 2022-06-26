package com.example.templeriches.model;

import com.example.templeriches.model.valuable.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Valuable> valuablesInTemple;
    private final List<Valuable> valuablesStored;
    private boolean inTemple;

    private Player(String name, ArrayList<Valuable> valuablesInTemple, ArrayList<Valuable> valuablesStored, boolean inTemple) {
        this.name = name;
        this.valuablesInTemple = valuablesInTemple;
        this.valuablesStored = valuablesStored;
        this.inTemple = inTemple;
    }

    public static Player from(String name) {
        return new Player(name, new ArrayList<>(), new ArrayList<>(), false);
    }

    public String getName() {
        return name;
    }

    public void addValuableFromTemple(Valuable valuable) {
        valuablesInTemple.add(valuable);
    }

    public int getValueOfTempleHaul() {
        return valuablesInTemple.stream().reduce(0, (subtotal, valuable) -> subtotal + valuable.getValue(), Integer::sum);
    }
}
