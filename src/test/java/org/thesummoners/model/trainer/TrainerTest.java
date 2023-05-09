package org.thesummoners.model.trainer;

import org.junit.jupiter.api.Test;
import org.thesummoners.model.pokemon.Pokemon;

import java.util.ArrayList;

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
        assertSame(trainer1, trainer2);}


    @Test
    public void DragPokemonIntoTeam() {

        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(new Pokemon("Bulbasaur", 1, 10));
        pokemonList.add(new Pokemon("Charmander", 2, 20));
        pokemonList.add(new Pokemon("Squirtle", 3, 30));
        pokemonList.add(new Pokemon("Pikachu", 4, 40));
        pokemonList.add(new Pokemon("Eevee", 5, 50));
        pokemonList.add(new Pokemon("Snorlax", 6, 60));

        Pokemon[] pokemonTeam = new Pokemon[3];
        Trainer ash = new Trainer("", pokemonList, pokemonTeam);
        ash.dragPokemonIntoTeam(0, 2);
        assertEquals(ash.getPokemonTeam()[0], new Pokemon("Charmander", 2,20));
        assertEquals(ash.getPokemonPcBill().size(), 5);
    }
    @Test
    public void CheckPokemonTeamFullWithEmptySlot() {
        Trainer ash = new Trainer();
        ash.addToTeam(new Pokemon("Pikachu", 4));
        ash.addToTeam(null);
        assertTrue(ash.checkPokemonTeamFull());
    }
    @Test
    public void CheckPokemonTeamFullWithoutEmptySlot() {
        Trainer misty = new Trainer();
        misty.addToTeam(new Pokemon("Charmander", 2));
        misty.addToTeam(new Pokemon("Squirtle", 3));
        misty.addToTeam(new Pokemon("Pikachu", 4));
        assertFalse(misty.checkPokemonTeamFull());
    }
    @Test
    public void PokeballCountWithNoPokeballs() {
        Trainer ash = new Trainer();
        assertEquals(20, ash.pokeballCount());
    }
    @Test
    public void PokeballCountWithPokeballs() {
        Trainer brock = new Trainer();
        assertEquals( 20, brock.pokeballCount());
    }
    @Test
    public void pokeballCountWithnegativepokeballs() {
        Trainer misty = new Trainer();
        assertEquals(20, misty.pokeballCount());
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