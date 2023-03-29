package org.thesummoners.model;

public abstract class Movement {

    private String movementName;
    private int numberOfTurns;
    private int numberOfTurnsDuration;

    public Movement(String movementName){
        this.movementName = movementName;
    }


    public String getMovementName() {
        return movementName;
    }

    public void setMovementName(String movementName) {
        this.movementName = movementName;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }


    public int getUpgradeToApply() {
        return upgradeToApply;
    }

    public void setUpgradeToApply(int upgradeToApply) {
        this.upgradeToApply = upgradeToApply;
    }

    public int getNumberOfTurnsDuration() {
        return numberOfTurnsDuration;
    }

    public void setNumberOfTurnsDuration(int getNumberOfTurnsDuration) {
        this.numberOfTurnsDuration = getNumberOfTurnsDuration;
    }
}
