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

    public static void improveCombat(Pokemon pokemon1, Movement movement, Label lblTextFight) throws InterruptedException {
        if(movement.getMovementType().equals("improve") ) {
            ImproveMovement improveMovement = (ImproveMovement) movement;
            Random random = new Random();

            int attackOrNot = random.nextInt(2);

            if (pokemon1.getState() != State.PARALYSED) {
                pokemon1.setAttackPower(pokemon1.getAttackPower() + improveMovement.getUpgradeAttack());
                pokemon1.setSpecialAttack(pokemon1.getSpecialAttack() + improveMovement.getUpgradeSpecialAttack());
                pokemon1.setDefense(pokemon1.getDefense() + improveMovement.getUpgradeDefense());
                pokemon1.setSpecialDefense(pokemon1.getSpecialDefense() + improveMovement.getUpgradeSpecialDefense());
                lblTextFight.setText(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());
                Thread.sleep(1000);
            } else if(attackOrNot == 0 && pokemon1.getState() == State.PARALYSED){
                pokemon1.setAttackPower(pokemon1.getAttackPower() + improveMovement.getUpgradeAttack());
                pokemon1.setSpecialAttack(pokemon1.getSpecialAttack() + improveMovement.getUpgradeSpecialAttack());
                pokemon1.setDefense(pokemon1.getDefense() + improveMovement.getUpgradeDefense());
                pokemon1.setSpecialDefense(pokemon1.getSpecialDefense() + improveMovement.getUpgradeSpecialDefense());
                lblTextFight.setText(pokemon1.getDisplayName() + " ha usado el movimiento " + movement.getName());
                Thread.sleep(1000);
            }
            else if(attackOrNot != 0 && pokemon1.getState() == State.PARALYSED){
                lblTextFight.setText(pokemon1.getDisplayName() + " no puede moverse porque se encuentra paralizado");
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void staminaCalculation() {
        this.setStamina(getStamina() - (this.getNumberOfTurnsDuration() * 10));
    }
}
