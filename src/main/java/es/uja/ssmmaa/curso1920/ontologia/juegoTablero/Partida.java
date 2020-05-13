/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Partida implements Concept {
    private String idPartida;
    private Juego juego;
    private int ronda;
    private int maxRondas;

    public Partida() {
        this.idPartida = null;
        this.juego = null;
        this.ronda = 0;
        this.maxRondas = 0;
    }
    
    public Partida(String idPartida) {
        this.idPartida = idPartida;
        this.juego = null;
        this.ronda = 0;
        this.maxRondas = 0;
    }
    
    public Partida(String idPartida, Juego juego, int ronda, int maxRondas) {
        this.idPartida = idPartida;
        this.juego = juego;
        this.ronda = ronda;
        this.maxRondas = maxRondas;
    }

    @Slot(mandatory=true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    
    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory=true)
    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    @Slot(mandatory=true)
    public int getMaxRondas() {
        return maxRondas;
    }

    public void setMaxRondas(int maxRondas) {
        this.maxRondas = maxRondas;
    }

    @Override
    public String toString() {
        return "Partida{" + "idPartida=" + idPartida + ", juego=" + juego + 
                ", ronda=" + ronda + ", maxRondas=" + maxRondas + '}';
    }     
}
