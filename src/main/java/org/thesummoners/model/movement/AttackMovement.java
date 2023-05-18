package org.thesummoners.model.movement;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.trainer.Trainer;

import java.util.Random;

public class AttackMovement extends Movement {

    private int power;
    private Type type;

    public AttackMovement(String name, int power, Type type) {
        super(name);
        this.power = power;
        this.type= type;
        this.setMovementType("attack");
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

    /**
     *    SI EL ATAQUE ES DEL MISMO TIPO QUE ALGUNO DE LOS DEL POKÉMON, MULTIPLICAMOS EL DAÑO POR 1.5
     * @deprecated Ya no se usa
     */
    public float improveAttack(Pokemon pokemon, AttackMovement attack){
        if(pokemon.getType1() == attack.getType() || pokemon.getType2() == attack.getType())
            return 1.5f;
        return 1;
    }

    /**
     * Calcula todos los daños según si el movimiento s fuerte contra un tipo
     * Si el Pokémon es del mismo tipo que el movimiento de ataque
     * Si el tipo del pokémon es débil contra otro tipo de pokémon
     * El daño mínimo por ataque es 5
     * @param pokemon1
     * @param pokemon2
     * @param movement
     * @throws InterruptedException
     */
    public static void attackCombat(Pokemon pokemon1, Pokemon pokemon2, Movement movement) throws InterruptedException {

        //COMPROBAMOS QUE EL MOVIMIENTO SEA DE ATAQUE Y CREAMOS LAS VARIABLES DE DAÑO
        if(movement.getMovementType().equals("attack") ) {
            AttackMovement attackMovement = (AttackMovement) movement;

            //CREAMOS UN RANDOM PARA CUANDO ESTÉ PARALIZADO
            Random random = new Random();
            int attackOrNot = random.nextInt(2);


            float baseDamage = pokemon1.getAttackPower() + pokemon1.getSpecialAttack();
            float summedAmountDamage = 0;
            //CALCULAMOS LA DEFENSA
            float defense = (pokemon2.getDefense() + pokemon2.getSpecialDefense()) / 3;
            float finalDamage;


            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN EL TIPO DE MOVIMIENTO DE ATAQUE
            if (attackMovement.getType().equals(pokemon1.getType1()) ||
                    attackMovement.getType().equals(pokemon1.getType2())) {
                summedAmountDamage += (baseDamage * 1.5f) - baseDamage;
            }


            //CALCULAMOS LA CANTIDAD DE DAÑO DE ATAQUE SUMADO SEGÚN LOS TIPOS DE POKÉMON
            summedAmountDamage += (baseDamage * Pokedex.compareAdvantage(pokemon1, pokemon2, movement) - baseDamage);

            baseDamage += summedAmountDamage;
            finalDamage = baseDamage - defense;
            if(finalDamage <= 0) finalDamage = 5;

            //EL DAÑO MÍNIMO POR UN ATAQUE ES 5


            if(pokemon1.getState() != State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - finalDamage));
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + attackMovement.getName());
                Trainer.getTrainer().getSentencesTextFight().add("Daño causado: " + finalDamage);
            }
            else if (attackOrNot == 0 && pokemon1.getState() == State.PARALYSED){
                pokemon2.setHp((int) (pokemon2.getHp() - finalDamage));
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ha usado el movimiento " + attackMovement.getName());
                Trainer.getTrainer().getSentencesTextFight().add("Daño causado: " + finalDamage);
            }
            else if (attackOrNot != 0 && pokemon1.getState() == State.PARALYSED){
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " no puede atacar porque se encuentra paralizado");

            }



        }

    }



}
