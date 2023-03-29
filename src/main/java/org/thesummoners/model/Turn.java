package org.thesummoners.model;

public class Turn {

    private int currentTurn;
    private int trainerTurn;
    private int rivalTurn;

    public Turn(){
        this.currentTurn = 0;
        this.rivalTurn = 0;
        this.trainerTurn= 0;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getTrainerTurn() {
        return trainerTurn;
    }

    public void setTrainerTurn(int trainerTurn) {
        this.trainerTurn = trainerTurn;
    }

    public int getRivalTurn() {
        return rivalTurn;
    }

    public void setRivalTurn(int rivalTurn) {
        this.rivalTurn = rivalTurn;
    }
}
