package org.thesummoners.model;

public class Pokemon {
    private String nombre;
    private int nivel;
    public Pokemon (String nombre, int nivel){
        this.nivel = nivel;
        this.nombre = nombre;
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
