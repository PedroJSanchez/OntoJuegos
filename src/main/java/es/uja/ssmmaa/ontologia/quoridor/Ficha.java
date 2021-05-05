/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quoridor;

import es.uja.ssmmaa.ontologia.Vocabulario.Color;
import es.uja.ssmmaa.ontologia.juegoTablero.FichaJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Jugador;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Ficha extends FichaJuego {
    private Jugador jugador;
    private Color color;

    public Ficha() {
        this.jugador = null;
        this.color = null;
    }

    public Ficha(Jugador jugador, Color color) {
        this.jugador = jugador;
        this.color = color;
    }

    @Slot(mandatory=true)
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Slot(mandatory=true)
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ficha{" + "color=" + color + '}';
    }
}
