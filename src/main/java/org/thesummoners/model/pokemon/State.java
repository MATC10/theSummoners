package org.thesummoners.model.pokemon;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public enum State {
    PARALYSED, BURNED, POISONED, ASLEEP, FROZEN, DEBILITATED, ALIVE, RESTING;

    public static void applyState(Pokemon pokemon1, int staminaPokemon) throws InterruptedException {


        if(pokemon1.getState() == ASLEEP){
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra dormido");
        }
        else if(pokemon1.getState() == RESTING){
            pokemon1.setState(State.ALIVE);
            //RECUPERA 100 DE STAMINA O HASTA EL MÁXIMO DEL QUE DISPONGA (SI SU MÁXIMO ES MENOS DE 100)
            pokemon1.rest();
            //CALCULAR LA STAMINA MÁXIMA DEL POKEMON Y NO SUBIR DE AHÍ
            if(pokemon1.getStamina() > staminaPokemon) pokemon1.setStamina(staminaPokemon);
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se ha despertado");

        }
        else if(pokemon1.getState() == FROZEN){
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra congelado");
        }
        else if(pokemon1.getState() == BURNED){
            //LE QUITA EL 10% DE VIDA
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra quemado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
        }
        else if(pokemon1.getState() == POISONED){
            //LE QUITA EL 10% DE VIDA
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra envenenado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
        }


    }
}

