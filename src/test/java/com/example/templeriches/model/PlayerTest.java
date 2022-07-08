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

    @Test
    public void getValueOfStorage_WhenNoValuables_ReturnsZero() {
        var player = Player.from("Dorkus");
        assertThat(player.getValueOfStorage()).isEqualTo(0);
    }

    @Test
    public void moveTempleHaulToStorage_WithNoStoredValuables_PutsTempleHaulInStorage() {
        var player = Player.from("Dorkus");
        player.addValuableFromTemple(new Gem(2));
        player.addValuableFromTemple(new Gem(1));
        player.addValuableFromTemple(new Gem(3));
        player.moveTempleHaulToStorage();
        assertThat(player.getValueOfStorage()).isEqualTo(6);
    }

    @Test
    public void moveTempleHaulToStorage_WithStoredValuables_AddsHaulToStorage() {
        var player = Player.from("Dorkus");

        player.addValuableFromTemple(new Gem(2));
        player.moveTempleHaulToStorage();

        player.addValuableFromTemple(new Gem(3));
        player.moveTempleHaulToStorage();

        assertThat(player.getValueOfStorage()).isEqualTo(5);
    }

    @Test
    public void moveTempleHaulToStorage_ClearsTempleHaul() {
        var player = Player.from("Dorkus");
        player.addValuableFromTemple(new Gem(10));
        player.moveTempleHaulToStorage();
        assertThat(player.getValueOfTempleHaul()).isEqualTo(0);
    }
}