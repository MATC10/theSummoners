package org.thesummoners.model.movement;

import org.thesummoners.model.pokemon.State;

import java.util.Random;

public class StateMovement extends Movement implements IStaminaCalculable {
    private State stateToApply;
    private int numberOfTurnsDuration;

    public StateMovement(String name, State stateToApply) {

        super(name);
        this.stateToApply = stateToApply;
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

    @Override
    public void staminaCalculation() {
        this.setStamina(this.getNumberOfTurnsDuration() * 10);
    }
}
