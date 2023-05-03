package org.thesummoners.model.pokemon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PokemonTest {

    private static Pokemon p;

    @Test
    void assignMovement() {
    }

    @Test
    void rest() {
    }

    @Test
    void levelUp() {
        try {
            p.levelUp(300);
            Assertions.assertEquals(2, p.getLevel());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void train() {

    }

    @Test
    void adaptStatsToLevel() {
    }

    @Test
    void changeDisplayName() {
    }

    @Test
    void statisticsWithObjeto() {
    }

    @Test
    void statisticsWithoutObjeto() {
    }

    @BeforeAll
    static void createPokemon() throws CloneNotSupportedException {
        p = new Pokemon ("Bulbasaur", 1, "doc/images/Bulbasaur.png", "doc/images/spritesback/3a-b__001__xy.gif",145,1, 49,65,49,65,45, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.M, 0, null);
    }
}