package org.thesummoners.model.trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.thesummoners.model.movement.AttackMovement;
import org.thesummoners.model.movement.ImproveMovement;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.movement.StateMovement;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.objeto.ObjetoInitializer;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.pokemon.Sex;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Trainer {
    static Trainer trainer = null;

    //EL pokemon1 ES EL POKEMON EN COMBATE DE TRAINER
    private Pokemon pokemon1;
    private String name;
    private String password;
    private Pokemon[] pokemonTeam;
    public static ObservableList<Pokemon> pokemonPcBill = FXCollections.observableArrayList();

    public static ObservableList <Objeto> backPack = FXCollections.observableArrayList();;
    private ObservableList<String> sentencesTextFight = FXCollections.observableArrayList();
    private int pokedollar;
    private int pokeball;
    public Pokemon[] pokemonToBreed = new Pokemon[2];
    public Pokemon[] pokemonCub = new Pokemon[1];
    public Pokemon pokemonSelectedCombat;


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

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
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

    public ObservableList<String> getSentencesTextFight() {
        return sentencesTextFight;
    }

    public void setSentencesTextFight(ObservableList<String> sentencesTextFight) {
        this.sentencesTextFight = sentencesTextFight;
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

    public Pokemon getPokemonSelectedCombat() {
        return pokemonSelectedCombat;
    }

    public void setPokemonSelectedCombat(Pokemon pokemonSelectedCombat) {
        this.pokemonSelectedCombat = pokemonSelectedCombat;
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
            if(Trainer.getTrainer().getPokemonTeam()[n].getFertility() > 0) {
                if (Trainer.getTrainer().getPokemonTeam()[n].getLevel() >= 5) {
                    if (pokemonToBreed[0] == null)
                        pokemonToBreed[0] = getTrainer().getPokemonTeam()[n];
                    else if (pokemonToBreed[1] == null)
                        pokemonToBreed[1] = getTrainer().getPokemonTeam()[n];
                    else
                        return "Ya has seleccionado los 2 pokemon";
                } else
                    return "El Pokemon debe ser mínimo nivel 5 para criar";
            }else
                return "El pokemon no tiene fertilidad";
            return "Enhorabuena ...";
        }
    }

    public void BreedingPay() throws CloneNotSupportedException {
        Random rd = new Random();
        Pokemon son = null;
        if (Trainer.getTrainer().getPokedollar() >= 500) {
            for (Pokemon p : Pokedex.getPokedex()) {
                if(getPokemonToBreed()[rd.nextInt(2)].getName().equals(p.getName())) {
                    son = p.clone();
                }
            }
            for (int i = 0; i < getPokemonTeam().length; i++) {
                if (getPokemonTeam()[i] == null) {
                    getPokemonTeam()[i] = son;
                    pokemonCub[0] = son;
                    break;
                }
            }
        }
    }
    public void BreedingConfirmNickname(String mote){
        Trainer.getTrainer().getPokemonCub()[0].setNickName(mote);
    }


    public void fight(Pokemon pokemon1, Pokemon pokemon2, Movement movement, Label lblDisplayPkTrainer, Label lblHpTrainer,
                      Label lblHpMaxTrainer, Label lblLevelTrainer, ImageView imgTrainerPokemon,
                      Label lblStateTrainer, Label lblDisplayPkEnemy, Label lblHpEnemy, Label lblHpMaxEnemy,
                      Label lblLevelEnemy, ImageView imgEnemy, Label lblStateEnemy,
                       Button btnMove1, Button btnMove2, Button btnMove3, Button btnMove4, Button toMainWindow,
                      ImageView imgPokeball1, ImageView imgPokeball2, ImageView imgPokeball3,
                      ImageView imgPokeball1Trainer,  ImageView imgPokeball2Trainer,
                      ImageView imgPokeball3Trainer, ImageView imgPokeball4Trainer,  ImageView imgPokeball5Trainer,  ImageView imgPokeball6Trainer) throws CloneNotSupportedException, InterruptedException {
        //TODO DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO
        //GUARDAMOS LA STAMINA DE LOS POKEMON AL INICIO DE LA BATALLA
        Pokemon pk = pokemon1.clone();
        pk.adaptStatsToLevel(pk.getLevel(),pk);
        int staminaPokemon1 = pk.getStamina();

        //CREAMOS UN RANDOM Y UN COUNTER PARA QUE EL ENEMY PUEDA ATACAR DE FORMA ALEATORIA
        Random random = new Random();
        int counter = 0;
        //CON ESTA VARIABLE CALCULAREMOS CUÁNDO QUITAR LOS ESTADOS
        int removeState;
        //SI ES EL POKEMON QUE EMPIEZA DEL ENTRENADOR ES MÁS RAPIDO, ES TRUE

            State.applyState(pokemon1, staminaPokemon1, lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer,
                    lblLevelTrainer, imgTrainerPokemon, lblStateTrainer, lblDisplayPkEnemy,  lblHpEnemy,
                    lblHpMaxEnemy,  lblLevelEnemy,  imgEnemy,  lblStateEnemy,  btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow,
                     imgPokeball1,  imgPokeball2,  imgPokeball3, imgPokeball1Trainer,  imgPokeball2Trainer,
                    imgPokeball3Trainer, imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);



            //TODO EN ESTE PUNTO PODRÍA PREGUNTAR SI QUIERES CAMBIAR DE POKEMON

            if(pokemon1.getState() != State.RESTING && pokemon1.getState() != State.ASLEEP &&
                    pokemon1.getState() != State.DEBILITATED && pokemon1.getState() != State.FROZEN){
                //COMPROBAR QUE TIENE STAMINA DISPONIBLE
                if(pokemon1.getStamina() >= movement.getStamina()){
                    AttackMovement.attackCombat(pokemon1, pokemon2, movement);
                    StateMovement.stateCombat(pokemon1, pokemon2, movement);
                    ImproveMovement.improveCombat(pokemon1, movement);

                    pokemon1.setStamina(pokemon1.getStamina() - movement.getStamina());

                    changePokemonInFightTrainer(lblDisplayPkTrainer,lblHpTrainer, lblHpMaxTrainer,
                            lblLevelTrainer, imgTrainerPokemon, lblStateTrainer, imgPokeball1Trainer,  imgPokeball2Trainer,
                            imgPokeball3Trainer, imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer,
                             btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow);

                    Enemy.getEnemy().changePokemonInFightEnemy(lblDisplayPkEnemy,  lblHpEnemy,  lblHpMaxEnemy,
                            lblLevelEnemy, imgEnemy,  lblStateEnemy,  btnMove1,  btnMove2,  btnMove3,  btnMove4,
                            toMainWindow,  imgPokeball1,  imgPokeball2,  imgPokeball3);
                }
                //AL NO TENER STAMINA PARA HACER EL ATAQUE SE PONE A DORMIR DURANTE ESTE TURNO AUTOMÁTICAMENTE
              else {
                  //SE
                    pokemon1.setState(State.RESTING);
                    Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " se encuentra dormido para recargar Stamina");

                }
            }
            //AQUÍ SE QUITAN LOS DISTINTOS EFECTOS: PARALYSED, BURNED, POISONED, ASLEEP, FROZEN Y PASA A ALIVE SI ESTÁ VIVO
            removeState = random.nextInt(3);
            if((pokemon1.getState() == State.ASLEEP || pokemon1.getState() == State.FROZEN ||
                    pokemon1.getState() == State.PARALYSED ||  pokemon1.getState() == State.BURNED ||
                    pokemon1.getState() == State.POISONED) && pokemon1.getHp() > 0 && removeState == 0){
                pokemon1.setState(State.ALIVE);
                Trainer.getTrainer().getSentencesTextFight().add(pokemon1.getDisplayName() + " ya no se encuentra afectado por ningún estado");

            }

        //TODO PONER UNA LABEL CON EL TURNO

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
                        lblText.setText("¡Has capturado a " + Trainer.getTrainer().getPokemonTeam()[i].getDisplayName() + ",el Pokémon se ha enviado a tu equipo!");
                        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());
                        break;
                    }
                }
            }
            else pokemonPcBill.add(pokemon.clone());
            lblText.setText("¡Has capturado a " + pokemon.getDisplayName() + ", el Pokémon se ha enviado a PC de Bill!");
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
        else lblbuyOrNot.setText("No has comprado ningún objeto");
    }

    public void changeLabelsInitializeTrainer(Label lblDisplayPkTrainer, Label lblHpTrainer, Label  lblHpMaxTrainer, Label  lblLevelTrainer,
                                              ImageView imgTrainerPokemon, Label lblStateTrainer) throws CloneNotSupportedException {
        //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
        lblDisplayPkTrainer.setText(Trainer.getTrainer().getPokemon1().getDisplayName());
        lblHpTrainer.setText("Vida: " + Trainer.getTrainer().getPokemon1().getHp());
        lblLevelTrainer.setText("Nivel: " + Trainer.getTrainer().getPokemon1().getLevel());
        lblStateTrainer.setText("Estado: " + Trainer.getTrainer().getPokemon1().getState());
        //CALCULAMOS LA VIDA MÁXIMA
        Pokemon p1 = Trainer.getTrainer().getPokemon1().clone();
        p1.adaptStatsToLevel(p1.getLevel(), p1);
        lblHpMaxTrainer.setText("Vida inicial: " + p1.getHp());

        //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
        File file = new File(Trainer.getTrainer().getPokemon1().getImageBack());
        Image image = new Image(file.toURI().toString());
        imgTrainerPokemon.setImage(image);
    }

