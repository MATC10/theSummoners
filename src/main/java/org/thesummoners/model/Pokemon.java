package org.thesummoners.model;

public class Pokemon {
    private String nombre;
    private int nivel;
    private String resumen;

    public Pokemon (String nombre, int nivel){
        this.nombre = nombre;
        this.nivel = nivel;
    }
    public Pokemon (){
        this.nombre = "";
        this.nivel = 1;
    }

    public int getNivel(){
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
