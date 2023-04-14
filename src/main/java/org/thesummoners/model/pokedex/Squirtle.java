package org.thesummoners.model.pokedex;

import org.thesummoners.model.Pokemon;

public class Squirtle extends Pokemon {
    public Squirtle (String name, int level) {
        super(name, level);
        this.setImage("doc/images/Squirtle.png");
        this.setImageBack("doc/images/spritesback/3a-b__007__xy.gif");
    }
}