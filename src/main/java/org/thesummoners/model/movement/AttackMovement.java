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

    public void attackCombat(Pokemon pokemon1, Pokemon pokemon2, Movement movement){
        //COMPROBAMOS QUE EL MOVIMIENTO SEA DE ATAQUE Y CREAMOS LAS VARIABLES DE DAÑO
        if(movement.getMovementType().equals("attack")){
            float baseDamage = pokemon1.getAttackPower() + pokemon1.getSpecialAttack();
            float summedAmountDamage = 0;

            //if(pokemon1.get)





        }
        /*
        AÑADIR QUIEN ATACA PRIMERO

metedo boton ataque(p1,p2,move1){
método fight(p1,p2){
(AÑADIR EL DAÑO DEL POSIBLE OBJETO, HACER LOS CALCULOS DE LOS MULTIPLICADORES SOBRE LA STAT BASE DE ATAQUE Y TENER LA CANTIDAD DE DAÑO QUE SE SUBE PARA LUEGO SUMARLO)
if(move1.getType==p1.getType1 || move1.getType==p1.getType2){
danioSumado+=(danioBase*1.5 - danioBase);
}

danioSumado+= (danioBase* move1.checkAdvantage(P1, P2)) - danioBase;

//HACER AQUÍ EL METODO PARA SUMAR EL DAÑO PRODUCIDO POR LLEVAR OBJETO



danioBase+= danioSumado;

p2.setHp(p2.getHp - danioSumado);

if(p2.getHp <= 0){
p2.setState(State.DEBILITED)
}
}


if(p2.getState==debilited){
*sacar otro pokemon*
}
}

}
         */
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(this.getPower() / 2);
    }


}
