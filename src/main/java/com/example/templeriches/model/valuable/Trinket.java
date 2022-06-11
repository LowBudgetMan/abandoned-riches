package com.example.templeriches.model.valuable;

public record Trinket() implements Valuable{

    private static final int TRINKET_VALUE = 5;

    @Override
    public int getValue() {
        return TRINKET_VALUE;
    }

    public static int getTrinketValue() {
        return TRINKET_VALUE;
    }
}
