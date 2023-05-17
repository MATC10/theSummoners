package org.thesummoners.model.trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.thesummoners.model.trainer.Enemy.enemyTeam;
import static org.thesummoners.model.trainer.Trainer.trainer;

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
    public void testPokemonListToPokemonTeam() {
        FXCollections FXCollections = null;
        ObservableList<Pokemon> listTeamIntermediary = FXCollections.observableArrayList();

        // Agregamos algunos Pokemon a la lista de prueba
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        Pokemon pokemon3 = new Pokemon();
        listTeamIntermediary.add(pokemon1);
        listTeamIntermediary.add(pokemon2);
        listTeamIntermediary.add(pokemon3);

        // Llamamos al método que queremos probar
        pokemonListToPokemonTeam(listTeamIntermediary);

        // Verificamos que los Pokemon se hayan copiado correctamente en el equipo del entrenador
        Pokemon[] pokemonTeam = Trainer.getTrainer().getPokemonTeam();
        Assert.assertEquals(pokemon1, pokemonTeam[0]);
        Assert.assertEquals(pokemon2, pokemonTeam[1]);
        Assert.assertEquals(pokemon3, pokemonTeam[2]);
    }

    public void pokemonListToPokemonTeam(ObservableList<Pokemon> listTeamIntermediary) {
        Arrays.fill(Trainer.getTrainer().getPokemonTeam(), null);
        for (int i = 0; i < listTeamIntermediary.size(); i++) {
            Trainer.getTrainer().getPokemonTeam()[i] = listTeamIntermediary.get(i);
        }
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
    public void testCentrePokemonHeal() throws CloneNotSupportedException {
        // Crear una instancia de Trainer y agregar algunos Pokémon al equipo
        Trainer trainer = Trainer.getTrainer();
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        trainer.addPokemonToTeam(pokemon1);
        trainer.addPokemonToTeam(pokemon2);
        // Llamar al método centrePokemonHeal()
        trainer.centrePokemonHeal();
        // Verificar que los Pokémon del equipo estén correctamente curados
        for (Pokemon p : trainer.getPokemonTeam()) {
            if (p != null) {
                assertEquals(State.ALIVE, p.getState());  // Verificar el estado del Pokémon
            }
        }
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