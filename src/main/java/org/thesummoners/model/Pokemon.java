package org.thesummoners.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Pokemon {
    static int counterPokemon;
    private int idPokemon;
    private int idPokedex;
    private String name;
    private String nickName;
    private int hp;
    private int level;
    private int fertility;
    private int attackPower;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;
    private int stamina;
    private Type type1;
    private Type type2;
    private State state;
    private Sex sex;
    //Metemos en el HashMap el nivel en el que el pokemon aprend un ataque, y el ataque.
    //cuando un pokemon suba a X nivel aprender Y movimiento.
    private HashMap <Integer, Movement> movementLevel;
    //METER AQUÍ ATRIBUTO MOVIMIENTOS?
    //AQUÍ PONER EN EN CONSTRUCTOR QUE SON 4
    private String[] learnedMovement;
    private Objeto objeto;

    //parametro: seleccionamos nombre viejo de movimiento,
    //y nombre nuevo

    public void assignNewMovement(String oldMove){
        learnedMovement = new String[4];
        movementLevel.put(5, movimiento);
        if(this.)
        for(int i = 0; i < learnedMovement.length; i++){
            if(learnedMovement[i].name.equals(oldMove)){
                learnedMovement[i] = newMove;
            }
        }
        for(String a : learnedMovement){
            if (a.equals(oldMove)){
            }
        }
    }

    public static int getCounterPokemon() {
        return counterPokemon;
    }

    public static void setCounterPokemon(int counterPokemon) {
        Pokemon.counterPokemon = counterPokemon;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public int getIdPokedex() {
        return idPokedex;
    }

    public void setIdPokedex(int idPokedex) {
        this.idPokedex = idPokedex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFertility() {
        return fertility;
    }

    public void setFertility(int fertility) {
        this.fertility = fertility;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public HashMap<Integer, Movement> getMovementLevel() {
        return movementLevel;
    }

    public void setMovementLevel(HashMap<Integer, Movement> movementLevel) {
        this.movementLevel = movementLevel;
    }

    public String[] getLearnedMovement() {
        return learnedMovement;
    }

    public void setLearnedMovement(String[] learnedMovement) {
        this.learnedMovement = learnedMovement;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return idPokemon == pokemon.idPokemon && idPokedex == pokemon.idPokedex && hp == pokemon.hp && level == pokemon.level && fertility == pokemon.fertility && attackPower == pokemon.attackPower && specialAttack == pokemon.specialAttack && defense == pokemon.defense && specialDefense == pokemon.specialDefense && speed == pokemon.speed && stamina == pokemon.stamina && Objects.equals(name, pokemon.name) && Objects.equals(nickName, pokemon.nickName) && type1 == pokemon.type1 && type2 == pokemon.type2 && state == pokemon.state && sex == pokemon.sex && Arrays.equals(learnedMovement, pokemon.learnedMovement) && Objects.equals(objeto, pokemon.objeto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idPokemon, idPokedex, name, nickName, hp, level, fertility, attackPower, specialAttack, defense, specialDefense, speed, stamina, type1, type2, state, sex, objeto);
        result = 31 * result + Arrays.hashCode(learnedMovement);
        return result;
    }

}
