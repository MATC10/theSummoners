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
