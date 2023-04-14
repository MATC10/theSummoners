package org.thesummoners.model.pokedex;

import org.thesummoners.model.Pokemon;

public class Venusaur extends Pokemon {
    public Venusaur (String name, int level) {
        super(name, level);
        this.setImage("doc/images/Venusaur.png");
        this.setImageBack("doc/images/spritesback/3a-b__003__xy.gif");
    }
}
