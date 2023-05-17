package org.thesummoners.model.trainer;

import org.junit.Before;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import javafx.scene.control.*;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    private static Trainer t;
    private static Pokemon p;
    private List<Pokemon> miLista;



    @BeforeAll
    static void initialize() {
       t = new Trainer();
       p = new Pokemon("Bulbasaur",
               1,
               "doc/images/Bulbasaur.png",
               "doc/images/spritesback/3a-b__001__xy.gif",
               145,
               1,
               49,
               65,
               49,
               65,
               45,
               150,
               Type.GRASS,
               Type.POISON,
               State.ALIVE,
               Sex.M,
               0);
        List<Pokemon> miLista = new LinkedList<>();
        for (int i = 0; i < t.getPokemonTeam().length; i++) {
            t.getPokemonTeam()[i] = null;
        }
    }

    //@BeforeEach



    @Test
    void dragPokemonIntoBox() {
        t.getPokemonTeam()[0] = p;
        t.getPokemonTeam()[1] = p;
        t.numberPokemonInTeam();
        t.dragPokemonIntoBox(0);
        Assertions.assertEquals(1,t.getPokemonPcBill().size());

    }

    @Test
    void dragPokemonIntoTeam() {
        p.setIdPokemon(1);
        // miLista.add(p);
        t.getPokemonPcBill().add(p);
        t.dragPokemonIntoTeam(0,1);
        Assertions.assertEquals(1, (t.getPokemonTeam().length));
    }

    @Test
    void numberPokemonInTeam(){
        t.getPokemonTeam()[0] = p;
        Assertions.assertEquals(1,t.numberPokemonInTeam());
    }

    @Test
    void pokemonBreeding() throws CloneNotSupportedException {
        p.setFertility(5);
        p.setLevel(3);
        t.pokemonBreeding(0);
        Assertions.assertEquals(false,t.pokemonBreeding(0));
    }

    @Test
    void breedingPay() throws CloneNotSupportedException {
        t.setPokedollar(500);
        Assertions.assertEquals(true, t.BreedingPay());
    }

    @Test
    void fight() {
        p.setState(State.FROZEN);
        /*t.fight(Pokemon pokemon1, Pokemon pokemon2, Movement movement, Label lblDisplayPkTrainer, Label lblHpTrainer,
                Label lblHpMaxTrainer, Label lblLevelTrainer, ImageView imgTrainerPokemon,
                Label lblStateTrainer, Label lblDisplayPkEnemy, Label lblHpEnemy, Label lblHpMaxEnemy,
                Label lblLevelEnemy, ImageView imgEnemy, Label lblStateEnemy,
                Button btnMove1, Button btnMove2, Button btnMove3, Button btnMove4, Button toMainWindow,
                ImageView imgPokeball1, ImageView imgPokeball2, ImageView imgPokeball3,
                ImageView imgPokeball1Trainer,  ImageView imgPokeball2Trainer,
                ImageView imgPokeball3Trainer, ImageView imgPokeball4Trainer,  ImageView imgPokeball5Trainer,
                ImageView imgPokeball6Trainer, Button btnMove5);*/ //NO ME FUNCIONAN LOS PARÁMETROS, COMO LLAMO AL MÉTODO?
        Assertions.assertEquals(State.ALIVE, p.getState());
    }

    @Test
    void pokeballCount() {
        t.setPokeball(-1);
        t.pokeballCount();
        Assertions.assertEquals(0, t.pokeballCount());
    }

    @Test
    void pokedollarCount() {
        t.setPokedollar(-50);
        t.pokedollarCount();
        Assertions.assertEquals(0, t.pokedollarCount());
    }

    @Test
    void capture() {
    }

    @Test
    void pokemonListToPokemonTeam() {
    }

    @Test
    void pokeballShop() {
    }

    @Test
    void objetoShop() {
    }

    @Test
    void unequipObject() {
    }

    @Test
    void train() {
    }
}