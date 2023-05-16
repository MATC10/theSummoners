package org.thesummoners.model.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.thesummoners.model.movement.AttackMovement;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.trainer.Trainer;

import java.util.*;

public class Pokemon implements Cloneable{
    //LISTA CON TODOS LOS POKEMON DEL JUEGO ¿private o public?
    public static ObservableList <Pokemon> pokedex = FXCollections.observableArrayList();
    static int counterPokemon = 0;
    private int idPokemon;
    private int idPokedex;
    private String name;
    private String nickName;
    private String displayName;
    private String image;
    private String imageBack;
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
    private Objeto objetoEquipado;
    private Objeto equiparObjeto;
    private Object desequiparObjeto;
    private int health;
    private Object item;

    //Metemos en el HashMap el nivel en el que el pokemon aprend un ataque, y el ataque.
    //cuando un pokemon suba a X nivel aprender Y movimiento.
    public static HashMap <Integer, Movement> movementLevel;

    private Movement [] learnedMovement;

    //EL OBJETO PODRÍA SER UNA ARRAY DE UN HUECO
    private Objeto objeto;
    private Pokemon[] enemyTeam;


    public Pokemon (String name, int level){
        counterPokemon ++;
        this.name = name;
        this.level = level;
        this.learnedMovement = new Movement [4];
        this.idPokemon = counterPokemon;

        //TODOS LOS POKEMON EMPIEZAN CON ATAQUE PLACAJE.
        AttackMovement placaje = new AttackMovement("Placaje", 10, Type.NORMAL);
        this.learnedMovement[0] = placaje;
        AttackMovement pistolaAgua = new AttackMovement ("Pistola Agua", 9,  Type.NORMAL);
        AttackMovement hidroBomba = new AttackMovement ("Hidro Bomba", 2, Type.PSYCHIC);
        AttackMovement salpicadura = new AttackMovement ("Salpicadura", 1, Type.WATER);

        //ESTO ES UNA PRUEBA PARA METERLE NIVELES Y MOVIMIENTOS QUE APRENDE EL POKEMON
        HashMap <Integer, Movement> movementLevel = new HashMap<Integer, Movement>(){{put(5, pistolaAgua);
            put(10,hidroBomba); put(15, salpicadura);}};

        this.movementLevel = movementLevel;
        //adaptStatsToLevel(level, this.enemyTeam[i]);
        changeDisplayName();
    }

    public Pokemon() {
    }

    public Pokemon(String name, int idPokedex, String image, String imageBack, int hp, int level, int attackPower, int specialAttack, int defense, int specialDefense, int speed, int stamina, Type type, Type type1, State state, Sex sex, int experience) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ObservableList<Pokemon> getPokedex() {
        return pokedex;
    }

    public static void setPokedex(ObservableList<Pokemon> pokedex) {
        Pokemon.pokedex = pokedex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        //TENEMOS QUE RESTRINGIR LOS NICKNAMES A NOMBRES APROPIADOS

        this.nickName = nickName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
        int i = 0;
        adaptStatsToLevel(level, this.enemyTeam[i]);
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

    public String getImageBack() {
        return imageBack;
    }

    public void setImageBack(String imageBack) {
        this.imageBack = imageBack;
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

    public Movement LearnedMovement(int i){

        return this.learnedMovement[i];
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

    public void assignMovement(int i){
        //QUIERO QUE MEDIANTE ESTE MÉTODO EL POKÉMON APRENDA EL ATAQUE CUANDO LLEGUE A X NIVEL
        //PARA ELLO USARÉ EL HASHMAP DE movementLevel PARA QUE SALTE LA VENTA Y EL MOVIMIENTO QUE APRENDE
        //POR LO TANTO NO SERÁ NECE

        this.learnedMovement[i] = movementLevel.get(this.level);
    }


    public void rest(){
        this.stamina += 50;
        //A LA HORA DE PELEAR TIENE QUE HABER UN TURNO QUE NO PELEE TRAS DORMIR
    }

    public void levelUp(int experience){
        //LOS COMBATES DAN EXP A LOS POKEMON
        if(this.level < 100){
            this.experience += experience;
            if(this.experience >= 100){
                this.level += 1;
                this.experience -= 100;
                //adaptStatsToLevel(this.level, this.enemyTeam[i]);
            }
        }
    }

    public void train(){
        //PENDIENDE DE COMPLETAR
    }
    public void equiparObjeto(Objeto objeto){
        this.objetoEquipado = objeto;
    }
    public void desequiparObjeto(){
        this.desequiparObjeto = null;
    }

    public Objeto getObjetoEquipado(Objeto objeto) {
        return objetoEquipado;
    }

    public void adaptStatsToLevel(int level, Pokemon pokemon){
        //ESTE MÉTODO ADAPTA LA ESTADÍSTICA DEL POKÉMON A SU NIVEL,
        //A TODOS LOS POKÉMON CON MÁS DE LEVEL 1
        if(this.level > 1){
            this.hp += level;
            this.attackPower += level/10;
            this.specialAttack += level/10;
            this.defense += level/10;
            this.specialDefense += level/10;
            this.speed += level/10;
            this.stamina += level/10;
        }

    }

    public void changeDisplayName(){
        //EL displayName ES EL NOMBRE DEL POKEMON QUE SE MOSTRARÁ EN TODOS LOS SITIOS
        if(this.nickName != null){
            this.displayName = this.nickName;
        }
        else this.displayName = this.name;
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
    
    public Pokemon(String name, int level, int health){
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void setItem(Object item){
        this.item = null;
    }
    public void removeITEM(){
        this.item = null;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Object getItem() {
        return item;
    }

    @Override
    public String toString() {
        return displayName + "Pokemon[name="  +name + ", level=" + level +", health="+ health + ", item=" + item + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setObjetoImproveStats(Object o) {
    }

    public void learnMoveInTrainWindow(Label lblText, Button btnLearnMove, Button btnP1, Button btnP2, Button btnP3, Button btnP4, Button btnP5, Button btnP6, Button btnLevel, Button btnBack) {
    }
}
