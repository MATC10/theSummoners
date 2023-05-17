package org.thesummoners.model.trainer;

import org.junit.jupiter.api.Test;
import org.thesummoners.model.pokemon.Pokemon;

import static org.junit.jupiter.api.Assertions.*;
import static org.thesummoners.model.trainer.Enemy.enemyTeam;

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
    public void testPokemonAliveInTeam() {
        // Creamos un equipo de Pokémon para la prueba
        Pokemon[] team = new Pokemon[6];
        team[0] = new Pokemon("Pikachu", 100);
        team[1] = new Pokemon("Charizard", 0);
        team[2] = new Pokemon("Bulbasaur", 50);
        team[3] = null; // Espacio vacío en el equipo
        team[4] = new Pokemon("Squirtle", -10);
        team[5] = new Pokemon("Jigglypuff", 30);

        // Creamos una instancia de Trainer y asignamos el equipo de Pokémon
        Trainer.getTrainer().setPokemonTeam(team);

        // Llamamos al método pokemonAliveInTeam() y comprobamos el resultado
        boolean result = Trainer.getTrainer().pokemonAliveInTeam();
        assertFalse(result);
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