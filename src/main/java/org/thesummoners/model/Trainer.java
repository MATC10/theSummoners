package org.thesummoners.model;

import java.util.LinkedList;

public class Trainer {

    private String name;
    private Pokemon[] pokemonTeam;
    private LinkedList<Pokemon> pokemonBox;
    private int pokedollar;
    private LinkedList<Objeto> backPack;

    public Trainer(String name){
        this.name= name;
        this.backPack = new LinkedList<>();
        this.pokemonBox = new LinkedList<>();
        this.pokedollar = 0;
        this.pokemonTeam = new Pokemon[6];
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

    public LinkedList<Pokemon> getPokemonBox() {
        return pokemonBox;
    }

    public void setPokemonBox(LinkedList<Pokemon> pokemonBox) {
        this.pokemonBox = pokemonBox;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public LinkedList<Objeto> getBackPack() {
        return backPack;
    }

    public void setBackPack(LinkedList<Objeto> backPack) {
        this.backPack = backPack;
    }

    public void dragToBox(Pokemon pokemonID){
        for (Pokemon i: pokemonTeam) {
            if(pokemonID.equals())
        }
    }

}
