package org.thesummoners.model.pokedex;


import org.thesummoners.model.Pokemon;

//ES POSIBLE QUE HAYA QUE UTILIZAR UN IMPLEMENT EVOLUCIONABLE CON LOS PKMN QUE EVOLUCIONEN
public class Bulbasaur extends Pokemon {

    //constructor de prueba
    public Bulbasaur(String name, int level, String image) {
        super(name, level);
        this.setImage("doc/images/Bulbasaur.png");
        this.setImageBack("doc/images/spritesback/3a-b__001__xy.gif");

    }



}
