package org.thesummoners.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Trainer {
    static Trainer trainer = null;
    private String name;
    private Pokemon[] pokemonTeam;
    private List<Pokemon> pokemonBox;
    private int pokedollar;
    private List<Objeto> backPack;

    public Trainer() {
        this.pokedollar = 100;
    }

    public static Trainer getTrainer() {
        synchronized (Trainer.class){
            if(trainer == null){
                trainer = new Trainer();
            }
        }
        return trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(Pokemon[] pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }

    public List<Pokemon> getPokemonBox() {
        return pokemonBox;
    }

    public void setPokemonBox(List<Pokemon> pokemonBox) {
        this.pokemonBox = pokemonBox;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public List<Objeto> getBackPack() {
        return backPack;
    }

    public void setBackPack(List<Objeto> backPack) {
        this.backPack = backPack;
    }

    public void dragPokemonIntoBox(int i){
    pokemonBox.add(pokemonTeam[i]);
    pokemonTeam[i] = null;
    }

    public void dragIntoTeam(int i, int idPokemon){
        //REVISAR SI ES POSIBLE QUITAR EL IDPOKEMON EN EL PARÁMETRO
        //O CAMBIARLO POR OTRA COSA

        for(Pokemon a : this.pokemonBox){
            if(a.getIdPokemon() == idPokemon){
                pokemonTeam[i] = a;
                pokemonBox.remove(a);
            }
        }
    }

    public String pokemonBreeding(Pokemon pokemon1, Pokemon pokemon2){
        //ESTE MÉTODO SE LLAMA raiseAPokemon EN EL DIAGRAMA DE CLASES
        //HAY QUE ASEGURARSE QUE SE TENGAN, AL MENOS, 2 POKÉMON PARA
        //PODER CRIAR
        int counter = 0;
        int randomSelect;
        //CREO UNA ARRAY DE 3, POSICIÓN1 PARA EL PRIMER POKEMON SELECCIONADO
        //POSICIÓN DOS PARA EL SEGUNDO, Y POSICIÓN 3 PARA EL NUEVO POKÉMON;
        Pokemon[] breeding = new Pokemon[3];
        for(Pokemon p: pokemonTeam){
            if(p != null){
                counter++;
            }
        }
        if(counter < 2){
            return "Necesitas tener al menos 2 Pokémon en el equipo";
        }
        else{
            Random random = new Random();
            randomSelect = random.nextInt(2);
            breeding[0] = pokemon1;
            breeding[1] = pokemon2;
            //NECESITAMOS CREAR UN NUEVO POKEMON QUE SERÁ EL QUE TOQUE
            //EN EL RANDOM, CON EL SEXO RANDOM Y PUEDE QUE ATAQUES COMBINADOS
            //DE LOS DOS POKÉMON

            /*breeding[randomSelect];
            pokemonBox.add();
            breeding[2] =
             */

            //Se abrirá una nueva ventana con el nuevo pokémon
            //y todas sus stats
            return "Enhorabuena ...";


        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return pokedollar == trainer.pokedollar && Objects.equals(name, trainer.name) && Arrays.equals(pokemonTeam, trainer.pokemonTeam) && Objects.equals(pokemonBox, trainer.pokemonBox) && Objects.equals(backPack, trainer.backPack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, pokemonBox, pokedollar, backPack);
        result = 31 * result + Arrays.hashCode(pokemonTeam);
        return result;
    }
}
