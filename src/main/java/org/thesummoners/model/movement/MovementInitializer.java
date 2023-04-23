package org.thesummoners.model.movement;

import org.thesummoners.model.State;
import org.thesummoners.model.pokemon.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovementInitializer {
    public static HashMap<Integer , Movement> movementHashMap = new HashMap<>();
    public static HashMap <Integer,Movement> movementsIntoList() {
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
        movementHashMap.put(1,trueno);
        movementHashMap.put(43,rayoSolar);
        movementHashMap.put(79,hidrobomba);
        movementHashMap.put(58,lanzallamas);
        movementHashMap.put(13,aguijonLetal);
        movementHashMap.put(55,colaDragon);
        movementHashMap.put(19,impresionar);
        movementHashMap.put(73,chuzos);
        movementHashMap.put(34,fuerzaBruta);
        movementHashMap.put(88,lanzarrocas);


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
        movementHashMap.put(61,colaFerrea);
        movementHashMap.put(25,danzaDragon);
        movementHashMap.put(37,amnesia);
        movementHashMap.put(85,danzaEspada);
        movementHashMap.put(4,proteccion);
        movementHashMap.put(46,barrera);
        movementHashMap.put(64,acupresion);
        movementHashMap.put(52,motivacion);
        movementHashMap.put(16,refuerzo);
        movementHashMap.put(10,nieblaAromatica);


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
        movementHashMap.put(31,hipnosis);
        movementHashMap.put(49,rayoConfuso);
        movementHashMap.put(67,toxico);
        movementHashMap.put(70,ascuas);
        movementHashMap.put(22,hiloVenenoso);
        movementHashMap.put(76,rayoHielo);
        movementHashMap.put(7,cantoMortal);
        movementHashMap.put(82,polucion);
        movementHashMap.put(40,infierno);
        movementHashMap.put(28,ventisca);


        return movementHashMap;
    }

}
