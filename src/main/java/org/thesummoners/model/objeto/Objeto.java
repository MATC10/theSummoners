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

    public static ObservableList<Objeto> getObjetoList() {
        return objetoList;
    }

    public static void setObjetoList(ObservableList<Objeto> objetoList) {
        Objeto.objetoList = objetoList;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(float specialAttack) {
        this.specialAttack = specialAttack;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(float specialDefense) {
        this.specialDefense = specialDefense;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public void selectObjeto(String nombre) {
        switch (nombre) {
            case "pesa":
                this.attack = 1.2f;
                this.defense = 1.2f;
                this.speed = 0.8f;
                break;
            case "pluma":
                this.speed = 1.3f;
                this.defense = 0.8f;
                this.specialDefense = 0.8f;
                break;
            case "chaleco":
                this.defense = 1.2f;
                this.specialDefense = 1.2f;
                this.speed = 0.85f;
                this.attack = 0.85f;
                break;
            case "baston":
                this.stamina = 1.2f;
                this.speed = 0.85f;
                break;
            case "pilas":
                this.stamina = 1.5f;
                this.specialDefense = 0.7f;
                break;
        }
    }

    public String toString() {
        return this.name;
    }
}