package org.thesummoners.model.movement;

import org.thesummoners.model.State;
import org.thesummoners.model.pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class MovementInitializer {
    public static List <Movement> movementList = new ArrayList<>();
    public static List <Movement> movementsIntoList() {
        AttackMovement trueno = new AttackMovement("Trueno", 110, Type.ELECTRIC);
        AttackMovement rayoSolar = new AttackMovement("Rayo Solar", 120, Type.PLANT);
        AttackMovement hidrobomba = new AttackMovement("Hidrobomba", 110, Type.WATER);
        AttackMovement lanzallamas = new AttackMovement("Lanzallamas", 95, Type.FIRE);
        movementList.add(trueno);
        movementList.add(rayoSolar);
        movementList.add(hidrobomba);
        movementList.add(lanzallamas);

        ImproveMovement colaFerrea = new ImproveMovement("Cola Férrea", 0, 40,0,0);
        ImproveMovement danzaDragon = new ImproveMovement("Danza dragón", 40, 0,0, 0);
        ImproveMovement barrera = new ImproveMovement("Barrera", 0, 0,40, 0);
        ImproveMovement amnesia = new ImproveMovement("Amnesia", 40, 0,0, 40);
        movementList.add(colaFerrea);
        movementList.add(danzaDragon);
        movementList.add(barrera);
        movementList.add(amnesia);

        StateMovement hipnosis = new StateMovement("Hipnosis", State.SLEEPY);
        StateMovement rayoConfuso = new StateMovement("Rayo Confuso", State.PARALYSED);
        StateMovement toxico = new StateMovement("Tóxico", State.POISONED);
        StateMovement ascuas = new StateMovement("Ascuas", State.BURNED);
        movementList.add(hipnosis);
        movementList.add(rayoConfuso);
        movementList.add(toxico);
        movementList.add(ascuas);


        return movementList;
    }

}
