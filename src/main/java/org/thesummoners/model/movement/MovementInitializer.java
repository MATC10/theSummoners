package org.thesummoners.model.movement;

import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovementInitializer {
    public static HashMap<Integer, Movement> movementsIntoList() {
        AttackMovement trueno = new AttackMovement("Trueno", 110, Type.ELECTRIC);
        AttackMovement rayoSolar = new AttackMovement("Rayo Solar", 120, Type.PLANT);
        AttackMovement hidrobomba = new AttackMovement("Hidrobomba", 110, Type.WATER);
        AttackMovement lanzallamas = new AttackMovement("Lanzallamas", 95, Type.FIRE);
        AttackMovement aguijonLetal = new AttackMovement("Aguijón Letal", 50, Type.BUG);
        AttackMovement colaDragon = new AttackMovement("Cola Dragón", 60, Type.DRAGON);
        AttackMovement impresionar = new AttackMovement("Impresionar", 30, Type.GHOST);
        AttackMovement chuzos = new AttackMovement("Chuzos", 85, Type.ICE);
        AttackMovement fuerzaBruta = new AttackMovement("Fuerza bruta", 120, Type.FIGHTING);
        AttackMovement lanzarrocas = new AttackMovement("Lanzarrocas", 50, Type.ROCK);
        Pokemon.movementLevel.put(4,trueno);
        Pokemon.movementLevel.put(46,rayoSolar);
        Pokemon.movementLevel.put(82,hidrobomba);
        Pokemon.movementLevel.put(61,lanzallamas);
        Pokemon.movementLevel.put(16,aguijonLetal);
        Pokemon.movementLevel.put(58,colaDragon);
        Pokemon.movementLevel.put(22,impresionar);
        Pokemon.movementLevel.put(76,chuzos);
        Pokemon.movementLevel.put(37,fuerzaBruta);
        Pokemon.movementLevel.put(91,lanzarrocas);


        ImproveMovement colaFerrea = new ImproveMovement("Cola Férrea", 0, 40,0,0);
        ImproveMovement danzaDragon = new ImproveMovement("Danza dragón", 40, 0,0, 0);
        ImproveMovement barrera = new ImproveMovement("Barrera", 0, 0,40, 0);
        ImproveMovement amnesia = new ImproveMovement("Amnesia", 40, 0,0, 40);
        ImproveMovement danzaEspada = new ImproveMovement("Danza espada", 40, 0 ,0,0);
        ImproveMovement proteccion = new ImproveMovement("Protección", 0, 0,0, 0);
        ImproveMovement acupresion = new ImproveMovement("Acupresión", 0, 0,40, 0);
        ImproveMovement motivacion = new ImproveMovement("Motivación", 40, 40,0, 40);
        ImproveMovement refuerzo = new ImproveMovement("Refuerzo", 0, 0,0,0);
        ImproveMovement nieblaAromatica = new ImproveMovement("Niebla aromática", 40, 0,0, 0);
        Pokemon.movementLevel.put(64,colaFerrea);
        Pokemon.movementLevel.put(28,danzaDragon);
        Pokemon.movementLevel.put(40,amnesia);
        Pokemon.movementLevel.put(88,danzaEspada);
        Pokemon.movementLevel.put(7,proteccion);
        Pokemon.movementLevel.put(49,barrera);
        Pokemon.movementLevel.put(67,acupresion);
        Pokemon.movementLevel.put(55,motivacion);
        Pokemon.movementLevel.put(19,refuerzo);
        Pokemon.movementLevel.put(13,nieblaAromatica);


        StateMovement hipnosis = new StateMovement("Hipnosis", State.ASLEEP);
        StateMovement rayoConfuso = new StateMovement("Rayo Confuso", State.PARALYSED);
        StateMovement toxico = new StateMovement("Tóxico", State.POISONED);
        StateMovement ascuas = new StateMovement("Ascuas", State.BURNED);
        StateMovement hiloVenenoso = new StateMovement("Hilo venenoso", State.POISONED);
        StateMovement rayoHielo = new StateMovement("Rayo Hielo", State.FROZEN);
        StateMovement cantoMortal = new StateMovement("Canto mortal", State.DEBILITATED);
        StateMovement polucion = new StateMovement("Polución", State.BURNED);
        StateMovement infierno = new StateMovement("Infierno", State.BURNED);
        StateMovement ventisca = new StateMovement("Ventisca", State.FROZEN);
        Pokemon.movementLevel.put(34,hipnosis);
        Pokemon.movementLevel.put(52,rayoConfuso);
        Pokemon.movementLevel.put(70,toxico);
        Pokemon.movementLevel.put(73,ascuas);
        Pokemon.movementLevel.put(25,hiloVenenoso);
        Pokemon.movementLevel.put(79,rayoHielo);
        Pokemon.movementLevel.put(10,cantoMortal);
        Pokemon.movementLevel.put(85,polucion);
        Pokemon.movementLevel.put(43,infierno);
        Pokemon.movementLevel.put(31,ventisca);


        return Pokemon.movementLevel;
    }

    public static List<Object> movementListFull() {
        return null;
    }

    public static List<Object> movementLevelIntoHash() {
        return null;
    }
}
