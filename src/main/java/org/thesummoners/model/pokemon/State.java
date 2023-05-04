package org.thesummoners.model.pokemon;

import javafx.scene.control.Label;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public enum State {
    PARALYSED, BURNED, POISONED, ASLEEP, FROZEN, DEBILITATED, ALIVE, RESTING;

    public static void applyState(Pokemon pokemon1, int staminaPokemon, Label lblTextFight) throws InterruptedException {
        Random random = new Random();
        int calculeDuration = random.nextInt(4);

        if(pokemon1.getState() == DEBILITATED){

            //HAY QUE CAMBIAR DE POKEMON
            //UNA IDEA ES QUE SALGA EL MENSAJE DE QUE NO PUEDES LUCHAR Y DEBES CAMBIAR DE POKEMON
            //UN SEGUNDO DESPUES DE APARECE LA VENTANA DE LOS POKEMON QUE PUEDEN LUCHAR

            //TODO AQUÍ CUANDO ESTÉ VINCULADO CON LA BD TENEMOS
            // QUE PONER LA VENTANA PARA QUE CAMBIE DE POKEMON
        }
        else if(pokemon1.getState() == ASLEEP){
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra dormido");
        }
        else if(pokemon1.getState() == RESTING){
            pokemon1.setState(State.ALIVE);
            //RECUPERA 50 DE STAMINA
            pokemon1.rest();
            //CALCULAR LA STAMINA MÁXIMA DEL POKEMON Y NO SUBIR DE AHÍ
            if(pokemon1.getStamina() > staminaPokemon) pokemon1.setStamina(staminaPokemon);
            lblTextFight.setText(pokemon1.getDisplayName() + " se ha despertado");

        }
        else if(pokemon1.getState() == FROZEN){
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra congelado");
        }
        else if(pokemon1.getState() == BURNED){
            //LE QUITA EL 10% DE VIDA
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra quemado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
        }
        else if(pokemon1.getState() == POISONED){
            //LE QUITA EL 10% DE VIDA
            lblTextFight.setText(pokemon1.getDisplayName() + " se encuentra envenenado");
            pokemon1.setHp(pokemon1.getHp() - ((pokemon1.getHp() * 10) / 100));
        }

        if(calculeDuration == 0) pokemon1.setState(ALIVE);
        Thread.sleep(1000);

    }
}

