/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.tresEnRaya;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Estado;
import es.uja.ssmmaa.curso1920.ontologia.elm.Juego;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class EstadoJuego implements Predicate {
    private Juego juego;
    private Estado estadoJuego;

    public EstadoJuego() {
        this.juego = null;
        this.estadoJuego = null;
    }

    public EstadoJuego(Juego juego, Estado estadoJuego) {
        this.juego = juego;
        this.estadoJuego = estadoJuego;
    }

    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory=true)
    public Estado getEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(Estado estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    @Override
    public String toString() {
        return "EstadoJuego{" + "juego=" + juego + ", estadoJuego=" + estadoJuego + '}';
    }
}
