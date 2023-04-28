package org.thesummoners.model.movement;

import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Type;

public class AttackMovement extends Movement implements IStaminaCalculable {

    private int power;
    private Type type;

    public AttackMovement(String name, int power, Type type) {
        super(name);
        this.power = power;
        this.type= type;
        this.setMovementType("attack");
        staminaCalculation();
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

    //SI EL ATAQUE ES DEL MISMO TIPO QUE ALGUNO DE LOS DEL POKÉMON, MULTIPLICAMOS EL DAÑO POR 1.5
    public float improveAttack(Pokemon pokemon, AttackMovement attack){
        if(pokemon.getType1() == attack.getType() || pokemon.getType2() == attack.getType())
            return 1.5f;
        return 1;
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(this.getPower() / 2);
    }
}
