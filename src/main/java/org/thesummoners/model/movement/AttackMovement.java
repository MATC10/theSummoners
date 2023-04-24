package org.thesummoners.model.movement;

import org.thesummoners.model.Type;

public class AttackMovement extends Movement implements StaminaCalculation {

    private int power;
    private Type type;

    public AttackMovement(String name, int power, Type type,int stamaine) {
        super(name,stamaine);
        this.power = power;
        this.type= type;
        staminaCalculation();
    }

    public AttackMovement(String placaje, int power, org.thesummoners.model.pokemon.Type normal,String name,int stamina) {
        super(name,stamina);
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    //SI EL ATAQUE ES DEL MISMO TIPO QUE EL POKÉMON, MULTIPLICAMOS EL DAÑO POR 1.5
    public int improveAttack(){

        return power *= 1.5;
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(this.getPower() / 2);
    }
}
