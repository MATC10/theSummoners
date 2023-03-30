package org.thesummoners.model;

import java.util.List;

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

    public void dragPokemonIntoBox(Pokemon[] pokemonTeam, int i){
    pokemonBox.add(pokemonTeam[i]);
    pokemonTeam[i] = null;
    }

}
