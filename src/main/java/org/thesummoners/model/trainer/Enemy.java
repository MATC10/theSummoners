package org.thesummoners.model.trainer;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.thesummoners.model.movement.*;
import org.thesummoners.model.pokemon.*;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class Enemy {
    static Enemy enemy = null;
    public Pokemon pokemon2;
    public static String [] nameEnemy;
    public static String [] imageEnemy;
    private int pokemonTrainerLevel;
    private static Pokemon[] enemyTeam;
    Random random = new Random();

    public Enemy() throws CloneNotSupportedException {
        //EL ENTRENADO ENEMIGO TENDRÁ UN EQUIPO POKÉMON DE ENTRE
        //1 Y 3 POKÉMON DE FORMA ALEATORIA.
//TODO HACER TRAINER ESTATICO Y HACER UN METODO PARA QUE AL ACABAR CADA COMBATE O AL EMPEZAR SE LE PONGAN NUEVOS POKEMON
        enemyTeam = new Pokemon[random.nextInt(3)+1];
        pokemonIntoTeam();
    }

    public static Enemy getEnemy() throws CloneNotSupportedException {
        synchronized (Enemy.class){
            if(enemy == null){
                enemy = new Enemy();
            }
        }
        return enemy;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public static String[] getNameEnemy() {
        return nameEnemy;
    }

    public static void setNameEnemy(String[] nameEnemy) {
        Enemy.nameEnemy = nameEnemy;
    }

    public static String[] getImageEnemy() {
        return imageEnemy;
    }

    public static void setImageEnemy(String[] imageEnemy) {
        Enemy.imageEnemy = imageEnemy;
    }

    public int getPokemonTrainerLevel() {
        return pokemonTrainerLevel;
    }

    public void setPokemonTrainerLevel(int pokemonTrainerLevel) {
        this.pokemonTrainerLevel = pokemonTrainerLevel;
    }

    public  Pokemon[] getEnemyTeam() {
        return enemyTeam;
    }

    public void setEnemyTeam(Pokemon[] enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public Pokemon[] pokemonIntoTeam() throws CloneNotSupportedException {
        Random random = new Random();
        enemyTeam = new Pokemon[random.nextInt(3)+1];
        //el nivel del pokemon enemigo tiene que ser del mismo nivel que tu primer
        //pokemon de Trainer.pokemonTeam
            //sacamos el nivel del primer pokemon del equipo Pokémon del Trainer
        this.pokemonTrainerLevel = Trainer.getTrainer().getPokemonTeam()[0].getLevel();


        //AQUÍ TENEMOS QUE METER POKEMON ALEATORIOS AL EQUIPO DESDE LA ARRAY pokedex
        //CON EL NIVEL QUE DEBEN TENER
        for(int i = 0; i < enemyTeam.length; i++){
            this.enemyTeam[i] =  Pokedex.getPokedex().get(random.nextInt( Pokedex.getPokedex().size())).clone();
            this.enemyTeam[i].setLevel(pokemonTrainerLevel);
            this.enemyTeam[i].adaptStatsToLevel(this.enemyTeam[i].getLevel(), this.enemyTeam[i]);
            //QUE APRENDA EL 2º, 3º Y 4º ATAQUE
            for(int j = 1; j <= 3; j++){
                this.enemyTeam[i].getLearnedMovement()[j] = MovementInitializer.movementListFull().get(random.nextInt(30));
            }
            }
        return enemyTeam;
    }

    public void fight(Pokemon pokemon2, Pokemon pokemon1, Movement movement, Turns turn, Label lblTextFight) throws CloneNotSupportedException, InterruptedException {
        //TODO DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO
        //GUARDAMOS LA STAMINA DEL POKEMON AL INICIO DE LA BATALLA
        int staminaPokemon2 = pokemon2.getStamina();

        //CREAMOS UN RANDOM Y UN COUNTER PARA QUE EL ENEMY PUEDA ATACAR DE FORMA ALEATORIA
        Random random = new Random();
        int counter = 0;
        //CON ESTA VARIABLE CALCULAREMOS CUÁNDO QUITAR LOS ESTADOS
        int removeState;

        for(Movement m : pokemon2.getLearnedMovement()){
            if(m != null) counter++;
        }
        State.applyState(pokemon2, staminaPokemon2, lblTextFight);
        //SE ASIGNA EL MOVIMIENTO RANDOM AL ENEMIGO

        if(pokemon2.getState() != State.RESTING && pokemon2.getState() != State.ASLEEP &&
                pokemon2.getState() != State.DEBILITATED && pokemon2.getState() != State.FROZEN) {
            if(pokemon2.getStamina() >= movement.getStamina()){
                AttackMovement.attackCombat(pokemon2, pokemon1, movement, lblTextFight);
                StateMovement.stateCombat(pokemon1, movement, lblTextFight);
                ImproveMovement.improveCombat(pokemon1, movement, lblTextFight);
                pokemon2.setStamina(pokemon1.getStamina() - movement.getStamina());
            }
            else {
                pokemon2.setState(State.RESTING);
                lblTextFight.setText(pokemon2.getDisplayName() + " se encuentra dormido para recargar Stamina");
                Thread.sleep(1000);
            }

        }
        //AQUÍ SE QUITAN LOS DISTINTOS EFECTOS DEL ENEMIGO: PARALYSED, BURNED, POISONED, ASLEEP, FROZEN Y PASA A ALIVE SI ESTÁ VIVO
        removeState = random.nextInt(4);
        if((pokemon2.getState() == State.ASLEEP || pokemon2.getState() == State.FROZEN ||
                pokemon2.getState() == State.PARALYSED ||  pokemon2.getState() == State.BURNED ||
                pokemon2.getState() == State.POISONED) && pokemon2.getHp() > 0 && removeState == 0){
            pokemon2.setState(State.ALIVE);
            lblTextFight.setText(pokemon2.getDisplayName() + " ya no se encuentra afectado por ningún estado");
            Thread.sleep(1000);
        }

        //QUE SE PAUSE DURANTE UN SEGUNDO LA APLICACIÓN
        turn.nextTurn(turn.isCurrentTurn());
        //TODO PONER UNA LABEL CON EL TURNO
        Thread.sleep(1000);

    }


    public static void WantsToFightEnemy(ImageView imgEnemy, Label lblWantsToFight){
        //LLENAMOS EL HASHMAL Y DEVOLVEMOS EL NOMBRE Y LA IMAGEN DEL ENEMIGO A MOSTRAR

        Random random = new Random();

        int arrayValor = random.nextInt(10);
        nameEnemy = new String[] {"Pescador", "Entre.guay", "Marinero", "Caza bichos", "Pokemaniaco",
                "Científico loco", "Calvo con cresta", "Súper nerd", "Pokecolector", "Malabarista"};

        imageEnemy = new String[] {"doc/images/pescador.png", "doc/images/entreGuay.png", "doc/images/marinero.png",
                 "doc/images/cazaBichos.png", "doc/images/pokemaniaco.png",
                "doc/images/cientifico.png", "doc/images/calvo.png", "doc/images/superNerd.png", "doc/images/pokecolector.png",
                "doc/images/malabarista.png"};



        File file = new File(Enemy.imageEnemy[arrayValor]);
        Image image = new Image(file.toURI().toString());
        imgEnemy.setImage(image);

        lblWantsToFight.setText("¡" + Enemy.nameEnemy[arrayValor] +  " quiere luchar!");

    }
}
