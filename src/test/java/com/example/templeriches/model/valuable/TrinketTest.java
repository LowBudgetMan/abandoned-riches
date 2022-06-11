package com.example.templeriches.model.valuable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrinketTest {
    @Test
    public void getValue_returnsFive() {
        var trinket = new Trinket();
        assertThat(trinket.getValue()).isEqualTo(5);
    }

}