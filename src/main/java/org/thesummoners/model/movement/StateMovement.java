package org.thesummoners.model.movement;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public class StateMovement extends Movement implements IStaminaCalculable {
    private State stateToApply;
    private int numberOfTurnsDuration;

    public StateMovement(String name, State stateToApply) {

        super(name);
        this.stateToApply = stateToApply;
        this.setMovementType("state");
        TurnsDurationcalculation();
        staminaCalculation();
    }

    public State getStateToApply() {
        return stateToApply;
    }

    public void setStateToApply(State stateToApply) {
        this.stateToApply = stateToApply;
    }

    public int getNumberOfTurnsDuration() {
        return numberOfTurnsDuration;
    }

    public void setNumberOfTurnsDuration(int numberOfTurnsDuration) {
        this.numberOfTurnsDuration = numberOfTurnsDuration;
    }

    public void TurnsDurationcalculation(){
        Random random = new Random();
        this.numberOfTurnsDuration = random.nextInt(4)+1;
    }

//TODO METER ESTO EN FIGHT Y CALCULAR LO DE LOS TURNOS PARA EL TRAINER Y EL ENEMIGO SE METE DE MARAMETRO Pokemon1 o Pokemon2
//TODO SEGÚN EL QUE SEA
    public static void stateCombat(Pokemon pokemon1, Pokemon pokemon2, Movement movement) throws InterruptedException {
        //CREAMOS UN RANDOM PARA CUANDO ESTÉ PARALIZADO
        Random random = new Random();
        int attackOrNot = random.nextInt(2);


        if (movement.getMovementType().equals("state")){
            //HACEMOS UN CASTING PARA OBTENER LOS MÉTODOS DE StateMovement
            StateMovement stateMovement = (StateMovement) movement;

            //COMPROBAMOS QUE EL MOVIMIENTO SEA DE ATAQUE Y CREAMOS LAS VARIABLES DE DAÑO
            if (pokemon1.getState() != State.PARALYSED) {

                //CAMBIAMOS EL ESTADO DEL POKÉMON ENEMIGO AL ESTADO QUE APLICA EL MOVIMIENTO
                pokemon2.setState(stateMovement.getStateToApply());
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());

            }
            else if(attackOrNot == 0 && pokemon2.getState() == State.PARALYSED){

                pokemon2.setState(stateMovement.getStateToApply());
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());

            }
            else if (attackOrNot != 0 && pokemon2.getState() == State.PARALYSED){
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " no puede moverse porque se encuentra paralizado");
            }
        }
    }



    @Override
    public void staminaCalculation() {
        this.setStamina( this.getStamina() - (this.getNumberOfTurnsDuration() * 10));
    }
}
