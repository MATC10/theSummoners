package org.thesummoners.model.movement;

import javafx.scene.control.Label;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;

import java.util.Random;

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

    public static void attackCombat(Pokemon pokemon1, Pokemon pokemon2, Movement movement, Label lblTextFight){
        //CREAMOS UN RANDOM PARA CUANDO ESTÉ PARALIZADO
        Random random = new Random();
        int attackOrNot = random.nextInt(2);
        //TODO CAMBIAR ESTO
        if(movement.getMovementType().equals("attack") ) {
        if(pokemon1.getState() != State.PARALYSED){
            //COMPROBAMOS QUE EL MOVIMIENTO SEA DE ATAQUE Y CREAMOS LAS VARIABLES DE DAÑO

            float baseDamage = pokemon1.getAttackPower() + pokemon1.getSpecialAttack();
            float summedAmountDamage = 0;


            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN EL TIPO DE MOVIMIENTO DE ATAQUE
            if (movement.getMovementType().equals(pokemon1.getType1()) ||
                    movement.getMovementType().equals(pokemon1.getType2())) {
                summedAmountDamage += (baseDamage * 1.5f) - baseDamage;
            }

            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN LOS TIPOS DE POKÉMON
            summedAmountDamage += (baseDamage * Pokedex.compareAdvantage(pokemon1, pokemon2) - baseDamage);

            baseDamage += summedAmountDamage;
            if(pokemon1.getState() != State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - baseDamage));
            }
            else if (attackOrNot == 0 && pokemon1.getState() == State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - baseDamage));
            }
            else lblTextFight.setText(pokemon1.getDisplayName() + " no puede atacar porque se encuentra paralizado");


            //TODO AHORA CAMBIAR EL POKEMON2 A DEBILITADO SI TIENE 0 DE VIDA
            //¿HACERLO EN OTRO MÉTODO?
        }
        if(pokemon1.getState() == State.PARALYSED && attackOrNot == 0){


        //COMPROBAMOS QUE EL MOVIMIENTO SEA DE ATAQUE Y CREAMOS LAS VARIABLES DE DAÑO

            float baseDamage = pokemon1.getAttackPower() + pokemon1.getSpecialAttack();
            float summedAmountDamage = 0;


            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN EL TIPO DE MOVIMIENTO DE ATAQUE
            if (movement.getMovementType().equals(pokemon1.getType1()) ||
                    movement.getMovementType().equals(pokemon1.getType2())) {
                summedAmountDamage += (baseDamage * 1.5f) - baseDamage;
            }

            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN LOS TIPOS DE POKÉMON
            summedAmountDamage += (baseDamage * Pokedex.compareAdvantage(pokemon1, pokemon2) - baseDamage);

            baseDamage += summedAmountDamage;
            if(pokemon1.getState() != State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - baseDamage));
            }
            else if (attackOrNot == 0 && pokemon1.getState() == State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - baseDamage));
            }
            else lblTextFight.setText(pokemon1.getDisplayName() + " no puede atacar porque se encuentra paralizado");


            //AHORA CAMBIAR EL POKEMON2 A DEBILITADO SI TIENE 0 DE VIDA
            //¿HACERLO EN OTRO MÉTODO?
        }
        }

    }

    @Override
    public void staminaCalculation() {
        this.setStamina(getStamina() - (this.getPower() / 2));
    }


}
