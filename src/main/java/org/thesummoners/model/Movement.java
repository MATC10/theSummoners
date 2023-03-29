package org.thesummoners.model;

public abstract class Movement {

    private String name;
    private int numberOfTurns;
    private int numberOfTurnsDuration;



    public Movement(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

/*
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

 */

    @Override
    public String toString() {
        return "Movement{" +
                "name='" + name + '\'' +
                '}';
    }
}
