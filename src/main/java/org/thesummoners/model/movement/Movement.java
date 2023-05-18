package org.thesummoners.model.movement;

public abstract class Movement {

    private String name;
    private String movementType;
    private int stamina;


    public Movement(String name){

        this.name = name;
        this.stamina = 35;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
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



    @Override
    public String toString() {
        return "Movement{" +
                "name='" + name + '\'' +
                '}';
    }
}
