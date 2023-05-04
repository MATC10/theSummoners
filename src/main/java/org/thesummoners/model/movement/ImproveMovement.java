package org.thesummoners.model.movement;

import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;

import java.util.Random;

public class ImproveMovement extends Movement implements IStaminaCalculable {
    private int upgradeAttack;
    private int upgradeSpecialAttack;
    private int upgradeDefense;
    private int upgradeSpecialDefense;
    private int numberOfTurnsDuration;
    public ImproveMovement(String name, int upgradeAttack, int upgradeSpecialAttack,  int upgradeDefense, int upgradeSpecialDefense) {

        super(name);
        this.upgradeAttack = upgradeAttack;
        this.upgradeSpecialAttack = upgradeSpecialAttack;
        this.upgradeDefense = upgradeDefense;
        this.upgradeSpecialDefense = upgradeSpecialDefense;
        this.setMovementType("improve");
        TurnsDurationcalculation();
        staminaCalculation();
    }


    public int getNumberOfTurnsDuration() {
        return numberOfTurnsDuration;
    }

    public void setNumberOfTurnsDuration(int numberOfTurnsDuration) {
        this.numberOfTurnsDuration = numberOfTurnsDuration;
    }

    public int getUpgradeAttack() {
        return upgradeAttack;
    }

    public void setUpgradeAttack(int upgradeAttack) {
        this.upgradeAttack = upgradeAttack;
    }

    public int getUpgradeDefense() {
        return upgradeDefense;
    }

    public void setUpgradeDefense(int upgradeDefense) {
        this.upgradeDefense = upgradeDefense;
    }

    public int getUpgradeSpecialAttack() {
        return upgradeSpecialAttack;
    }

    public void setUpgradeSpecialAttack(int upgradeSpecialAttack) {
        this.upgradeSpecialAttack = upgradeSpecialAttack;
    }

    public int getUpgradeSpecialDefense() {
        return upgradeSpecialDefense;
    }

    public void setUpgradeSpecialDefense(int upgradeSpecialDefense) {
        this.upgradeSpecialDefense = upgradeSpecialDefense;
    }

    public void TurnsDurationcalculation(){
        Random random = new Random();
        this.numberOfTurnsDuration = random.nextInt(4)+1;
    }

    public static void improveCombat(Pokemon pokemon, Movement movement){
        ImproveMovement improveMovement =  (ImproveMovement) movement;
        Random random = new Random();
        int randomStopImprove = 9999;
        boolean counterTurnsImprove = true;


        int attackOrNot = random.nextInt(2);
        if(pokemon.getState() == State.PARALYSED && attackOrNot == 0 && counterTurnsImprove == true) {
            pokemon.setAttackPower(pokemon.getAttackPower() + improveMovement.getUpgradeAttack());
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + improveMovement.getUpgradeSpecialAttack());
            pokemon.setDefense(pokemon.getDefense() + improveMovement.getUpgradeDefense());
            pokemon.setSpecialDefense(pokemon.getSpecialDefense() + improveMovement.getUpgradeSpecialDefense());
            counterTurnsImprove = true;
        }
        else {
            //if(random.nextInt(3) == 0) counterTurnsImprove = false;
        }
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(getStamina() - (this.getNumberOfTurnsDuration() * 10));
    }
}
