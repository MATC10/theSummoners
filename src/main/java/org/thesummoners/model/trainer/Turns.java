package org.thesummoners.model.trainer;

public class Turns {

    private boolean currentTurn;
    private int numberTurn;

    public Turns(){
        numberTurn = 1;
    }

    public void calculateFirstTurn(){
//CALCULAR TURNO
//CALCULAR EL POKEMON QUE ATACA ANTES
//TRUE ES EL POKÉMON DEL ENTRENADOR, FALSE ES EL DEL ENEMIGO
        if(numberTurn == 1 && (Trainer.getTrainer().getPokemonTeam()[0].getSpeed() >= Enemy.getEnemyTeam()[0].getSpeed())){
            currentTurn = true;
        }
        else currentTurn = false;
    }

    public boolean nextTurn(boolean currentTurn){
        numberTurn++;
        if(currentTurn) return this.currentTurn = false;
        else return this.currentTurn = true;
    }



    public boolean isCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(boolean currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getNumberTurn() {
        return numberTurn;
    }

    public void setNumberTurn(int numberTurn) {
        this.numberTurn = numberTurn;
    }
}