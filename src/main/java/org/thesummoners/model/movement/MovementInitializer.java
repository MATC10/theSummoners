package org.thesummoners.model.movement;

import org.thesummoners.model.State;
import org.thesummoners.model.pokemon.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovementInitializer {
    public static HashMap<String , Movement> movementHashMap = new HashMap<>();
    public static HashMap <String,Movement> movementsIntoList() {
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
        movementHashMap.put("Ataque",trueno);
        movementHashMap.put("Ataque",rayoSolar);
        movementHashMap.put("Ataque",hidrobomba);
        movementHashMap.put("Ataque",lanzallamas);
        movementHashMap.put("Ataque",aguijonLetal);
        movementHashMap.put("Ataque",colaDragon);
        movementHashMap.put("Ataque",impresionar);
        movementHashMap.put("Ataque",chuzos);
        movementHashMap.put("Ataque",fuerzaBruta);
        movementHashMap.put("Ataque",lanzarrocas);


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
        movementHashMap.put("Mejora",colaFerrea);
        movementHashMap.put("Mejora",danzaDragon);
        movementHashMap.put("Mejora",amnesia);
        movementHashMap.put("Mejora",danzaEspada);
        movementHashMap.put("Mejora",proteccion);
        movementHashMap.put("Mejora",barrera);
        movementHashMap.put("Mejora",acupresion);
        movementHashMap.put("Mejora",motivacion);
        movementHashMap.put("Mejora",refuerzo);
        movementHashMap.put("Mejora",nieblaAromatica);

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
        movementHashMap.put("Estado",hipnosis);
        movementHashMap.put("Estado",rayoConfuso);
        movementHashMap.put("Estado",toxico);
        movementHashMap.put("Estado",ascuas);
        movementHashMap.put("Estado",hiloVenenoso);
        movementHashMap.put("Estado",rayoHielo);
        movementHashMap.put("Estado",cantoMortal);
        movementHashMap.put("Estado",polucion);
        movementHashMap.put("Estado",infierno);
        movementHashMap.put("Estado",ventisca);


        return movementHashMap;
    }

}
