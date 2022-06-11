package com.example.templeriches.model.valuable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GemTest {
    @Test
    public void getValue_ReturnsGemCount() {
        var gem = new Gem(4);
        assertThat(gem.getValue()).isEqualTo(4);
    }
}