package com.example.templeriches.model.valuable;

public record Gem(int gemCount) implements Valuable
{
    @Override
    public int getValue() {
        return gemCount;
    }
}
