package org.thesummoners.model.objeto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Objeto {
    public static ObservableList<Objeto> objetoList = FXCollections.observableArrayList();
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
        ++counter;
        this.idObjeto = counter;
        this.selectObjeto(name);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Objeto.counter = counter;
    }

    public int getIdObjeto() {
        return this.idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pesa() {
        this.attack = 1.2F;
        this.defense = 1.2F;
        this.speed *= 0.8F;
    }

    public void pluma() {
        this.speed = 1.3F;
        this.defense = 0.8F;
        this.specialDefense = 0.8F;
    }

    public void chaleco() {
        this.defense = 1.2F;
        this.specialDefense = 1.2F;
        this.speed = 0.85F;
        this.attack = 0.85F;
    }

    public void baston() {
        this.stamina = 1.2F;
        this.speed = 0.85F;
    }

    public void pilas() {
        this.stamina = 1.5F;
        this.specialDefense = 0.7F;
    }

    public void selectObjeto(String nombre) {
        switch (nombre) {
            case "pesa":
                this.pesa();
            case "pluma":
                this.pluma();
            case "chaleco":
                this.chaleco();
            case "baston":
                this.baston();
            case "pilas":
                this.pilas();
            default:
        }
    }

    public String toString() {
        return this.name;
    }
}