package com.example.templeriches.model.valuable;

public class Gem implements Valuable{
    private final int value;

    public Gem(int gemCount) {
        this.value = gemCount;
    }

    @Override
    public int getValue() {
        return value;
    }
}
