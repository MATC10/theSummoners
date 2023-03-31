package org.thesummoners.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Trainer {
    private String name;
    private Pokemon[] pokemonTeam;
    private List<Pokemon> pokemonBox;
    private int pokedollar;
    private List<Objeto> backPack;

    public Trainer(String name, Pokemon[] pokemonTeam, List<Pokemon> pokemonBox, int pokedollar, List<Objeto> backPack) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
        this.pokemonBox = pokemonBox;
        this.pokedollar = pokedollar;
        this.backPack = backPack;
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
