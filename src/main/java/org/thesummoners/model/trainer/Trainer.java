package org.thesummoners.model.trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.objeto.ObjetoInitializer;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;

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
    public Pokemon[] pokemonToBreed = new Pokemon[2];
    public Pokemon[] pokemonCub = new Pokemon[1];
    public Trainer() {
        //POKEDOLLARS DE PRUEBA
        this.pokedollar = 10000;

        Pokemon [] pokemonTeam = new Pokemon[6];
        this.pokemonTeam = pokemonTeam;

        //20 POKEBALL DE PRUEBA
        this.pokeball = 20;
    }

    public static Trainer getTrainer() {
        synchronized (Trainer.class){
            if(trainer == null){
                trainer = new Trainer();
            }
        }
        return trainer;
    }

    public Pokemon[] getPokemonToBreed() {
        return pokemonToBreed;
    }

    public void setPokemonToBreed(Pokemon[] pokemonToBreed) {
        this.pokemonToBreed = pokemonToBreed;
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

    public Pokemon[] getPokemonCub() {
        return pokemonCub;
    }

    public void setPokemonCub(Pokemon[] pokemonCub) {
        this.pokemonCub = pokemonCub;
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
        - LOS VALORES NULL DE pokemonBox SE COMPLETAN AL AÑADIR NUEVOS PKMN A LA LISTA

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

        for(Pokemon a : pokemonPcBill){
            if(a.getIdPokemon() == idPokemon){
                pokemonTeam[i] = a;
                pokemonPcBill.remove(a);
            }
        }
    }

    public String pokemonBreeding(int n){
        //ESTE MÉTODO SE LLAMA raiseAPokemon EN EL DIAGRAMA DE CLASES
        //HAY QUE ASEGURARSE QUE SE TENGAN, AL MENOS, 2 POKÉMON PARA
        //PODER CRIAR
        int counter = 0;
        for(Pokemon p: pokemonTeam){
            if(p != null){
                counter++;
            }
        }
        if(counter < 2){
            return "Necesitas tener al menos 2 Pokémon en el equipo";
        }
        else{
            if(Trainer.getTrainer().getPokemonTeam()[n].getLevel() >= 0) { //ESTE 0 TIENE QUE SER 5 PARA NO ABUSAR DE CRIANZAS
                if (pokemonToBreed[0] == null)
                    pokemonToBreed[0] = getTrainer().getPokemonTeam()[n];
                else if (pokemonToBreed[1] == null)
                    pokemonToBreed[1] = getTrainer().getPokemonTeam()[n];
                else
                    return "Ya has seleccionado los 2 pokemon";
            }
            else
                return "El Pokemon debe ser mínimo nivel 5 para criar";





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

    public void BreedingPay(){
        Random rd = new Random();
        //FIXME CODIGO COMENTADO PARA QUE NO DE ERROR
        /*
        Pokemon son = new Pokemon(pokemonToBreed[rd.nextInt(2)].getDisplayName(),1);

        for (int i = 0; i < getPokemonTeam().length; i++) {
            if(getPokemonTeam()[i] == null) {
                getPokemonTeam()[i] = son;
                pokemonCub[0] = son;
                break;
            }
        }
        */
        Trainer.getTrainer().getPokemonToBreed()[0] = null;
        Trainer.getTrainer().getPokemonToBreed()[1] = null;
    }
    public void BreedingConfirmNickname(String mote){
        Trainer.getTrainer().getPokemonCub()[0].setNickName(mote);
        setPokemonCub(null);
    }

    public void fight(Pokemon pokemonTeam, Pokemon pokemonEnemy) throws CloneNotSupportedException {
        Pokemon pokemon1 = (Pokemon) pokemonTeam.clone();
        Pokemon pokemon2 = (Pokemon) pokemonEnemy.clone();



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

    public int pokedollarCount(){

        if(this.getPokedollar() <= 0) return this.pokedollar = 0;
        else return this.pokedollar;
    }

    public void capture (Pokemon pokemon, Label lblText, Label lblPokeballs) throws CloneNotSupportedException {
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
                        getPokemonTeam()[i] = pokemon.clone();
                        lblText.setText("¡Has capturado a Venusaur, el Pokémon se ha enviado a tu equipo!");
                        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());
                        break;
                    }
                }
            }
            else pokemonPcBill.add(pokemon.clone());
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
        for(int i = 0; i < listTeamIntermediary.size(); i++){
            Trainer.getTrainer().getPokemonTeam()[i] = listTeamIntermediary.get(i);
        }
    }


    public void pokeballShop(Label lblPokeballs, Label lblPokedollars, Label lblbuyOrNot){
        if(getTrainer().getPokedollar() >= 100){
            getTrainer().setPokeball(getPokeball() + 1);
            getTrainer().setPokedollar(getPokedollar() - 100);
            lblbuyOrNot.setText("Pokeball comprada");
            lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());
            lblPokedollars.setText("Pokedollar disponibles " + Trainer.getTrainer().getPokedollar());
        }
        else {
            lblbuyOrNot.setText("No tienes suficientes Pokedollars");
        }
    }


    public void objetoShop(Button btnBuyObjeto, TableView tvObjeto, TableView tvBackPack, Label lblPokedollars, Label lblbuyOrNot){
        //TODO AÑADIR UNA BARRA DESPLAZADORA O ALGO PARA QUE NO SE MUEVA LA LISTA DE OBJETOS
        //TODO HACER QUE NO SE PUEDA COMPRAR MÁS CUANDO NO TENGAS DINERO

        ObjetoInitializer.objetoList();
        Objeto selectedObjeto = (Objeto) tvObjeto.getSelectionModel().getSelectedItem();
        if(this.getPokedollar() >= 500 && selectedObjeto != null){
            Trainer.getTrainer().setPokedollar(getPokedollar() - 500);
            pokedollarCount();
            // AGREGA EL OBJETO SELECCIONADO A LA LISTA DE BACKPACK
            Trainer.backPack.add(selectedObjeto);
            // ACTUALIZA LA VISTA DE LA TABLEVIEW
            tvBackPack.setItems(Trainer.getBackPack());


            lblbuyOrNot.setText("Has comprado un Objeto");
            lblPokedollars.setText("Pokedollar disponibles " + Trainer.getTrainer().pokedollarCount());
        }
        else lblbuyOrNot.setText("No tienes Pokedollars suficientes");
    }


    public void unequipObject(Pokemon pokemon){
        //TODO METODO PARA DESEQUIPAR EL OBJETO
        //TODO HACER MÉTODO PARA EQUIPAR OBJETO AL POKÉMON TENIENDO EN CUENTA SI YA TIENE OTRO PUESTO
        //TODO TENER EN CUENTA QUE PODEMOS HACER QUE LA MOCHILA ESTÉ EN TABLEVIEW
    }

    public void train(Pokemon p, Label lblActualLevel, Label lblPrice, Label lblPokedollars, Label lblLevel) throws CloneNotSupportedException {
        //MÉTODO PARA ENTRENAR POKÉMONS
        if(p != null){
            int priceTrain = p.getLevel() * 20;
            if(this.getPokedollar() >= priceTrain && p.getLevel() < 100){
                p.adaptStatsToLevel(p.getLevel() + 1, p);
                this.setPokedollar(this.getPokedollar() - priceTrain);
                pokedollarCount();
                lblPokedollars.setText("Pokedollars disponibles: " + this.getPokedollar());
                lblActualLevel.setText("Nivel actual: " + p.getLevel());
                lblPrice.setText("Precio: " + priceTrain);
                lblLevel.setText("Has entrenado a " + p.getDisplayName());
            }
            else lblLevel.setText("No has podido entrear a " + p.getDisplayName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return pokedollar == trainer.pokedollar && pokeball == trainer.pokeball && Objects.equals(name, trainer.name) && Objects.equals(password, trainer.password) && Arrays.equals(pokemonTeam, trainer.pokemonTeam) && Arrays.equals(pokemonToBreed, trainer.pokemonToBreed) && Arrays.equals(pokemonCub, trainer.pokemonCub);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, password, pokedollar, pokeball);
        result = 31 * result + Arrays.hashCode(pokemonTeam);
        result = 31 * result + Arrays.hashCode(pokemonToBreed);
        result = 31 * result + Arrays.hashCode(pokemonCub);
        return result;
    }
}
