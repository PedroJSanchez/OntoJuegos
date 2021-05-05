/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class PedirMovimiento implements AgentAction {
    private Partida partida;
    private Jugador jugadorActivo;

    public PedirMovimiento() {
        this.partida = null;
        this.jugadorActivo = null;
    }

    public PedirMovimiento(Partida partida, Jugador jugadorActivo) {
        this.partida = partida;
        this.jugadorActivo = jugadorActivo;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
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
        return "PedirMovimiento{" + "partida=" + partida + ", jugadorActivo=" + jugadorActivo + '}';
    }
}
