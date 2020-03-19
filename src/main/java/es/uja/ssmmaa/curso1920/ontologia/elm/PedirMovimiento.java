/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class PedirMovimiento implements AgentAction {
    private Juego juego;
    private Jugador jugadorActivo;

    public PedirMovimiento() {
        this.juego = null;
        this.jugadorActivo = null;
    }

    public PedirMovimiento(Juego juego, Jugador jugadorActivo) {
        this.juego = juego;
        this.jugadorActivo = jugadorActivo;
    }

    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory=true)
    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public void setJugadorActivo(Jugador jugadorActivo) {
        this.jugadorActivo = jugadorActivo;
    }

    @Override
    public String toString() {
        return "PedirMovimiento{" + "juego=" + juego + ", jugadorActivo=" + jugadorActivo + '}';
    }
}
