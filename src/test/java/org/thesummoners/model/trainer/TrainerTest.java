package org.thesummoners.model.trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


import java.util.Arrays;
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
        Arrays.fill(t.getPokemonTeam(), null);
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

}