public void changeLabelsInFight(Label lblDisplayPkTrainer, Label lblHpTrainer, Label  lblHpMaxTrainer, Label  lblLevelTrainer,
                                ImageView imgTrainerPokemon, Label lblStateTrainer,
                                ImageView imgPokeball1Trainer, ImageView imgPokeball2Trainer, ImageView imgPokeball3Trainer,
                                ImageView imgPokeball4Trainer, ImageView imgPokeball5Trainer, ImageView imgPokeball6Trainer) throws CloneNotSupportedException {
    //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
    lblDisplayPkTrainer.setText(Trainer.getTrainer().getPokemon1().getDisplayName());
    lblHpTrainer.setText("Vida: " + Trainer.getTrainer().getPokemon1().getHp());
    lblLevelTrainer.setText("Nivel: " + Trainer.getTrainer().getPokemon1().getLevel());
    lblStateTrainer.setText("Estado: " + Trainer.getTrainer().getPokemon1().getState());
    //CALCULAMOS LA VIDA MÁXIMA
    Pokemon p1 = Trainer.getTrainer().getPokemon1().clone();
    p1.adaptStatsToLevel(p1.getLevel(), p1);
    lblHpMaxTrainer.setText("Vida inicial: " + p1.getHp());

    //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
    File file = new File(Trainer.getTrainer().getPokemon1().getImageBack());
    Image image = new Image(file.toURI().toString());
    imgTrainerPokemon.setImage(image);

    for(int i = 0; i < this.pokemonTeam.length; i++) {
        //POKEBALL TRAINER
        //TODO TERMINAR LOS PARAMETROS DE LA IMAGEN ImageView imgPokeball1Trainer, ImageView imgPokeball2Trainer, ImageView imgPokeball3Trainer,
        //                                ImageView imgPokeball4Trainer, ImageView imgPokeball5Trainer, ImageView imgPokeball6Trainer
        if (i < this.pokemonTeam.length && this.pokemonTeam[i] == null) {
            File file2 = new File("doc/images/PokeballDefeat.png");
            Image image2 = new Image(file2.toURI().toString());
            if(i == 0 && pokemonTeam[i] != null) imgPokeball1Trainer.setImage(image2);
            if(i == 1 && pokemonTeam[i] != null) imgPokeball2Trainer.setImage(image2);
            if(i == 2 && pokemonTeam[i] != null) imgPokeball3Trainer.setImage(image2);
            if(i == 4 && pokemonTeam[i] != null) imgPokeball4Trainer.setImage(image2);
            if(i == 5 && pokemonTeam[i] != null) imgPokeball5Trainer.setImage(image2);
            if(i == 6 && pokemonTeam[i] != null) imgPokeball6Trainer.setImage(image2);

        }
        if (i < this.pokemonTeam.length && this.pokemonTeam[i] != null && this.pokemonTeam[i].getHp() <= 0) {
            File file2 = new File("doc/images/PokeballDefeat.png");
            Image image2 = new Image(file2.toURI().toString());
            if(i == 0 && pokemonTeam[i] != null) imgPokeball1Trainer.setImage(image2);
            if(i == 1 && pokemonTeam[i] != null) imgPokeball2Trainer.setImage(image2);
            if(i == 2 && pokemonTeam[i] != null) imgPokeball3Trainer.setImage(image2);
            if(i == 4 && pokemonTeam[i] != null) imgPokeball4Trainer.setImage(image2);
            if(i == 5 && pokemonTeam[i] != null) imgPokeball5Trainer.setImage(image2);
            if(i == 6 && pokemonTeam[i] != null) imgPokeball6Trainer.setImage(image2);
        }
        if (i < this.pokemonTeam.length && this.pokemonTeam[i] != null && this.pokemonTeam[i].getHp() > 0) {
            File file2 = new File("doc/images/Pokeball.png");
            Image image2 = new Image(file2.toURI().toString());
            if(i == 0 && pokemonTeam[i] != null) imgPokeball1Trainer.setImage(image2);
            if(i == 1 && pokemonTeam[i] != null) imgPokeball2Trainer.setImage(image2);
            if(i == 2 && pokemonTeam[i] != null) imgPokeball3Trainer.setImage(image2);
            if(i == 4 && pokemonTeam[i] != null) imgPokeball4Trainer.setImage(image2);
            if(i == 5 && pokemonTeam[i] != null) imgPokeball5Trainer.setImage(image2);
            if(i == 6 && pokemonTeam[i] != null) imgPokeball6Trainer.setImage(image2);
        }
    }
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

    public void changePokemonInFightTrainer(Label lblDisplayPkTrainer,Label lblHpTrainer,Label lblHpMaxTrainer,Label lblLevelTrainer,ImageView imgTrainerPokemon,Label lblStateTrainer,
                                            ImageView imgPokeball1Trainer, ImageView imgPokeball2Trainer, ImageView imgPokeball3Trainer,
                                            ImageView imgPokeball4Trainer, ImageView imgPokeball5Trainer, ImageView imgPokeball6Trainer,
                                            Button btnMove1, Button btnMove2, Button btnMove3, Button btnMove4, Button toMainWindow) throws CloneNotSupportedException {

        int index;
        if(this.pokemon1.getHp() <= 0){
            this.pokemon1.setState(State.DEBILITATED);
            sentencesTextFight.add(pokemon1.getDisplayName() + " se encuentra debilitado");
            for(int i = 0; i < pokemonTeam.length; i++){
                index = i+1;
                if(index < 6 && this.pokemonTeam[index] != null && this.pokemonTeam[index].getHp() > 0){
                    this.pokemon1 = this.pokemonTeam[index];
                    sentencesTextFight.add("¡" + this.pokemon1.getDisplayName() + " ha entrado en combate!");
                    break;
                }
            }
            if(!pokemonAliveInTeam()){
                Trainer.getTrainer().getSentencesTextFight().clear();
                Trainer.getTrainer().getSentencesTextFight().add("¡HAS PERDIDO EL COMBATE!");
                Trainer.getTrainer().getSentencesTextFight().add("Tus Pokémon no recibirán experiencia");

                //EL ENTRENADOR PIERDE UN TERCIO DE TODO SU DINERO
                int dollars = Trainer.getTrainer().getPokedollar() - (Trainer.getTrainer().getPokedollar()/3);
                Trainer.getTrainer().setPokedollar(dollars);
                Trainer.getTrainer().getSentencesTextFight().add("Has perdido un tercio de tus Pokedollars");
                Trainer.getTrainer().getSentencesTextFight().add("Te quedan " + dollars + " Pokedollars");
                btnMove1.setDisable(true);
                btnMove2.setDisable(true);
                btnMove3.setDisable(true);
                btnMove4.setDisable(true);
                toMainWindow.setDisable(false);
            }

        }
        this.changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                 imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                 imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);

            this.changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer);

    }


    public boolean pokemonAliveInTeam() {
        for (int i = 0; i < 6; i++) {
            if (Trainer.getTrainer().getPokemonTeam()[i] != null && Trainer.getTrainer().getPokemonTeam()[i].getHp() > 0) {
                return true;
            }
        }
        return false;
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
