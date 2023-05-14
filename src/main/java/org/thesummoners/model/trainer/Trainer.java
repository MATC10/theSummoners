package org.thesummoners.model.trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.objeto.ObjetoInitializer;
import org.thesummoners.model.pokemon.Pokemon;

import java.util.*;

public class Trainer {
    static Trainer trainer = null;
    private String name;
    private String password;
    private Pokemon[] pokemonTeam;
    public static ObservableList<Pokemon> pokemonPcBill = FXCollections.observableArrayList();

    public static ObservableList <Objeto> backPack = FXCollections.observableArrayList();;
    private int pokedollar;

    private int pokeball;
    public Trainer() {
        //POKEDOLLARS DE PRUEBA
        this.pokedollar = 10000;

        Pokemon [] pokemonTeam = new Pokemon[6];
        this.pokemonTeam = pokemonTeam;

        //20 POKEBALL DE PRUEBA
        this.pokeball = 20;
    }

    public Trainer(String s, ArrayList<Pokemon> pokemonList, Pokemon[] pokemonTeam) {
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


    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPokeball() {
        return pokeball;
    }

    public void setPokeball(int pokeball) {
        this.pokeball = pokeball;
    }

    public static ObservableList<Pokemon> getPokemonPcBill() {
        return pokemonPcBill;
    }

    public static void setPokemonPcBill(ObservableList<Pokemon> pokemonPcBill) {
        Trainer.pokemonPcBill = pokemonPcBill;
    }

    public static ObservableList<Objeto> getBackPack() {
        return backPack;
    }

    public static void setBackPack(ObservableList<Objeto> backPack) {
        Trainer.backPack = backPack;
    }

    //CREAMOS UN CONTADOR DE LOS POKEMON QUE TENEMOS EN EL pokemonTeam
    public int numberPokemonInTeam(){
        int numberPokemonCounter = 0;
        for(Pokemon p : this.pokemonTeam){
            if(p != null){
                numberPokemonCounter++;
            }
        }
        return numberPokemonCounter;
    }


    public void dragPokemonIntoBox(int i){

        /*
        - LOS VALORES NULL DE pokemonPcBill SE COMPLETAN AL AÑADIR NUEVOS PKMN A LA LISTA

       - UNA IDEA ES CREAR UNA NUEVA LISTA POR SI SE AÑADEN EN ALGÚN MOMENTO MUCHOS POKEMON
        A LA LISTA PERO LUEGO SE TIRAN ESOS POKEMON, PARA QUE NO QUEDEN VALORES NULL AL FINAL
        DE LA LISTA (AÚN NO SE SABE SI SE VA A IMPLEMENTAR TIRAR POKÉMON)
         */
        boolean pokemonAdded = false;
        for(int s = 0; s < pokemonPcBill.size(); s++){
            if(pokemonPcBill.get(s) == null && numberPokemonInTeam() > 1){
                pokemonPcBill.add(s, pokemonTeam[i]);
                pokemonTeam[i] = null;
                pokemonAdded = true;
                break;
            }
        }
        if(!pokemonAdded && numberPokemonInTeam() > 1){
            pokemonPcBill.add(pokemonTeam[i]);
            pokemonTeam[i] = null;
        }
    }


    public void dragPokemonIntoTeam(int i, int idPokemon){
        //REVISAR SI ES POSIBLE QUITAR EL IDPOKEMON EN EL PARÁMETRO
        //O CAMBIARLO POR OTRA COSA

        for(Pokemon a : this.pokemonPcBill){
            if(a.getIdPokemon() == idPokemon){
                pokemonTeam[i] = a;
                pokemonPcBill.remove(a);
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
            pokemonPcBill.add();
            breeding[2] =
             */

            //Se abrirá una nueva ventana con el nuevo pokémon
            //y todas sus stats
            return "Enhorabuena ...";


        }
    }

    public void fight(){

    }

    public boolean checkPokemonTeamFull(){
        //SI RETORNA TRUE ES PORQUE HAY ESPACIO LIBRE EN EL TEAM
        for(Pokemon p : getPokemonTeam()){
            if(p == null) return true;
        }
        return false;
    }


    public int pokeballCount(){

        if(this.getPokeball() <= 0) return this.pokeball = 0;
        else return this.pokeball;
    }

    public void capture (Pokemon pokemon, Label lblText, Label lblPokeballs){
        /*AQUÍ HE AÑADIDO UNA MECÁNICA PARA QUE SI EN EL EQUIPO HAY HUECOS LIBRES
        AÑADIMOS EL NUEVO POKÉMON AL EQUIPO, SI NO HAY HUECOS LIBRES LO AÑADIMOS A LA
        CAJA DE POKÉMON (PC de Bill).
        EL PARÁMETRO DE ESTE MÉTODO ES EL POKEMON QUE SE VA A CAPTURAR
         */
        //EL pokemon.changeDisplayName() ES PARA DARLE EL NOMBRE DE DISPLAY

        //TODO MAXIMO 0 POKEBALL HACERLO EN EL METODO DEL TRAINTER DE POKEBALL
        getTrainer().setPokeball(getPokeball() -1);
        lblPokeballs.setText(String.valueOf(pokeballCount()));
        Random random = new Random();
        int capture = random.nextInt(3);
        if (capture == 0 && getTrainer().getPokeball() > 0) {
            if(checkPokemonTeamFull()) {
                for(int i = 0; i < getPokemonTeam().length; i++){
                    if(getPokemonTeam()[i] == null) {
                        getPokemonTeam()[i] = pokemon;
                        lblText.setText("¡Has capturado a Venusaur, el Pokémon se ha enviado a tu equipo!");
                    }
                }
            }
            else pokemonPcBill.add(pokemon);
            lblText.setText("¡Has capturado a Venusaur, el Pokémon se ha enviado a PC de Bill!");
        }
        else {
            lblText.setText("No capturado!");
        }
        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());

    }

    public ObservableList <Pokemon> pokemonTeamArrayToList(ObservableList <Pokemon> listTeamIntermediary){
        //EN ESTE MÉTODO PASAMOS LOS POKEMON DEL ARRAY pokemonTeam A UNA LISTA
        listTeamIntermediary.clear();
        for(int i = 0; i < Trainer.getTrainer().numberPokemonInTeam(); i++){
            listTeamIntermediary.add(Trainer.getTrainer().getPokemonTeam()[i]);
        }
        return listTeamIntermediary;
    }

    public void pokemonListToPokemonTeam (ObservableList <Pokemon> listTeamIntermediary){
        //EPASAMOS LOS POKEMON DEL OBSERVABLELIST listTeamIntermediary
        // A LA ARRAY pokemonTeam
        Arrays.fill(Trainer.getTrainer().getPokemonTeam(), null);
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length; i++){
            Trainer.getTrainer().getPokemonTeam()[i] = listTeamIntermediary.get(i);
        }
    }






