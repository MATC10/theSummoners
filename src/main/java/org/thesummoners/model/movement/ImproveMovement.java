package org.thesummoners.model.movement;

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

    @Override
    public void staminaCalculation() {
        this.setStamina(this.getNumberOfTurnsDuration() * 10);
    }
}
