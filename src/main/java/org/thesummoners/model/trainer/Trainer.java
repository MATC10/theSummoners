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
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.Logger;
import org.thesummoners.model.movement.*;
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
    private List<Pokemon> pokemonTeamList;
    public static ObservableList<Pokemon> pokemonPcBill = FXCollections.observableArrayList();

    public static ObservableList <Objeto> backPack = FXCollections.observableArrayList();;
    private ObservableList<String> sentencesTextFight = FXCollections.observableArrayList();
    private int pokedollar;
    private int pokeball;
    public Pokemon[] pokemonToBreed = new Pokemon[2];
    public Pokemon[] pokemonCub = new Pokemon[1];
    public Pokemon pokemonSelectedCombat;

    /**
     * Trainer es singleton
     * Se inicia con un equipo pokemon (Array de 6 posiciones), 20 pokeballs y 100000 pokedollars
     */

    public Trainer() {
        //POKEDOLLARS DE PRUEBA
        this.pokedollar = 100000;
        pokemonTeamList = new LinkedList<>();

        Pokemon [] pokemonTeam = new Pokemon[6];
        this.pokemonTeam = pokemonTeam;

        //20 POKEBALL DE PRUEBA
        this.pokeball = 20;
    }

    /**
     * El singleton lleva un synchronized (sirve para que dos usuarios
     * no puedan crear a la misma vez dos Trainer, aunque eso es imposible en esta aplicación)
     * @return Método para hacer singleton
     */
    public static Trainer getTrainer() {
        synchronized (Trainer.class){
            if(trainer == null){
                trainer = new Trainer();
            }
        }
        return trainer;
    }

    public List<Pokemon> getPokemonTeamList() {
        return pokemonTeamList;
    }

    public void setPokemonTeamList(List<Pokemon> pokemonTeamList) {
        this.pokemonTeamList = pokemonTeamList;
    }

    /**
     * @return selecciona un Pokémon para trabajar con él
     */
    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    /**
     *
     * @return Contiene a los dos Pokémon padres.
     */
    public Pokemon[] getPokemonToBreed() {
        return pokemonToBreed;
    }

    public void setPokemonToBreed(Pokemon[] pokemonToBreed) {
        this.pokemonToBreed = pokemonToBreed;
    }

    public String getName() {
        return name;
    }

    /**
     * para el password
     * @return retorna password
     */
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

    /**
     * Almacena los string sucedidos en combate para usarlos en distintos sitios
     *
     */
    public ObservableList<String> getSentencesTextFight() {
        return sentencesTextFight;
    }

    public void setSentencesTextFight(ObservableList<String> sentencesTextFight) {
        this.sentencesTextFight = sentencesTextFight;
    }

    /**
     * Almacena Pokémon en zona de crianza y otros métodos
     * @return
     */
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

    /**
     * PcBill es donde se almacenan los Pokémon de la caja Pokémon
     *
     */
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

    /**
     * La mochila de los objetos
     *
     */
    public static ObservableList<Objeto> getBackPack() {
        return backPack;
    }

    public static void setBackPack(ObservableList<Objeto> backPack) {
        Trainer.backPack = backPack;
    }

    /**
     * CREAMOS UN CONTADOR DE LOS POKEMON QUE TENEMOS EN EL pokemonTeam
     * @return
     */
    public int numberPokemonInTeam(){
        int numberPokemonCounter = 0;
        for(Pokemon p : this.pokemonTeam){
            if(p != null){
                numberPokemonCounter++;
            }
        }
        return numberPokemonCounter;
    }

    /**
     * @deprecated se usaba cuando íbamos a usar la mecánica de meter Pokémon en PcBill, finalmente no lo
     * hicismos de esta forma
     *
     */
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


    /**
     * @deprecated lo íbamos a usar para pasar pokémon al team dependiendo del Id, finalmente el
     * idPokemon no lo usamos, solamente el de la BBDD
     * @param i
     * @param idPokemon
     */
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

    /**
     * Mecánica para la crianza de los Pokémon, tiene en cuenta la fertilidad y el nivel
     * (mínimo nivel 5 del Pokémon para criar)
     * @param n
     * @return
     */
    public boolean pokemonBreeding(int n){
        int counter = 0;
        for(Pokemon p: pokemonTeam){
            if(p != null){
                counter++;
            }
        }
        if(counter < 2){
            return false;
        }
        else{
            if(Trainer.getTrainer().getPokemonTeam()[n].getFertility() > 0) {
                if (Trainer.getTrainer().getPokemonTeam()[n].getLevel() >= 5) {
                    if (pokemonToBreed[0] == null)
                        pokemonToBreed[0] = getTrainer().getPokemonTeam()[n];
                    else if (pokemonToBreed[1] == null)
                        pokemonToBreed[1] = getTrainer().getPokemonTeam()[n];
                    else
                        return false;
                } else
                    return false;
            }else
                return false;
        }
        return true;
    }

    /**
     * Pagar comprobando si tiene Pokedollars suficientes y compruba si hay hueco en el equipo
     * de lo contrario se mete en PC de Bill
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean BreedingPay() throws CloneNotSupportedException {
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
                else if (getPokemonTeam()[5] != null){
                    pokemonCub[0] = son;
                    getPokemonPcBill().add(son);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Para confirmar el NickName
     * @param mote
     */
    public void BreedingConfirmNickname(String mote){
        Trainer.getTrainer().getPokemonCub()[0].setDisplayName(mote);
    }

    /**
     * - Guardamos la Stamina de los Pokémon al inicio de la batalla
     * - Creamos un Random y un counter para Calcular cuándo los estados dejarán de tener efecto
     * - El Pokémon cambia automáticamente al siguientede la array si está debilitado, sea del Trainer o del Enemy
     * - Los Pokémon comprueban su estado al principio de la batalla
     * - Se comprueba que no estén dormidos, congelados, etc para poder hacer el movimiento
     * - Se resta la estamina si atacan
     * - Si el Pokémon muere (por ejemplo envenenado en su turno, el Pokémon cambia y se debilita)
     * - Comprueba qué tipo de movimiento para acceder a las acciones de los movimientos
     * - Si al atacar no tiene stamina, se pone a dormir automáticamente durante un turno, ese turno no ataca
     * - Si un Pokémon ataca a otro y lo mata, el Pokémon se debilita y cambia de Pokémon, si no hay más Pokémon
     * se da la batalla por ganada
     * - Al final del turno, si el Pokémon se encuentra con algún estado, se comprueba si se lo quita o sigue con él
     * - Un pokémon no puede aplicar un estado sobre otro ya existente, si está congelado se queda congelado
     * - Un pokémon no puede quitar el estado RESTING (mientras recupera estamina) a otro.
     * - Los movimientos de ataque quitan vida, los movimientos de improve mejoran las stats y los de estado, se lo aplican
     * al Pokémon enemigo
     * - El enemigo tendrá 3 Pokémon como máximo y usará ataques de forma aleatoria, sus Pokémon tendrán el mismo nivel
     * que nuestro primer Pokémon y tendrán 4 ataques cada uno de ellos. El enemigo tiene las mismas mecánicas que el Trainer
     * - Las stats de los Pokémon enemigos se corresponden con su nivel
     * - Si pierdes la partida no ganas experiencia y pierdes dinero
     * -Si ganas, tu último pokémon gana experiencia y dinero
     * - Tenemos un logger para guardar cuándo ganamos o perdemos
     * - Al acabar cada batalla los Pokémon del enemigo cambian
     * -*Nota*: Tras una batalla, si el Pokémon ha subido al nivel que aprende el ataque, podrá ir a aprender el ataque
     * pulsando en el botón correspondiente
     *
     * @param pokemon1
     * @param pokemon2
     * @param movement
     * @param lblDisplayPkTrainer
     * @param lblHpTrainer
     * @param lblHpMaxTrainer
     * @param lblLevelTrainer
     * @param imgTrainerPokemon
     * @param lblStateTrainer
     * @param lblDisplayPkEnemy
     * @param lblHpEnemy
     * @param lblHpMaxEnemy
     * @param lblLevelEnemy
     * @param imgEnemy
     * @param lblStateEnemy
     * @param btnMove1
     * @param btnMove2
     * @param btnMove3
     * @param btnMove4
     * @param toMainWindow
     * @param imgPokeball1
     * @param imgPokeball2
     * @param imgPokeball3
     * @param imgPokeball1Trainer
     * @param imgPokeball2Trainer
     * @param imgPokeball3Trainer
     * @param imgPokeball4Trainer
     * @param imgPokeball5Trainer
     * @param imgPokeball6Trainer
     * @param btnMove5
     * @throws CloneNotSupportedException
     * @throws InterruptedException
     */
    public void fight(Pokemon pokemon1, Pokemon pokemon2, Movement movement, Label lblDisplayPkTrainer, Label lblHpTrainer,
                      Label lblHpMaxTrainer, Label lblLevelTrainer, ImageView imgTrainerPokemon,
                      Label lblStateTrainer, Label lblDisplayPkEnemy, Label lblHpEnemy, Label lblHpMaxEnemy,
                      Label lblLevelEnemy, ImageView imgEnemy, Label lblStateEnemy,
                      Button btnMove1, Button btnMove2, Button btnMove3, Button btnMove4, Button toMainWindow,
                      ImageView imgPokeball1, ImageView imgPokeball2, ImageView imgPokeball3,
                      ImageView imgPokeball1Trainer,  ImageView imgPokeball2Trainer,
                      ImageView imgPokeball3Trainer, ImageView imgPokeball4Trainer,  ImageView imgPokeball5Trainer,
                      ImageView imgPokeball6Trainer, Button btnMove5) throws CloneNotSupportedException, InterruptedException {
        //DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO
        //GUARDAMOS LA STAMINA DE LOS POKEMON AL INICIO DE LA BATALLA
        Pokemon pk = pokemon1.clone();
        pk.adaptStatsToLevel(pk.getLevel(),pk);
        int staminaPokemon1 = pk.getStamina();

        //CREAMOS UN RANDOM Y UN COUNTER PARA QUE EL ENEMY PUEDA ATACAR DE FORMA ALEATORIA
        Random random = new Random();
        //CON ESTA VARIABLE CALCULAREMOS CUÁNDO QUITAR LOS ESTADOS
        int removeState;
        //SI ES EL POKEMON QUE EMPIEZA DEL ENTRENADOR ES MÁS RAPIDO, ES TRUE

        State.applyState(pokemon1, staminaPokemon1, lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer,
                lblLevelTrainer, imgTrainerPokemon, lblStateTrainer, lblDisplayPkEnemy,  lblHpEnemy,
                lblHpMaxEnemy,  lblLevelEnemy,  imgEnemy,  lblStateEnemy,  btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow,
                imgPokeball1,  imgPokeball2,  imgPokeball3, imgPokeball1Trainer,  imgPokeball2Trainer,
                imgPokeball3Trainer, imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer, btnMove5);



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
                        toMainWindow,  imgPokeball1,  imgPokeball2,  imgPokeball3, btnMove5);
            }
            //AL NO TENER STAMINA PARA HACER EL ATAQUE SE PONE A DORMIR DURANTE ESTE TURNO AUTOMÁTICAMENTE
            if(pokemon1.getStamina() < 35) {
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


    }

    /**
     * Se comprueba si el equipo está lleno al capturar
     * @return return de true o false según si el equipo está lleno o no
     */
    public boolean checkPokemonTeamFull(){
        //SI RETORNA TRUE ES PORQUE HAY ESPACIO LIBRE EN EL TEAM
        for(Pokemon p : getPokemonTeam()){
            if(p == null) return true;
        }
        return false;
    }

    /**
     * Comprueba las Pokéball disponibles y los ajusta
     * @return
     */
    public int pokeballCount(){

        if(this.getPokeball() <= 0)
            return this.pokeball = 0;
        else
            return this.pokeball;
    }

    /**
     * Comprueba los Pokedollars disponibles y los ajusta
     * @return
     */
    public int pokedollarCount(){

        if(this.getPokedollar() <= 0)
            return this.pokedollar = 0;
        else
            return this.pokedollar;
    }

    /**
     * Al intentar capturar un Pokémon se gastan Pokeballs
     * El Pokémon salvaje será del mismo nivel que el primer Pokemon de nuestro equipo Pokémon
     * Las estadísticas de los Pokémon que capturamos se corresponden con su nivel, a más nivel mejores stats
     * Los Pokémon que capturemos tendrán aprendidos más o menos ataques según el nivel en el que estén
     * Tras capturar cada Pokémon se actualiza la base de datos, nuestro equipo pokémon y PcBill
     * Tenemos un logger para guardar los Pokémon capturados y si van al equipo o al PC
     * @param pokemon
     * @param lblText
     * @param lblPokeballs
     * @throws CloneNotSupportedException
     */
    public void capture (Pokemon pokemon, Label lblText, Label lblPokeballs) throws CloneNotSupportedException {
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

                            //EL POKEMON DEBEN TENER X ATAQUES A CIERTO NIVEL
                        if (getPokemonTeam()[i].getLearnedMovement()[3] == null && getPokemonTeam()[i].getLevel() >= 10){
                            getPokemonTeam()[i].getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                            getPokemonTeam()[i].getLearnedMovement()[2] = MovementInitializer.movementListFull().get(random.nextInt(30));
                            getPokemonTeam()[i].getLearnedMovement()[3] = MovementInitializer.movementListFull().get(random.nextInt(30));
                        }
                        else if (getPokemonTeam()[i].getLearnedMovement()[2] == null && getPokemonTeam()[i].getLevel() >= 7){
                            getPokemonTeam()[i].getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                            getPokemonTeam()[i].getLearnedMovement()[2] = MovementInitializer.movementListFull().get(random.nextInt(30));
                        }
                        else if(getPokemonTeam()[i].getLearnedMovement()[1] == null && getPokemonTeam()[i].getLevel() >= 4){
                            getPokemonTeam()[i].getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                        }

                        //LOGGER
                        try (Logger logger = new Logger()) {
                            logger.log("¡Has capturado a " + Trainer.getTrainer().getPokemonTeam()[i].getDisplayName() + ",el Pokémon se ha enviado a tu equipo!");
                        }


                        //BORRAMOS TODOS LOS REGISTROS
                        PokemonCRUD.deleteAllPokemon();
                        //AÑADIMOS LOS POKEMON DE NUESTRO ARRAY A LA BBDD
                        PokemonCRUD.insertTrainerPokemonTeam(Trainer.getTrainer().getPokemonTeam());
                        //AÑADIMOS POS POKEMON DE NUESTRO PCBILL A LA BBDD
                        PokemonCRUD.insertPokemonPcBill(Trainer.getTrainer().getPokemonPcBill());

                        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
                        for(Pokemon p : Trainer.getTrainer().getPokemonTeam())
                            p = null;
                        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
                        for(int u = 0; u < Trainer.getTrainer().getPokemonTeam().length && u < listaPokemon.size(); u++)
                            Trainer.getTrainer().getPokemonTeam()[u] = listaPokemon.get(u);


                        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
                        Trainer.getTrainer().getPokemonPcBill().clear();
                        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
                        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);


                        break;
                    }
                }
            }
            else {
                Pokemon pkm = pokemon.clone();
                pokemonPcBill.add(pkm);

                lblText.setText("¡Has capturado a " + pokemon.getDisplayName() + ", el Pokémon se ha enviado a PC de Bill!");

                //EL POKEMON DEBEN TENER X ATAQUES A CIERTO NIVEL
                if (pkm.getLearnedMovement()[3] == null && pkm.getLevel() >= 10) {
                    pkm.getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                    pkm.getLearnedMovement()[2] = MovementInitializer.movementListFull().get(random.nextInt(30));
                    pkm.getLearnedMovement()[3] = MovementInitializer.movementListFull().get(random.nextInt(30));
                } else if (pkm.getLearnedMovement()[2] == null && pkm.getLevel() >= 7) {
                    pkm.getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                    pkm.getLearnedMovement()[2] = MovementInitializer.movementListFull().get(random.nextInt(30));
                } else if (pkm.getLearnedMovement()[1] == null && pkm.getLevel() >= 4) {
                    pkm.getLearnedMovement()[1] = MovementInitializer.movementListFull().get(random.nextInt(30));
                }


                //LOGGER
                try (Logger logger = new Logger()) {
                    logger.log("¡Has capturado a " + pokemon.getDisplayName() + ", el Pokémon se ha enviado a PC de Bill!");
                }

                //BORRAMOS TODOS LOS REGISTROS
                PokemonCRUD.deleteAllPokemon();
                //AÑADIMOS LOS POKEMON DE NUESTRO ARRAY A LA BBDD
                PokemonCRUD.insertTrainerPokemonTeam(Trainer.getTrainer().getPokemonTeam());
                //AÑADIMOS POS POKEMON DE NUESTRO PCBILL A LA BBDD
                PokemonCRUD.insertPokemonPcBill(Trainer.getTrainer().getPokemonPcBill());

                //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
                for(Pokemon p : Trainer.getTrainer().getPokemonTeam())
                    p = null;
                LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
                for(int u = 0; u < Trainer.getTrainer().getPokemonTeam().length && u < listaPokemon.size(); u++)
                    Trainer.getTrainer().getPokemonTeam()[u] = listaPokemon.get(u);


                //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
                Trainer.getTrainer().getPokemonPcBill().clear();
                LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
                Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

            }
        }
        else {
            lblText.setText("No capturado!");
            //LOGGER
            try (Logger logger = new Logger()) {
                logger.log("Pokémon no capturado");
            }
        }
        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());

    }

    /**
     * //EN ESTE MÉTODO PASAMOS LOS POKEMON DEL ARRAY pokemonTeam A UNA LISTA
     * @param listTeamIntermediary
     * @return
     */
    public ObservableList <Pokemon> pokemonTeamArrayToList(ObservableList <Pokemon> listTeamIntermediary){
        listTeamIntermediary.clear();
        for(int i = 0; i < Trainer.getTrainer().numberPokemonInTeam(); i++){
            listTeamIntermediary.add(Trainer.getTrainer().getPokemonTeam()[i]);
        }
        return listTeamIntermediary;
    }

    /**
     * PASAMOS LOS POKEMON DEL OBSERVABLELIST listTeamIntermediar A LA ARRAY pokemonTeam
     * @param listTeamIntermediary
     */
    public void pokemonListToPokemonTeam (ObservableList <Pokemon> listTeamIntermediary){

        Arrays.fill(Trainer.getTrainer().getPokemonTeam(), null);
        for(int i = 0; i < listTeamIntermediary.size(); i++){
            Trainer.getTrainer().getPokemonTeam()[i] = listTeamIntermediary.get(i);
        }
    }

    /**
     * Los Pokémon del equipo se recuperan y vuelven a Alive con sus
     * stats correspondientes según el nivel y posible objeto
     * @throws CloneNotSupportedException
     */
    public void centrePokemonHeal() throws CloneNotSupportedException {

        for(Pokemon p : Trainer.getTrainer().pokemonTeam){
            if(p !=null) {
                p.adaptStatsToLevel(p.getLevel(), p);
                p.setState(State.ALIVE);
            }
        }

    }

    /**
     * Para comprar Pokeballs dependiendo del dinero que tengas
     * @param lblPokeballs
     * @param lblPokedollars
     * @param lblbuyOrNot
     */
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


    /**
     * Para comprar objetos y pasarlos entre tablas, tiene en cuenta el dinero
     * @param btnBuyObjeto
     * @param tvObjeto
     * @param tvBackPack
     * @param lblPokedollars
     * @param lblbuyOrNot
     */
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

    /**
     * @deprecated Método que ya no se usa
     *
     * @param lblDisplayPkTrainer
     * @param lblHpTrainer
     * @param lblHpMaxTrainer
     * @param lblLevelTrainer
     * @param imgTrainerPokemon
     * @param lblStateTrainer
     * @throws CloneNotSupportedException
     */
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

    /**
     * PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
     * CALCULAMOS LA VIDA MÁXIMA
     * PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
     * CAMBIAMOS LABELS E IMÁGEMENS SEGÚN CORRESPONDA
     *
     * @param lblDisplayPkTrainer
     * @param lblHpTrainer
     * @param lblHpMaxTrainer
     * @param lblLevelTrainer
     * @param imgTrainerPokemon
     * @param lblStateTrainer
     * @param imgPokeball1Trainer
     * @param imgPokeball2Trainer
     * @param imgPokeball3Trainer
     * @param imgPokeball4Trainer
     * @param imgPokeball5Trainer
     * @param imgPokeball6Trainer
     * @throws CloneNotSupportedException
     */
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

    /**
     * Entrenar cuesta dinero
     * En el controlador de Train, el Pokémon va subiendo de nivel y subiendo stats,
     * también va aprendiendo ataques según corresponda. Cuando tiene aprendidos los 4 movimientos
     * se activará un botón en el que se puede aprender un nuevo ataque por otro ya aprendido
     *
     * @param p
     * @param lblActualLevel
     * @param lblPrice
     * @param lblPokedollars
     * @param lblLevel
     * @throws CloneNotSupportedException
     */
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

    /**
     * Cuando el Pokémon se debilita se cambia al siguiente
     * Si no quedan nuevos Pokémon pierdes la batalla, te quitan dinero y no ganas experiencia
     * Se cambian las labels e imágenes
     */
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

                //EL ENTRENADOR PIERDE UN TERCIO DE  SU DINERO
                int dollars = Trainer.getTrainer().getPokedollar() - (Trainer.getTrainer().getPokedollar()/3);
                Trainer.getTrainer().setPokedollar(dollars);
                Trainer.getTrainer().getSentencesTextFight().add("Has perdido un tercio de tus Pokedollars");

                //LOGGER
                try (Logger logger = new Logger()) {
                    logger.log("¡HAS PERDIDO EL COMBATE!" + "Tus Pokémon no recibirán experiencia" + "Has perdido un tercio de tus Pokedollars");
                }

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

    /**
     *
     * @return comprueba que el Pokémon está vivo en la batalla
     */
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
