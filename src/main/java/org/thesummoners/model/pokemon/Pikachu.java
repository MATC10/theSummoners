package org.thesummoners.model.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu (String name, int level) {
        super(name, level);
        this.setImage("doc/images/Pikachu.png");
        this.setImageBack("doc/images/spritesback/3a-b__025__xy.gif");
    }
}