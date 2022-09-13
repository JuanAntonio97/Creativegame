package com.example.creativegame;

public class Contactos {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getJuego() {
        return Juego;
    }

    public void setJuego(String juego) {
        Juego = juego;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(String puntaje) {
        Puntaje = puntaje;
    }

    private int id;
    private String Nombre;
    private String Juego;
    private String Nivel;
    private  String Puntaje;
}
