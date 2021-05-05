/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.Predicate;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

/**
 *
 * @author pedroj
 */
public class ClasificacionJuego implements Predicate {
    private Juego juego;
    private List listaJugadores;
    private List listaPuntuacion;

    public ClasificacionJuego() {
        this.juego = null;
        this.listaJugadores = null;
        this.listaPuntuacion = null;
    }

    public ClasificacionJuego(Juego juego, List listaJugadores, List listaPuntuacion) {
        this.juego = juego;
        this.listaJugadores = listaJugadores;
        this.listaPuntuacion = listaPuntuacion;
    }

    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @AggregateSlot(cardMin=2, type=Jugador.class)
    public List getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @AggregateSlot(cardMin=2, type=Integer.class)
    public List getListaPuntuacion() {
        return listaPuntuacion;
    }

    public void setListaPuntuacion(List listaPuntuacion) {
        this.listaPuntuacion = listaPuntuacion;
    }
}