    public boolean ObjetoShop(Button btnBuyObjeto, TableView tvObjeto, TableView tvBackPack){
        //TODO AÑADIR UNA BARRA DESPLAZADORA O ALGO PARA QUE NO SE MUEVA LA LISTA DE OBJETOS
        //TODO HACER QUE NO SE PUEDA COMPRAR MÁS CUANDO NO TENGAS DINERO

        ObjetoInitializer.objetoList();

        if(this.getPokedollar() >= 1000){

            btnBuyObjeto.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {
                    Objeto selectedObjeto = (Objeto) tvObjeto.getSelectionModel().getSelectedItem();
                    // AGREGA EL OBJETO SELECCIONADO A LA LISTA DE BACKPACK
                    Trainer.backPack.add(selectedObjeto);
                    // ACTUALIZA LA VISTA DE LA TABLEVIEW
                    tvBackPack.setItems(Trainer.getBackPack());
                }
        });
        return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return pokedollar == trainer.pokedollar && Objects.equals(name, trainer.name) && Arrays.equals(pokemonTeam, trainer.pokemonTeam) && Objects.equals(pokemonPcBill, trainer.pokemonPcBill) && Objects.equals(backPack, trainer.backPack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, pokemonPcBill, pokedollar, backPack);
        result = 31 * result + Arrays.hashCode(pokemonTeam);
        return result;
    }
    public void manageObject(Pokemon pokemon, Objeto objeto){
        if (pokemon.getObjetoEquipado(objeto) == null){
            pokemon.getObjetoEquipado(objeto);
        }
        else {pokemon.desequiparObjeto();}
    }

    public void addToTeam(Pokemon staryu) {
    }

    public boolean getPokemon1() {
        return false;
    }
}
