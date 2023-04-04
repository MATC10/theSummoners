package org.thesummoners.model;

import java.util.*;

public class Trainer {
    static Trainer trainer = null;
    private String name;
    private String password;
    private Pokemon[] pokemonTeam;
    private List<Pokemon> pokemonBox;
    private int pokedollar;
    private List<Objeto> backPack;

    public Trainer() {
        this.pokedollar = 100;


        //PARA HACER PRUEBAS VAMOS A METERLE A INICIALIZAR DISTINTOS ATRIBUTOS EN EL CONSTRUCTOR

        Pokemon [] pokemonTeam = new Pokemon[6];
        this.pokemonTeam = pokemonTeam;

        List<Pokemon> pokemonBox = new LinkedList<>();
        this.pokemonBox = pokemonBox;
        List<Objeto> backPack = new LinkedList<>();
        this.backPack = backPack;

        /*
        Pokemon pokemon1 = new Pokemon("Bulbasaur");
        Pokemon pokemon2 = new Pokemon("Pikachu");
        Pokemon pokemon3 = new Pokemon("Blastoise");
        Pokemon pokemon4 = new Pokemon("Venusaur");
        Pokemon pokemon5 = new Pokemon("Voltorb");
        Pokemon pokemon6 = new Pokemon("Mewtwo");
        this.pokemonTeam[0] = pokemon1;
        this.pokemonTeam[1] = pokemon2;
        this.pokemonTeam[2] = pokemon3;
        this.pokemonTeam[3] = pokemon4;
        this.pokemonTeam[4] = pokemon5;
        this.pokemonTeam[5] = pokemon6;
        */
    }

    public static Trainer getTrainer() {
        synchronized (Trainer.class){
            if(trainer == null){
                trainer = new Trainer();
            }
        }
        return trainer;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(Pokemon[] pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }

    public List<Pokemon> getPokemonBox() {
        return pokemonBox;
    }

    public void setPokemonBox(List<Pokemon> pokemonBox) {
        this.pokemonBox = pokemonBox;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Objeto> getBackPack() {
        return backPack;
    }

    public void setBackPack(List<Objeto> backPack) {
        this.backPack = backPack;
    }

    public void dragPokemonIntoBox(int i){
    pokemonBox.add(pokemonTeam[i]);
    pokemonTeam[i] = null;
    }

    public void dragIntoTeam(int i, int idPokemon){
        //REVISAR SI ES POSIBLE QUITAR EL IDPOKEMON EN EL PARÁMETRO
        //O CAMBIARLO POR OTRA COSA

        for(Pokemon a : this.pokemonBox){
            if(a.getIdPokemon() == idPokemon){
                pokemonTeam[i] = a;
                pokemonBox.remove(a);
            }
        }
    }

    public String pokemonBreeding(Pokemon pokemon1, Pokemon pokemon2){
        //ESTE MÉTODO SE LLAMA raiseAPokemon EN EL DIAGRAMA DE CLASES
        //HAY QUE ASEGURARSE QUE SE TENGAN, AL MENOS, 2 POKÉMON PARA
        //PODER CRIAR
        int counter = 0;
        int randomSelect;
        //CREO UNA ARRAY DE 3, POSICIÓN1 PARA EL PRIMER POKEMON SELECCIONADO
        //POSICIÓN DOS PARA EL SEGUNDO, Y POSICIÓN 3 PARA EL NUEVO POKÉMON;
        Pokemon[] breeding = new Pokemon[3];
        for(Pokemon p: pokemonTeam){
            if(p != null){
                counter++;
            }
        }
        if(counter < 2){
            return "Necesitas tener al menos 2 Pokémon en el equipo";
        }
        else{
            Random random = new Random();
            randomSelect = random.nextInt(2);
            breeding[0] = pokemon1;
            breeding[1] = pokemon2;
            //NECESITAMOS CREAR UN NUEVO POKEMON QUE SERÁ EL QUE TOQUE
            //EN EL RANDOM, CON EL SEXO RANDOM Y PUEDE QUE ATAQUES COMBINADOS
            //DE LOS DOS POKÉMON

            /*breeding[randomSelect];
            pokemonBox.add();
            breeding[2] =
             */

            //Se abrirá una nueva ventana con el nuevo pokémon
            //y todas sus stats
            return "Enhorabuena ...";


        }
    }

    public void combat(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return pokedollar == trainer.pokedollar && Objects.equals(name, trainer.name) && Arrays.equals(pokemonTeam, trainer.pokemonTeam) && Objects.equals(pokemonBox, trainer.pokemonBox) && Objects.equals(backPack, trainer.backPack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, pokemonBox, pokedollar, backPack);
        result = 31 * result + Arrays.hashCode(pokemonTeam);
        return result;
    }
}
