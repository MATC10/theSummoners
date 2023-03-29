package org.thesummoners.model;

public class StateMovement extends Movement{
    private State stateToApply;
    private int stateDuration; //se mide en turnos

    public StateMovement(String movementName, State stateToApply) {
        super(movementName);
    }
}
