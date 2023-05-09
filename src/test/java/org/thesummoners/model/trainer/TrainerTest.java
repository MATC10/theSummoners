package org.thesummoners.model.trainer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void TrainerConstructor() {

        Trainer ash = new Trainer();
        assertEquals(10000, ash.getPokedollar());
        assertNotNull(ash.getPokemonTeam());
        assertEquals(6, ash.getPokemonTeam().length);
        // Comprueba si el número de pokeballs es 20
        assertEquals(20, ash.getPokeball());
    }









    @Test
    void getTrainer() {
        Trainer trainer1 = Trainer.getTrainer();
        Trainer trainer2 = Trainer.getTrainer();

        // Comprueba si ambas instancias son la misma
        assertSame(trainer1, trainer2);
    }

    @Test
    void getName() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setName() {
    }

    @Test
    void getPokemonTeam() {
    }

    @Test
    void setPokemonTeam() {
    }

    @Test
    void getPokedollar() {
    }

    @Test
    void setPokedollar() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getPokeball() {
    }

    @Test
    void setPokeball() {
    }

    @Test
    void getPokemonPcBill() {
    }

    @Test
    void setPokemonPcBill() {
    }

    @Test
    void getBackPack() {
    }

    @Test
    void setBackPack() {
    }

    @Test
    void numberPokemonInTeam() {
    }

    @Test
    void dragPokemonIntoBox() {
    }

    @Test
    void dragPokemonIntoTeam() {
    }

    @Test
    void pokemonBreeding() {
    }

    @Test
    void fight() {
    }

    @Test
    void checkPokemonTeamFull() {
    }

    @Test
    void pokeballCount() {
    }

    @Test
    void capture() {
    }

    @Test
    void pokemonTeamArrayToList() {
    }

    @Test
    void pokemonListToPokemonTeam() {
    }

    @Test
    void objetoShop() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void manageObject() {
    }
}