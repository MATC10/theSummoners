package org.thesummoners.model.movements;

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

    @Override
    public String toString() {
        return "Movement{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                '}';
    }
}
