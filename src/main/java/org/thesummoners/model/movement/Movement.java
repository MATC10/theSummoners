package org.thesummoners.model.movement;

public abstract class Movement {

    private String name;
    private int stamina;


    public Movement(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
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