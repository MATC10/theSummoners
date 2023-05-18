package org.thesummoners.model.movement;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.util.Random;

public class StateMovement extends Movement{
    private State stateToApply;
    private int numberOfTurnsDuration;

    public StateMovement(String name, State stateToApply) {

        super(name);
        this.stateToApply = stateToApply;
        this.setMovementType("state");
        TurnsDurationcalculation();
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

    /**
     * Cambia el estado de los Pokémon en combate
     * @param pokemon1
     * @param pokemon2
     * @param movement
     * @throws InterruptedException
     */
    public static void stateCombat(Pokemon pokemon1, Pokemon pokemon2, Movement movement) throws InterruptedException {
        //CREAMOS UN RANDOM PARA CUANDO ESTÉ PARALIZADO
        Random random = new Random();
        int attackOrNot = random.nextInt(2);


        if (movement.getMovementType().equals("state")){
            //HACEMOS UN CASTING PARA OBTENER LOS MÉTODOS DE StateMovement
            StateMovement stateMovement = (StateMovement) movement;
            if (pokemon2.getState() != State.RESTING && pokemon2.getState() != State.PARALYSED){
                if(pokemon2.getState() == State.POISONED ||
                        pokemon2.getState() == State.FROZEN || pokemon2.getState() == State.ASLEEP ||
                        pokemon2.getState() == State.BURNED) {
                    Trainer.getTrainer().getSentencesTextFight().add(pokemon2.getDisplayName() + " ya se encuentra afectado por otro estado");
                }
                else{
                    //CAMBIAMOS EL ESTADO DEL POKÉMON ENEMIGO AL ESTADO QUE APLICA EL MOVIMIENTO
                    pokemon2.setState(stateMovement.getStateToApply());
                    Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());
                }
            }
            else if(pokemon2.getState() != State.RESTING && pokemon2.getState() == State.PARALYSED && attackOrNot == 0){
                if(pokemon2.getState() == State.POISONED ||
                        pokemon2.getState() == State.FROZEN || pokemon2.getState() == State.ASLEEP ||
                        pokemon2.getState() == State.BURNED){
                    Trainer.getTrainer().getSentencesTextFight().add(pokemon2.getDisplayName() + " ya se encuentra afectado por otro estado");
                }
                else{
                    pokemon2.setState(stateMovement.getStateToApply());
                    Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());
                }
            }
            else{
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " no puede moverse porque se encuentra paralizado");
            }

        }
    }
}
