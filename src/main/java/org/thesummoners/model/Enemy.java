package org.thesummoners.model;

import java.util.Random;

public class Enemy {
    private String name;
    private int pokemonTrainerLevel;
    private Pokemon[] enemyTeam;
    Random random = new Random();

    public Enemy(){
        //EL ENTRENADO ENEMIGO TENDRÁ UN EQUIPO POKÉMON DE ENTRE
        //1 Y 3 POKÉMON DE FORMA ALEATORIA.

        enemyTeam = new Pokemon[random.nextInt(3)+1];
        dragPokemonIntoTeam();
    }

    public Pokemon[] dragPokemonIntoTeam(){

        //el nivel del pokemon enemigo tiene que ser del mismo nivel que tu primer
        //pokemon de Trainer.pokemonTeam
        for (int i = 0; i < Trainer.getTrainer().getPokemonTeam().length; i++){
            //sacamos el nivel del primer pokemon del equipo Pokémon del Trainer
            if(Trainer.getTrainer().getPokemonTeam()[i] != null){
                this.pokemonTrainerLevel = Trainer.getTrainer().getPokemonTeam()[i].getLevel();
                break;
            }
        }
        //AQUÍ TENEMOS QUE METER POKEMON ALEATORIOS AL EQUIPO DESDE LA ARRAY pokedex
        //CON EL NIVEL QUE DEBEN TENER
        for(int i = 0; i < enemyTeam.length; i++){
            this.enemyTeam[i] = Pokemon.pokedex[random.nextInt(Pokemon.pokedex.length-1)];
            this.enemyTeam[i].setLevel(pokemonTrainerLevel);
        }
        return this.enemyTeam;
    }
}
