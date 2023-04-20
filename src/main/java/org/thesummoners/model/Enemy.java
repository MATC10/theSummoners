package org.thesummoners.model;

import org.thesummoners.model.pokemon.Ivysaur;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Venusaur;

import java.util.Random;

public class Enemy {
    public static Enemy [] enemyArray = new Enemy [10];
    private String name;
    private String image;
    private int pokemonTrainerLevel;
    private Pokemon[] enemyTeam;
    Random random = new Random();

    public Enemy(String name, String image){
        //EL ENTRENADO ENEMIGO TENDRÁ UN EQUIPO POKÉMON DE ENTRE
        //1 Y 3 POKÉMON DE FORMA ALEATORIA.

        enemyTeam = new Pokemon[random.nextInt(3)+1];
        dragPokemonIntoTeam();

        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPokemonTrainerLevel() {
        return pokemonTrainerLevel;
    }

    public void setPokemonTrainerLevel(int pokemonTrainerLevel) {
        this.pokemonTrainerLevel = pokemonTrainerLevel;
    }

    public Pokemon[] getEnemyTeam() {
        return enemyTeam;
    }

    public void setEnemyTeam(Pokemon[] enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public void dragPokemonIntoTeam(){

        //el nivel del pokemon enemigo tiene que ser del mismo nivel que tu primer
        //pokemon de Trainer.pokemonTeam
        for (int i = 0; i < Trainer.getTrainer().getPokemonTeam().length; i++){
            //sacamos el nivel del primer pokemon del equipo Pokémon del Trainer
            if(Trainer.getTrainer().getPokemonTeam()[i] != null){
                this.pokemonTrainerLevel = Trainer.getTrainer().getPokemonTeam()[i].getLevel();
                break;
            }
        }
        /*AÑADO ESTO EN LA ARRAY POKÉDEX PARA QUE NO DE FALLO EL MÉTODO
        dragPokemonIntoTeam() DE LA CLASE ENEMY Y NO DE ERROR AL LUCHAR
         */
        Pokemon.pokedex.add(new Pokemon("Bulbasaur", 1));
        Pokemon.pokedex.add(new Ivysaur("Ivysaur", 1));
        Pokemon.pokedex.add(new Venusaur("Venusaur", 1));

        //AQUÍ TENEMOS QUE METER POKEMON ALEATORIOS AL EQUIPO DESDE LA ARRAY pokedex
        //CON EL NIVEL QUE DEBEN TENER
        for(int i = 0; i < enemyTeam.length; i++){
            this.enemyTeam[i] = Pokemon.pokedex.get(random.nextInt(Pokemon.pokedex.size()));
            this.enemyTeam[i].setLevel(pokemonTrainerLevel);
        }
    }
}
