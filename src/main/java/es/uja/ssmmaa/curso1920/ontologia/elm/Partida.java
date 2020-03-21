/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Partida implements Concept {
    private Juego juego;
    private int ronda;

    public Partida() {
        this.juego = null;
        this.ronda = 0;
    }

    public Partida(Juego juego, int ronda) {
        this.juego = juego;
        this.ronda = ronda;
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

    @Override
    public String toString() {
        return "Partida(" + ronda + ") del juego " + juego;
    }   
}
