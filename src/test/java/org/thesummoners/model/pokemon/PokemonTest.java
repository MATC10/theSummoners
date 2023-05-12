package org.thesummoners.model.pokemon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.objeto.ObjetoInitializer;

class PokemonTest {

    private static Pokemon p;

    @Test
    void minimumHp (){
            p.setHp(-200);
            p.minimumHp();
            Assertions.assertEquals(0, p.getHp());
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
    void adaptStatsToLevel() throws CloneNotSupportedException {
        Assertions.assertEquals(145 , p.getHp());
        p.setLevel(10);
        p.adaptStatsToLevel(p.getLevel(),p);
        Assertions.assertEquals(345 , p.getHp());
    }

    @Test
    void changeDisplayName() {
        Assertions.assertEquals(p.getName() , p.getDisplayName());
        p.setNickName("siuuu");
        p.changeDisplayName();
        Assertions.assertEquals(p.getDisplayName() , p.getNickName());
    }

    @Test
    void setObjetoImproveStats() throws CloneNotSupportedException {
        p.setObjetoImproveStats(new Objeto("pesa"));
        Assertions.assertEquals(58 , p.getAttackPower());

        p.setObjetoImproveStats(null);
        Assertions.assertEquals(49 , p.getAttackPower());

        p.setObjetoImproveStats(new Objeto("chaleco"));
        Assertions.assertEquals(78 , p.getSpecialDefense());
    }

    @Test
    void statisticsWithObjeto() {
        Objeto pesa = new Objeto("pesa");
        Assertions.assertEquals(45, p.getSpeed());
        p.statisticsWithObjeto(p, pesa);
        Assertions.assertEquals(36 , p.getSpeed());
    }



    @BeforeAll
    static void createPokemon() throws CloneNotSupportedException {
        p = new Pokemon ("Bulbasaur", 1, "doc/images/Bulbasaur.png", "doc/images/spritesback/3a-b__001__xy.gif",145,1, 49,65,49,65,45, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.M, 0, null);
    }
}