package org.thesummoners.model.pokedex;

import org.thesummoners.model.Pokemon;

public class Ivysaur extends Pokemon {
    public Ivysaur (String name, int level) {
        super(name, level);
        this.setImage("doc/images/Ivysaur.png");
        this.setImageBack("doc/images/spritesback/3a-b__002__xy.gif");
    }
}
