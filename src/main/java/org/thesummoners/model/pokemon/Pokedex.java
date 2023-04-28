package org.thesummoners.model.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Pokedex {
    private static ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();
    static private HashMap<Type, List<Type>> strong;
    static private HashMap<Type, List<Type>> weak;

    //TIPOS FUERTES CONTRA OTROS


    public static ObservableList<Pokemon> getPokedex() {
        return pokedex;
    }

    public static void setPokedex(ObservableList<Pokemon> pokedex) {
        Pokedex.pokedex = pokedex;
    }

    public static HashMap<Type, List<Type>> getStrong() {
        if(strong == null){
            strong.put(Type.NORMAL, Arrays.asList(Type.NULL));
            strong.put(Type.FIRE, Arrays.asList(Type.GRASS, Type.ICE, Type.BUG));
            strong.put(Type.WATER, Arrays.asList(Type.FIRE, Type.GROUND, Type.ROCK));
            strong.put(Type.ELECTRIC, Arrays.asList(Type.WATER, Type.FLYING));
            strong.put(Type.GRASS, Arrays.asList(Type.WATER, Type.GROUND, Type.ROCK));
            strong.put(Type.ICE, Arrays.asList(Type.GRASS, Type.GROUND, Type.FLYING, Type.DRAGON));
            strong.put(Type.FIGHTING, Arrays.asList(Type.NORMAL, Type.ICE, Type.ROCK));
            strong.put(Type.POISON, Arrays.asList(Type.GRASS));
            strong.put(Type.GROUND, Arrays.asList(Type.FIRE, Type.ELECTRIC, Type.POISON, Type.ROCK));
            strong.put(Type.FLYING, Arrays.asList(Type.GRASS, Type.FIGHTING, Type.BUG));
            strong.put(Type.PSYCHIC, Arrays.asList(Type.FIGHTING, Type.POISON));
            strong.put(Type.BUG, Arrays.asList(Type.GRASS, Type.PSYCHIC));
            strong.put(Type.ROCK, Arrays.asList(Type.FIRE, Type.ICE, Type.FLYING, Type.BUG));
            strong.put(Type.GHOST, Arrays.asList(Type.PSYCHIC, Type.GHOST));
            strong.put(Type.DRAGON, Arrays.asList(Type.DRAGON));
        }

        return strong;
    }

    public void setStrong(HashMap<Type, List<Type>> strong) {
        this.strong = strong;
    }

    public static HashMap<Type, List<Type>> getWeak() {
        if(weak == null){
            weak.put(Type.NORMAL, Arrays.asList(Type.ROCK));
            weak.put(Type.FIRE, Arrays.asList(Type.WATER, Type.DRAGON, Type.FIRE));
            weak.put(Type.WATER, Arrays.asList(Type.WATER, Type.DRAGON, Type.GRASS));
            weak.put(Type.ELECTRIC, Arrays.asList(Type.DRAGON, Type.ELECTRIC, Type.GRASS));
            weak.put(Type.GRASS, Arrays.asList(Type.BUG, Type.DRAGON, Type.FIRE, Type.GRASS, Type.POISON, Type.FLYING));
            weak.put(Type.ICE, Arrays.asList(Type.WATER, Type.ICE));
            weak.put(Type.FIGHTING, Arrays.asList(Type.BUG, Type.PSYCHIC, Type.POISON, Type.FLYING));
            weak.put(Type.POISON, Arrays.asList(Type.GHOST, Type.ROCK, Type.GROUND, Type.POISON));
            weak.put(Type.GROUND, Arrays.asList(Type.GRASS, Type.BUG));
            weak.put(Type.FLYING, Arrays.asList(Type.ROCK, Type.ELECTRIC));
            weak.put(Type.PSYCHIC, Arrays.asList(Type.PSYCHIC));
            weak.put(Type.BUG, Arrays.asList(Type.GHOST, Type.FIRE, Type.FIGHTING, Type.FLYING));
            weak.put(Type.ROCK, Arrays.asList(Type.FIGHTING, Type.GROUND));
            weak.put(Type.GHOST, Arrays.asList(Type.NULL));
            weak.put(Type.DRAGON, Arrays.asList(Type.NULL));
        }
        return weak;

    }

    public static void setWeak(HashMap<Type, List<Type>> weak) {
        Pokedex.weak = weak;
    }



    public static float compareAdvantage (Pokemon pokemonTrainer, Pokemon pokemonEnemy){
        //SI ALGUNO DE LOS TIPOS DEL POKEMON ES FUERTE CONTRA ALGUNO DE LOS 2 TIPOS DEL OTRO ATACA X2
        if(strong.get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType1()) ||
                strong.get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType2()) ||
                strong.get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType1()) ||
                strong.get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType2())
        )
            return 2.0f;
        //SI ALGUNO DE LOS TIPOS DEL POKEMON ES DEBIL CONTRA ALGUNO DE LOS 2 TIPOS DEL OTRO ATACA X0.5
        if(weak.get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType1()) ||
                weak.get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType2()) ||
                weak.get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType1()) ||
                weak.get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType2())
        )
            return 0.5f;
        //SI NO SUCEDE NADA DE LO ANTERIOR ATACA X1
        return 1;
    }

}
