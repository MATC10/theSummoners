package org.thesummoners.model;

public class Objeto {
    private int idObjeto;
    private String name;
    private float [] modificador;

    public Objeto (String name){
        this.name = name;
        selectObjeto(name);
    }

    public void pesa (){
        modificador = new float[3];
        //Aumenta el ataque y la defensa un 20%, disminuye la velocidad
        //un 20%
        modificador[0] = 1.20f;
        modificador[1] = 1.20f;
        modificador[2] = 0.20f;
        this.idObjeto = 1;
    }

    public void pluma (){
        modificador = new float[3];
        //Aumenta la velocidad un 30%, disminuye la defensa y defensa
        //especial un 20%
        modificador[0] = 1.30f;
        modificador[1] = 1.30f;
        modificador[2] = 0.20f;
        this.idObjeto = 2;
    }

    public void chaleco () {
        modificador = new float[4];
        //Aumenta la defensa y la defensa especial un 20%,
        //disminuye la velocidad y el ataque un 15%
        modificador[0] = 1.20f;
        modificador[1] = 1.20f;
        modificador[2] = 0.15f;
        modificador[3] = 0.15f;
        this.idObjeto = 3;
    }
    public void baston (){
        modificador = new float[2];
        //Aumenta la estamina un 20%, disminuye la velocidad 15%
        modificador[0] = 1.20f;
        modificador[1] = 0.15f;
        this.idObjeto = 4;
    }

    public void pilas (){
        modificador = new float[2];
        //Aumenta la recuperación de estamina 50%, disminuye la
        //defensa especial un 30%
        modificador[0] = 1.50f;
        modificador[1] = 0.30f;
        this.idObjeto = 5;
    }

    public void selectObjeto (String nombre){
        switch (nombre){
            case "pesa":
                pesa();
            case "pluma":
                pluma();
            case "chaleco":
                chaleco();
            case "baston":
                baston();
            case "pilas":
                pilas();
        }
    }
}
