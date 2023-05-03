package org.thesummoners.model.pokemon;

import javafx.scene.control.Label;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public enum State {
    PARALYSED, BURNED, POISONED, ASLEEP, FROZEN, DEBILITATED, ALIVE, RESTING;

    public static void applyState(Pokemon pokemon1, Turns turn, Label lblTextFight) throws InterruptedException {
        int numberTurn = turn.getNumberTurn();
        Random random = new Random();
        if(pokemon1.getState() == DEBILITATED){
            //HAY QUE CAMBIAR DE POKEMON

            //TODO AQUÍ CUANDO ESTÉ VINCULADO CON LA BD TENEMOS
            // QUE PONER LA VENTANA PARA QUE CAMBIE DE POKEMON
        }
        else if(pokemon1.getState() == ASLEEP){
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra dormido");
            Thread.sleep(1000);
        }
        else if(pokemon1.getState() == RESTING){
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra dormido");
            Thread.sleep(1000);
        }
        else if(pokemon1.getState() == FROZEN){
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra congelado");
            Thread.sleep(1000);
        }
        else if(pokemon1.getState() == BURNED){
            //LE QUITA EL 10% DE VIDA
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra quemado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
            Thread.sleep(1000);
        }
        else if(pokemon1.getState() == POISONED){
            //LE QUITA EL 10% DE VIDA
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra envenenado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
            Thread.sleep(1000);
        }

    }
}

