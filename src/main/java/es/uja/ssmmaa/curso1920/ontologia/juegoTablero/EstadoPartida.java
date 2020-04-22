/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Estado;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class EstadoPartida implements Predicate {
    private Partida partida;
    private Estado estadoPartida;

    public EstadoPartida() {
        this.partida = null;
        this.estadoPartida = null;
    }

    public EstadoPartida(Partida partida, Estado estadoPartida) {
        this.partida = partida;
        this.estadoPartida = estadoPartida;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory=true)
    public Estado getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(Estado estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    @Override
    public String toString() {
        return "EstadoJuego{" + "partida=" + partida + ", estadoPartida=" + estadoPartida + '}';
    }
}
