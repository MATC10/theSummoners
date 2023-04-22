package org.thesummoners.model.pokemon;

public class Charmander extends Pokemon {
    public Charmander (String name, int level) {
        super(name, level);
        this.setImage("doc/images/Charmander.png");
        this.setImageBack("doc/images/spritesback/3a-b__004__xy.gif");
    }
}