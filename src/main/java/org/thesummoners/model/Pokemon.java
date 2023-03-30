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
    private int experience;

    //Metemos en el HashMap el nivel en el que el pokemon aprend un ataque, y el ataque.
    //cuando un pokemon suba a X nivel aprender Y movimiento.
    private HashMap <Integer, Movement> movementLevel;
    //METER AQUÍ ATRIBUTO MOVIMIENTOS?

    private Movement [] learnedMovement;
    private Objeto objeto;

    public Pokemon (String name){
        this.name = name;
        this.learnedMovement = new Movement [4];

        AttackMovement placaje = new AttackMovement("Placaje", 10, Type.NORMAL);
        this.learnedMovement[0] = placaje;
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

    public void setExperience(int experience) {
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public Movement[] getLearnedMovement() {
        return learnedMovement;
    }

    public Movement getLearnedMovement1(){
        return this.learnedMovement[0];
    }

    public Movement getLearnedMovement2(){
        return this.learnedMovement[1];
    }

    public Movement getLearnedMovement3(){
        return this.learnedMovement[2];
    }

    public Movement getLearnedMovement4(){
        return this.learnedMovement[3];
    }

    public void setLearnedMovement(Movement[] learnedMovement) {
        this.learnedMovement = learnedMovement;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public void assignMovement1(Movement movement1){
        this.learnedMovement[0] = movement1;
    }

    public void assignMovement2(Movement movement2){
        this.learnedMovement[1] =  movement2;
    }

    public void assignMovement3(Movement movement3){
        this.learnedMovement[2] =  movement3;
    }

    public void assignMovement4(Movement movement4){
        this.learnedMovement[3] =  movement4;
    }

    //parametro: seleccionamos nombre viejo de movimiento,
    //y nombre nuevo

    public void assignNewMovement(String oldMove){

        AttackMovement ataque1 = new AttackMovement("Placaje", 5, Type.NORMAL);
        movementLevel.put(5, ataque1);

        if(this.movementLevel.containsKey(this.level)){

                    movementLevel.get(this.level);
        }


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return idPokemon == pokemon.idPokemon && idPokedex == pokemon.idPokedex && hp == pokemon.hp && level == pokemon.level && fertility == pokemon.fertility && attackPower == pokemon.attackPower && specialAttack == pokemon.specialAttack && defense == pokemon.defense && specialDefense == pokemon.specialDefense && speed == pokemon.speed && stamina == pokemon.stamina && Objects.equals(name, pokemon.name) && Objects.equals(nickName, pokemon.nickName) && type1 == pokemon.type1 && type2 == pokemon.type2 && state == pokemon.state && sex == pokemon.sex && Objects.equals(movementLevel, pokemon.movementLevel) && Arrays.equals(learnedMovement, pokemon.learnedMovement) && Objects.equals(objeto, pokemon.objeto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idPokemon, idPokedex, name, nickName, hp, level, fertility, attackPower, specialAttack, defense, specialDefense, speed, stamina, type1, type2, state, sex, objeto);
        result = 31 * result + Arrays.hashCode(learnedMovement);
        return result;
    }


}
