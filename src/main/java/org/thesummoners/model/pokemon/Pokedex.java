package org.thesummoners.model.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Pokedex {
    private static ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();
    static private HashMap<Type, List<Type>> strong;
    static private HashMap<Type, List<Type>> weak;

    //TIPOS FUERTES CONTRA OTROS


    public static ObservableList<Pokemon> getPokedex() throws CloneNotSupportedException {
        pokedex.clear();
        pokedex.add(new Pokemon("Bulbasaur", 1, "doc/images/Bulbasaur.png", "doc/images/spritesback/3a-b__001__xy.gif",145,1, 49,65,49,65,45, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.M, 0, null));
        pokedex.add(new Pokemon("Squirtle", 7, "doc/images/Squirtle.png", "doc/images/spritesback/3a-b__007__xy.gif",144,1, 48,50,65,64,43, 150, Type.WATER, null, State.ALIVE, Sex.F, 0, null));
        pokedex.add(new Pokemon("Charmander", 4, "doc/images/Charmander.png", "doc/images/spritesback/3a-b__004__xy.gif",139,1, 52,60,43,50,65, 150, Type.FIRE, null, State.ALIVE, Sex.F, 0, null));
        pokedex.add(new Pokemon("Pikachu", 25, "doc/images/Pikachu.png", "doc/images/spritesback/3a-b__025__xy.gif",135,1, 55,50,40,50,90, 150, Type.ELECTRIC, null, State.ALIVE, Sex.F, 0, null));
        pokedex.add(new Pokemon("Venusaur", 3, "doc/images/Venusaur.png", "doc/images/spritesback/3a-b__003__xy.gif",180,1, 83,100,83,100,80, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.F, 0, null));
        return pokedex;
    }

    public static void setPokedex(ObservableList<Pokemon> pokedex) {
        Pokedex.pokedex = pokedex;
    }

    public static HashMap<Type, List<Type>> getStrong() {
        strong = new HashMap<>();

        if(strong.get(2) == null){
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
        weak = new HashMap<>();
        if(weak.get(2) == null){
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
        if(Pokedex.getStrong().get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType1()) ||
                Pokedex.getStrong().get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType2()))
            return 2f;

        if( pokemonTrainer.getType2() != null && (Pokedex.getStrong().get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType1()) ||
                Pokedex.getStrong().get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType2())))
            return 2f;

        //SI ALGUNO DE LOS TIPOS DEL POKEMON ES DEBIL CONTRA ALGUNO DE LOS 2 TIPOS DEL OTRO ATACA X0.5
        if(Pokedex.getWeak().get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType1()) ||
                Pokedex.getWeak().get(pokemonTrainer.getType1()).contains(pokemonEnemy.getType2()))
            return 0.5f;
        if( pokemonTrainer.getType2() != null && (Pokedex.getWeak().get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType1()) ||
                Pokedex.getWeak().get(pokemonTrainer.getType2()).contains(pokemonEnemy.getType2())))
            return 0.5f;

        //SI NO SUCEDE NADA DE LO ANTERIOR ATACA X1
        return 1;
    }
}
