package org.thesummoners.model.trainer;


import org.thesummoners.model.pokemon.*;

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
        pokemonIntoTeam();

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

    public void pokemonIntoTeam(){

        //el nivel del pokemon enemigo tiene que ser del mismo nivel que tu primer
        //pokemon de Trainer.pokemonTeam
        for (int i = 0; i < Trainer.getTrainer().getPokemonTeam().length; i++){
            //sacamos el nivel del primer pokemon del equipo Pokémon del Trainer
            if(Trainer.getTrainer().getPokemonTeam()[i] != null){
                this.pokemonTrainerLevel = Trainer.getTrainer().getPokemonTeam()[i].getLevel();
                break;
            }
        }

        //FIXME AÑADIR POKEMON A  POKEDEX PARA QUE NO DE FALLO EL MÉTODO pokemonIntoTeam()
        // DE LA CLASE ENEMY Y NO DE ERROR AL LUCHAR
        Pokedex.getPokedex().addAll(new Pokemon("Pikachu", 25, "doc/images/Pikachu.png", "doc/images/spritesback/3a-b__025__xy.gif",135,1, 55,50,40,50,90, 150, Type.ELECTRIC, null, State.ALIVE, Sex.F, 0, null),
                new Pokemon("Bulbasaur", 1, "doc/images/Bulbasaur.png", "doc/images/spritesback/3a-b__001__xy.gif",145,1, 49,65,49,65,45, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.M, 0, null),
                new Pokemon("Squirtle", 7, "doc/images/Squirtle.png", "doc/images/spritesback/3a-b__007__xy.gif",144,1, 48,50,65,64,43, 150, Type.WATER, null, State.ALIVE, Sex.F, 0, null),
                new Pokemon("Charmander", 4, "doc/images/Charmander.png", "doc/images/spritesback/3a-b__004__xy.gif",139,1, 52,60,43,50,65, 150, Type.WATER, null, State.ALIVE, Sex.F, 0, null));

        //AQUÍ TENEMOS QUE METER POKEMON ALEATORIOS AL EQUIPO DESDE LA ARRAY pokedex
        //CON EL NIVEL QUE DEBEN TENER
        for(int i = 0; i < enemyTeam.length; i++){
            this.enemyTeam[i] =  Pokedex.getPokedex().get(random.nextInt( Pokedex.getPokedex().size()));
            this.enemyTeam[i].setLevel(pokemonTrainerLevel);
        }
    }
}
