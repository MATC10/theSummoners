package org.thesummoners.model.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    public void LevelUp() {

        Pokemon pokemon = new Pokemon("", 50);
        pokemon.levelUp(30);
        assertEquals(1, pokemon.getLevel());
        assertEquals(80, pokemon.getExperience());
        pokemon.levelUp(70);
        assertEquals(2, pokemon.getLevel());
        assertEquals(50, pokemon.getExperience());
        pokemon.levelUp(150);
        assertEquals(3, pokemon.getLevel());
        assertEquals(50, pokemon.getExperience());
        assertThrows(IllegalArgumentException.class, () -> pokemon.levelUp(-10));
    }

    @Test
    public void ChangeDisplayNameWithNickname() {
        Pokemon pikachu = new Pokemon("Pika", 50);
        pikachu.changeDisplayName();
        assertEquals("Pika", pikachu.getDisplayName());
    }

    @Test
    public void testChangeDisplayNameWithoutNickname() {
        Pokemon charmander = new Pokemon("Charmander", 10);
        charmander.changeDisplayName();
        assertEquals("Charmander", charmander.getDisplayName());
    }

    @Test
    public void testPokemon() {
        // Crea un objeto Pokemon usando el constructor
        Pokemon charmander = new Pokemon("Charmander", 5, 50);
        assertEquals("Charmander", charmander.getName());
        assertEquals(5, charmander.getLevel());
        assertEquals(50, charmander.getHealth());
    }





    @org.junit.jupiter.api.Test
    void getCounterPokemon() {
    }

    @org.junit.jupiter.api.Test
    void setCounterPokemon() {
    }

    @org.junit.jupiter.api.Test
    void getIdPokemon() {
    }

    @org.junit.jupiter.api.Test
    void setIdPokemon() {
    }

    @org.junit.jupiter.api.Test
    void getIdPokedex() {
    }

    @org.junit.jupiter.api.Test
    void train() {
    }

    @org.junit.jupiter.api.Test
    void equiparObjeto() {
    }

    @org.junit.jupiter.api.Test
    void desequiparObjeto() {
    }

    @org.junit.jupiter.api.Test
    void getObjetoEquipado() {
    }

    @org.junit.jupiter.api.Test
    void adaptStatsToLevel() {
    }

    @org.junit.jupiter.api.Test
    void changeDisplayName() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
    }

    @org.junit.jupiter.api.Test
    void setItem() {
    }

    @org.junit.jupiter.api.Test
    void removeITEM() {
    }

    @org.junit.jupiter.api.Test
    void getHealth() {
    }

    @org.junit.jupiter.api.Test
    void setHealth() {
    }

    @Test
    void testGetCounterPokemon() {
    }

    @Test
    void testSetCounterPokemon() {
    }

    @Test
    void testGetIdPokemon() {
    }

    @Test
    void testSetIdPokemon() {
    }

    @Test
    void testGetIdPokedex() {
    }

    @Test
    void setIdPokedex() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getImage() {
    }

    @Test
    void setImage() {
    }

    @Test
    void getPokedex() {
    }

    @Test
    void setPokedex() {
    }

    @Test
    void getNickName() {
    }

    @Test
    void setNickName() {
    }

    @Test
    void getDisplayName() {
    }

    @Test
    void setDisplayName() {
    }

    @Test
    void setExperience() {
    }

    @Test
    void getHp() {
    }

    @Test
    void setHp() {
    }

    @Test
    void getLevel() {
    }

    @Test
    void setLevel() {
    }

    @Test
    void getFertility() {
    }

    @Test
    void setFertility() {
    }

    @Test
    void getAttackPower() {
    }

    @Test
    void setAttackPower() {
    }

    @Test
    void getSpecialAttack() {
    }

    @Test
    void setSpecialAttack() {
    }

    @Test
    void getDefense() {
    }

    @Test
    void setDefense() {
    }

    @Test
    void getSpecialDefense() {
    }

    @Test
    void setSpecialDefense() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void setSpeed() {
    }

    @Test
    void getStamina() {
    }

    @Test
    void setStamina() {
    }

    @Test
    void getType1() {
    }

    @Test
    void setType1() {
    }

    @Test
    void getImageBack() {
    }

    @Test
    void setImageBack() {
    }

    @Test
    void getType2() {
    }

    @Test
    void setType2() {
    }

    @Test
    void getState() {
    }

    @Test
    void setState() {
    }

    @Test
    void getSex() {
    }

    @Test
    void setSex() {
    }

    @Test
    void getMovementLevel() {
    }

    @Test
    void setMovementLevel() {
    }

    @Test
    void getExperience() {
    }

    @Test
    void getLearnedMovement() {
    }

    @Test
    void learnedMovement() {
    }

    @Test
    void setLearnedMovement() {
    }

    @Test
    void getObjeto() {
    }

    @Test
    void setObjeto() {
    }

    @Test
    void assignMovement() {
    }

    @Test
    void rest() {
    }

    @Test
    void levelUp() {
    }

    @Test
    void testTrain() {
    }

    @Test
    void testEquiparObjeto() {
    }

    @Test
    void testDesequiparObjeto() {
    }

    @Test
    void testGetObjetoEquipado() {
    }

    @Test
    void testAdaptStatsToLevel() {
    }

    @Test
    void testChangeDisplayName() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void testHashCode1() {
    }

    @Test
    void testSetItem() {
    }

    @Test
    void testRemoveITEM() {
    }

    @Test
    void testGetHealth() {
    }

    @Test
    void testSetHealth() {
    }

    @Test
    void getItem() {
    }

    @Test
    void testToString() {
    }
}