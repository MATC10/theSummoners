package org.thesummoners.model.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.thesummoners.model.movement.AttackMovement;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.objeto.Objeto;



import java.util.*;

public class Pokemon implements Cloneable {
    //LISTA CON TODOS LOS POKEMON DEL JUEGO ¿private o public?

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
    private int attackPower;
    private int fertility;
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
    public static HashMap <Integer, Movement> movementLevel;

    private Movement [] learnedMovement;

    public static List <Movement> movementList = new ArrayList<>();

    //EL OBJETO PODRÍA SER UNA ARRAY DE UN HUECO
    private Objeto objeto;


    public Pokemon(String name, int idPokedex, String image, String imageBack, int hp, int level, int attackPower, int specialAttack, int defense, int specialDefense, int speed, int stamina, Type type1, Type type2, State state, Sex sex, int experience) {
        this.name = name;
        this.idPokedex = idPokedex;
        this.image = image;
        this.imageBack = imageBack;
        this.hp = hp;
        this.level = level;
        this.attackPower = attackPower;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.stamina = stamina;
        this.type1 = type1;
        this.type2 = type2;
        this.state = state;
        this.sex = sex;
        this.fertility = 5;
        this.experience = experience;
        this.learnedMovement = new Movement [4];
        AttackMovement placaje = new AttackMovement("Placaje", 10, Type.NORMAL);
        //TODOS LOS POKEMON EMPIEZAN CON ATAQUE PLACAJE.
        this.learnedMovement[0] = placaje;

        this.objeto = objeto;
        counterPokemon ++;
        this.idPokemon = counterPokemon;
        changeDisplayName();
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

    public int getFertility() {
        return fertility;
    }

    public void setFertility(int fertility) {
        this.fertility = fertility;
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
        //INCLUÍDO UN MÉTODO PARA QUE NO SE PUEDA BAJAR DE 0 DE VIDA
        this.hp = hp;
        minimumHp ();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws CloneNotSupportedException {
        this.level = level;
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

    public void setObjetoImproveStats (Objeto objeto) throws CloneNotSupportedException {
        //AL ASIGNAR UN OBJETO RECIBES LAS MEJORAS CORRESPONDIENTES AUTOMÁTICAMENTE
        //SI ASIGNAS NULL AL OBJETO (QUITAS EL OBJETO) SE PONEN LAS ESTADÍSTICAS BASE

        if(objeto == null) {
            this.setObjeto(null);
        }
        else this.setObjeto(objeto);

        this.adaptStatsToLevel(this.getLevel(), this);
    }

    public void assignMovement(int i){
        //QUIERO QUE MEDIANTE ESTE MÉTODO EL POKÉMON APRENDA EL ATAQUE CUANDO LLEGUE A X NIVEL
        //PARA ELLO USARÉ EL HASHMAP DE movementLevel PARA QUE SALTE LA VENTA Y EL MOVIMIENTO QUE APRENDE
        //POR LO TANTO NO SERÁ NECE

        this.learnedMovement[i] = movementLevel.get(this.level);
    }


    public void rest(){
        this.stamina += 100;
        //A LA HORA DE PELEAR TIENE QUE HABER UN TURNO QUE NO PELEE TRAS DORMIR
    }

    public void levelUp(int experience) throws CloneNotSupportedException {
        //LOS COMBATES DAN EXP A LOS POKEMON
        if(this.level < 100){
            this.experience += experience;
            if(this.experience >= 100){
                this.level += 1;
                this.experience -= 100;
                adaptStatsToLevel(this.level, this);
            }
        }
    }

    public void train(){
        //PENDIENDE DE COMPLETAR
    }




    public void adaptStatsToLevel(int level, Pokemon pokemon) throws CloneNotSupportedException {
        //ESTE MÉTODO CAMBIA LAS ESTADÍSTICAS DEL POKÉMON SEGÚN SU NIVEL
        //TODO: EN COMBATE USAMOS EL MÉTODO levelUp() PARA DAR EXPERIENCIA Y QUE LO HAGA TODO SOLO
        if(level <= 100 && level > 0) {


            Pokemon newPokemon = null;

            for (Pokemon p : Pokedex.getPokedex()) {
                if (pokemon.getName().equals(p.getName())) {
                    newPokemon = p.clone();
                }
            }

            //SI TIENE OBJETO SE LO QUITAMOS PARA CALCULAR LAS ESTADÍSITCAS
            boolean equippedPokemon = false;

            if (pokemon.getObjeto() != null) {
                equippedPokemon = true;
            }

            //ESTE MÉTODO ADAPTA LA ESTADÍSTICA DEL POKÉMON A SU NIVEL,
            //A TODOS LOS POKÉMON CON MÁS DE LEVEL 1
            if (level > 1) {
                pokemon.setHp(newPokemon.getHp() + (level * 20));
                pokemon.setAttackPower(newPokemon.getAttackPower() + (level / 5));
                pokemon.setSpecialAttack(newPokemon.getSpecialAttack() + (level / 5));
                pokemon.setSpecialAttack(newPokemon.getDefense() + (level / 5));
                pokemon.setSpecialDefense(newPokemon.getSpecialDefense() + (level / 5));
                pokemon.setSpeed(newPokemon.getSpeed() + (level / 5));
                pokemon.setStamina(newPokemon.getStamina() + (level / 5));
            }
            else if (level <= 1) {
                pokemon.setHp(newPokemon.getHp());
                pokemon.setAttackPower(newPokemon.getAttackPower());
                pokemon.setSpecialAttack(newPokemon.getSpecialAttack());
                pokemon.setSpecialAttack(newPokemon.getDefense());
                pokemon.setSpecialDefense(newPokemon.getSpecialDefense());
                pokemon.setSpeed(newPokemon.getSpeed());
                pokemon.setStamina(newPokemon.getStamina());
            }


            //SI TENÍA OBJETO SE LO DEVOLVEMOS Y RECALCULA LAS ESTADÍSTICAS
            if (equippedPokemon) {
                pokemon.statisticsWithObjeto(this, pokemon.getObjeto());
            }

            pokemon.setLevel(level);
        }
    }

    public void changeDisplayName(){
        //EL displayName ES EL NOMBRE DEL POKEMON QUE SE MOSTRARÁ EN TODOS LOS SITIOS
        if(this.nickName != null){
            this.displayName = this.nickName;
        }
        else this.displayName = this.name;
    }

    public boolean statisticsWithObjeto(Pokemon pokemon, Objeto objeto){
        //SEGÚN EL OBJETO EQUIPADO, EL POKÉMON TENDRÁ DETERMINADAS ESTADÍSTICAS
        //SE DEBE HACER OTRO MÉTODO PARA RECUPERAR SUS STATS BASE AL QUITAR EL OBJETO
        if(objeto.getName().equals("pesa")){
            pokemon.setAttackPower((int) (pokemon.getAttackPower() * objeto.getAttack()));
            pokemon.setDefense((int) (pokemon.getDefense() * objeto.getDefense()));
            pokemon.setSpeed((int) (pokemon.getSpeed() * objeto.getSpeed()));
            return true;
        }
        else if (objeto.getName().equals("pluma")){
            pokemon.setSpeed((int) (pokemon.getSpeed() * objeto.getSpeed()));
            pokemon.setDefense((int) (pokemon.getDefense() * objeto.getDefense()));
            pokemon.setSpecialDefense((int) (pokemon.getSpecialDefense() * objeto.getSpecialDefense()));
            return true;
        }
        else if(objeto.getName().equals("chaleco")){
            pokemon.setDefense((int) (pokemon.getDefense() * objeto.getDefense()));
            pokemon.setSpecialDefense((int) (pokemon.getSpecialDefense() * objeto.getSpecialDefense()));
            pokemon.setSpeed((int) (pokemon.getSpeed() * objeto.getSpeed()));
            pokemon.setAttackPower((int) (pokemon.getAttackPower() * objeto.getAttack()));
            return true;
        }
        else if(objeto.getName().equals("baston")){
            pokemon.setStamina((int) (pokemon.getStamina() * objeto.getStamina()));
            pokemon.setSpeed((int) (pokemon.getSpeed() * objeto.getSpeed()));
            return true;
        }
        else if(objeto.getName().equals("pilas")){
            pokemon.setStamina((int) (pokemon.getStamina() * objeto.getStamina()));
            pokemon.setSpecialDefense((int) (pokemon.getSpecialDefense() * objeto.getSpecialDefense()));
            return true;
        }
        return false;
    }


    public void minimumHp (){
        //MÉTODO PARA NO BAJAR DE 0 DE VIDA, INCLUIDO EN setHp();
        if(this.hp <= 0){
            this.hp = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return idPokemon == pokemon.idPokemon && idPokedex == pokemon.idPokedex && hp == pokemon.hp && level == pokemon.level && attackPower == pokemon.attackPower && specialAttack == pokemon.specialAttack && defense == pokemon.defense && specialDefense == pokemon.specialDefense && speed == pokemon.speed && stamina == pokemon.stamina && experience == pokemon.experience && Objects.equals(name, pokemon.name) && Objects.equals(nickName, pokemon.nickName) && Objects.equals(displayName, pokemon.displayName) && Objects.equals(image, pokemon.image) && Objects.equals(imageBack, pokemon.imageBack) && type1 == pokemon.type1 && type2 == pokemon.type2 && state == pokemon.state && sex == pokemon.sex && Arrays.equals(learnedMovement, pokemon.learnedMovement) && Objects.equals(objeto, pokemon.objeto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idPokemon, idPokedex, name, nickName, displayName, image, imageBack, hp, level, attackPower, specialAttack, defense, specialDefense, speed, stamina, type1, type2, state, sex, experience, objeto);
        result = 31 * result + Arrays.hashCode(learnedMovement);
        return result;
    }

    @Override
    public String toString() {
        return displayName + " nivel: " + level;
    }




    @Override
    public Pokemon clone() throws CloneNotSupportedException {
        //CLONAR POKEMON
        Pokemon clonedPokemon = (Pokemon) super.clone();
        clonedPokemon.learnedMovement = learnedMovement.clone();
        clonedPokemon.objeto = objeto;

        return clonedPokemon;
    }
}


