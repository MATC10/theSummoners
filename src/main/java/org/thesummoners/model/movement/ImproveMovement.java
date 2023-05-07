package org.thesummoners.model.movement;

import javafx.scene.control.Label;
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

    public static void improveCombat(Pokemon pokemon, Movement movement, Label lblTextFight){
        if(movement.getMovementType().equals("improve") ) {
            ImproveMovement improveMovement = (ImproveMovement) movement;
            Random random = new Random();

            int attackOrNot = random.nextInt(2);

            if (pokemon.getState() != State.PARALYSED) {
                pokemon.setAttackPower(pokemon.getAttackPower() + improveMovement.getUpgradeAttack());
                pokemon.setSpecialAttack(pokemon.getSpecialAttack() + improveMovement.getUpgradeSpecialAttack());
                pokemon.setDefense(pokemon.getDefense() + improveMovement.getUpgradeDefense());
                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + improveMovement.getUpgradeSpecialDefense());
            } else if(attackOrNot == 0 && pokemon.getState() == State.PARALYSED){
                pokemon.setAttackPower(pokemon.getAttackPower() + improveMovement.getUpgradeAttack());
                pokemon.setSpecialAttack(pokemon.getSpecialAttack() + improveMovement.getUpgradeSpecialAttack());
                pokemon.setDefense(pokemon.getDefense() + improveMovement.getUpgradeDefense());
                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + improveMovement.getUpgradeSpecialDefense());
            }
            else{
                lblTextFight.setText(pokemon.getDisplayName() + " no puede atacar porque se encuentra paralizado");
            }
        }
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(getStamina() - (this.getNumberOfTurnsDuration() * 10));
    }
}
