package org.thesummoners.model.pokemon;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.trainer.Enemy;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public enum State {
    PARALYSED, BURNED, POISONED, ASLEEP, FROZEN, DEBILITATED, ALIVE, RESTING;

    public static void applyState(Pokemon pokemon1, int staminaPokemon, Label lblDisplayPkTrainer, Label lblHpTrainer,
                                  Label lblHpMaxTrainer, Label lblLevelTrainer, ImageView imgTrainerPokemon,
                                  Label lblStateTrainer, Label lblDisplayPkEnemy, Label lblHpEnemy, Label lblHpMaxEnemy,
                                  Label lblLevelEnemy, ImageView imgEnemy, Label lblStateEnemy,
                                  Button btnMove1, Button btnMove2, Button btnMove3, Button btnMove4, Button toMainWindow,
                                  ImageView imgPokeball1, ImageView imgPokeball2, ImageView imgPokeball3,
                                  ImageView imgPokeball1Trainer, ImageView imgPokeball2Trainer, ImageView imgPokeball3Trainer,
                                  ImageView imgPokeball4Trainer, ImageView imgPokeball5Trainer, ImageView imgPokeball6Trainer,
                                  Button btnMove5) throws InterruptedException, CloneNotSupportedException {



        if(pokemon1.getState() == RESTING){
            pokemon1.setState(State.ALIVE);
            //RECUPERA 100 DE STAMINA O HASTA EL MÁXIMO DEL QUE DISPONGA (SI SU MÁXIMO ES MENOS DE 100)
            pokemon1.setStamina(staminaPokemon);
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se ha despertado");
        }
        else if(pokemon1.getState() == ASLEEP){
            Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra dormido");
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

        Trainer.getTrainer().changePokemonInFightTrainer(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer,
                lblLevelTrainer, imgTrainerPokemon, lblStateTrainer, imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer,
                btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow);
        Enemy.getEnemy().changePokemonInFightEnemy(lblDisplayPkEnemy,  lblHpEnemy,  lblHpMaxEnemy,  lblLevelEnemy,
                imgEnemy,  lblStateEnemy,  btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow, imgPokeball1,  imgPokeball2,  imgPokeball3,
                btnMove5);
    }
}

