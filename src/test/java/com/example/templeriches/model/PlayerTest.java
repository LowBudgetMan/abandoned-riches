package com.example.templeriches.model;

import com.example.templeriches.model.valuable.Gem;
import com.example.templeriches.model.valuable.Trinket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    public void getName_ReturnsPlayerName() {
        var player = Player.from("Dorkus");
        assertThat(player.getName()).isEqualTo("Dorkus");
    }
    
    @Test
    public void getTempleValue_ReturnsNetWorthOfTempleCollection() {
        var player = Player.from("Dorkus");
        player.addValuableFromTemple(new Gem(7));
        player.addValuableFromTemple(new Trinket());
        assertThat(player.getValueOfTempleHaul()).isEqualTo(12);
    }

    @Test
    public void getTempleValue_WhenNoValuables_ReturnsZero() {
        var player = Player.from("Dorkus");
        assertThat(player.getValueOfTempleHaul()).isEqualTo(0);
    }
}