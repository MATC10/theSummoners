package org.thesummoners.model.pokemon;

import javafx.scene.control.Label;

public enum State {
    PARALYSED, BURNED, POISONED, ASLEEP, FROZEN, DEBILITATED, ALIVE, RESTING;

    public void applyState(Pokemon pokemon, Label lblTextFight) throws InterruptedException {
        if(pokemon.getState() == DEBILITATED){
            //TODO AQUÍ CUANDO ESTÉ VINCULADO CON LA BD TENEMOS
            // QUE PONER LA VENTANA PARA QUE CAMBIE DE POKEMON
        }
        if(pokemon.getState() == ASLEEP){
            lblTextFight.setText(pokemon.getDisplayName() + " se encuentra dormido");
            Thread.sleep(1000);
        }
        if(pokemon.getState() == RESTING){

        }
        if(pokemon.getState() == FROZEN){

        }
        if(pokemon.getState() == BURNED){

        }
        if(pokemon.getState() == POISONED){

        }
        if(pokemon.getState() == PARALYSED){

        }
        if(pokemon.getState() == ALIVE){

        }

    }
}

