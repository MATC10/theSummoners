package org.thesummoners.model;

public class AttackMovement extends Movement{

    private int movementPower;
    private Type attackType;
    public AttackMovement(String movementName, int movementPower, Type attackType) {
        super(movementName);
        this.movementPower = movementPower;
        this.attackType= attackType;

    }

    public int getMovementPower() {
        return movementPower;
    }

    public void setMovementPower(int movementPower) {
        this.movementPower = movementPower;
    }

    public void improveAttack(){

    }
}
