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
    public static String [] nameEnemy;
    public static String [] imageEnemy;
    public static HashMap <String, String> nameAndImageEnemy;
    private int pokemonTrainerLevel;
    private static Pokemon[] enemyTeam;
    Random random = new Random();

    public Enemy() throws CloneNotSupportedException {
        //EL ENTRENADO ENEMIGO TENDRÁ UN EQUIPO POKÉMON DE ENTRE
        //1 Y 3 POKÉMON DE FORMA ALEATORIA.

        enemyTeam = new Pokemon[random.nextInt(3)+1];
        pokemonIntoTeam();
    }


    public static HashMap<String, String> getNameAndImageEnemy() {
        return nameAndImageEnemy;
    }

    public static void setNameAndImageEnemy(HashMap<String, String> nameAndImageEnemy) {
        Enemy.nameAndImageEnemy = nameAndImageEnemy;
    }


    public int getPokemonTrainerLevel() {
        return pokemonTrainerLevel;
    }

    public void setPokemonTrainerLevel(int pokemonTrainerLevel) {
        this.pokemonTrainerLevel = pokemonTrainerLevel;
    }

    public static Pokemon[] getEnemyTeam() {
        return enemyTeam;
    }

    public void setEnemyTeam(Pokemon[] enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public void pokemonIntoTeam() throws CloneNotSupportedException {

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

            if(this.enemyTeam[i].getLearnedMovement()[i] == null){
                this.enemyTeam[i].getLearnedMovement()[i] = MovementInitializer.movementListFull().get(random.nextInt(30));
            }

        }
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
                AttackMovement.attackCombat(pokemon2, pokemon1, pokemon2.getLearnedMovement()[random.nextInt(counter)], lblTextFight);
                StateMovement.stateCombat(pokemon1, pokemon2.getLearnedMovement()[random.nextInt(counter)], lblTextFight);
                ImproveMovement.improveCombat(pokemon1, pokemon2.getLearnedMovement()[random.nextInt(counter)], lblTextFight);
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
