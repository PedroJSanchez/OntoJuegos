/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.AgentAction;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

/**
 *
 * @author pedroj
 */
public class CompletarPartida implements AgentAction {
    private Partida partida;
    private InfoJuego infoJuego;
    private List listaJugadores;

    public CompletarPartida() {
        this.partida = null;
        this.infoJuego = null;
        this.listaJugadores = null;
    }

    public CompletarPartida(Partida partida, InfoJuego infoJuego, List listaJugadores) {
        this.partida = partida;
        this.infoJuego = infoJuego;
        this.listaJugadores = listaJugadores;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory=true)
    public InfoJuego getInfoJuego() {
        return infoJuego;
    }

    public void setInfoJuego(InfoJuego infoJuego) {
        this.infoJuego = infoJuego;
    }

    @AggregateSlot(cardMin=2, type=Jugador.class)
    public List getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
}
