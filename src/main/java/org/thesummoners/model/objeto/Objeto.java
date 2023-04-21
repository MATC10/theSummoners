package org.thesummoners.model.objeto;

public abstract class Objeto {
    /*
    TIPOS DE OBJETOS:
    1: PESO
    2: PLUMA
    3: CHALECO
    4: BASTON
    5: PILAS
     */

    private static int counter = 0;
    private int idObjeto;
    private String name;
    private float attack;
    private float specialAttack;
    private float defense;
    private float specialDefense;
    private float speed;
    private float stamina;

    public Objeto(String name) {
        this.name = name;
        this.counter++;
        this.idObjeto = counter;
        selectObjeto(name);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Objeto.counter = counter;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void pesa() {
        //Aumenta el ataque y la defensa un 20%, disminuye la velocidad
        //un 20%
        this.attack = 1.20f;
        this.defense = 1.20f;
        this.speed *= 0.80f;
    }

    public void pluma() {
        //Aumenta la velocidad un 30%, disminuye la defensa y defensa
        //especial un 20%
        this.speed = 1.30f;
        this.defense = 0.80f;
        this.specialDefense = 0.80f;
    }

    public void chaleco() {
        //Aumenta la defensa y la defensa especial un 20%,
        //disminuye la velocidad y el ataque un 15%
        this.defense = 1.20f;
        this.specialDefense = 1.20f;
        this.speed = 0.85f;
        this.attack = 0.85f;
    }

    public void baston() {
        //Aumenta la estamina un 20%, disminuye la velocidad 15%
        this.stamina = 1.20f;
        this.speed = 0.85f;
    }

    public void pilas() {
        //Aumenta la recuperación de estamina 50%, disminuye la
        //defensa especial un 30%
        this.stamina = 1.50f;
        this.specialDefense = 0.70f;
    }


    public void selectObjeto(String nombre) {
        switch (nombre) {
            case "pesa":
                pesa();
            case "pluma":
                pluma();
            case "chaleco":
                chaleco();
            case "baston":
                baston();
            case "pilas":
                pilas();
        }
    }
}
