package org.thesummoners.model;

public class AttackMovement extends Movement{

    private int movementPower;
    private Type attackType;
    public AttackMovement(String name, int movementPower, Type attackType) {
        super(name);
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
