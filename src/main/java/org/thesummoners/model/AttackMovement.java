package org.thesummoners.model;

public class AttackMovement extends Movement{

    private int movementPower;
    private Type attackType;

    public AttackMovement(String name, int movementPower, Type attackType) {
        super(name);
        this.movementPower = movementPower;
        this.attackType= attackType;
    }

    public Type getAttackType() {
        return attackType;
    }

    public void setAttackType(Type attackType) {
        this.attackType = attackType;
    }

    public int getMovementPower() {

        return movementPower;
    }

    public void setMovementPower(int movementPower) {
        this.movementPower = movementPower;
    }

    //SI EL ATAQUE ES DEL MISMO TIPO QUE EL POKÉMON, MULTIPLICAMOS EL DAÑO POR 1.5
    public void improveAttack(){
        movementPower *= 1.5;
    }
}
