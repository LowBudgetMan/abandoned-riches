package com.example.templeriches.model.valuable;

public record Trinket() implements Valuable{
    @Override
    public int getValue() {
        return 5;
    }
}
