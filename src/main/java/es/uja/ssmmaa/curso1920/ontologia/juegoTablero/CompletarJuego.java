/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Modo;
import jade.content.AgentAction;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

/**
 *
 * @author pedroj
 */
public class CompletarJuego implements AgentAction {
    private Juego juego;
    private Modo modo;
    private InfoJuego infoJuego;
    private List listaJugadores;

    public CompletarJuego() {
        this.juego = null;
        this.modo = null;
        this.infoJuego = null;
        this.listaJugadores = null;
    }

    public CompletarJuego(Juego juego, Modo modo, InfoJuego infoJuego, List listaJugadores) {
        this.juego = juego;
        this.modo = modo;
        this.infoJuego = infoJuego;
        this.listaJugadores = listaJugadores;
    }
    
    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    @Slot(mandatory=true)
    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    @Slot(mandatory=true)
    public InfoJuego getAgenteJuego() {
        return infoJuego;
    }

    public void setAgenteJuego(InfoJuego infoJuego) {
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
