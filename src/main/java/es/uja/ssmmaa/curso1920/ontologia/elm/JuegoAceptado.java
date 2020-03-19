/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.Concept;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class JuegoAceptado implements Predicate {
    private Juego juego;
    private Concept agenteJuego;

    public JuegoAceptado() {
        this.juego = null;
        this.agenteJuego = null;
    }

    public JuegoAceptado(Juego juego, Concept agenteJuego) {
        this.juego = juego;
        this.agenteJuego = agenteJuego;
    }

    @Slot(mandatory=true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory=true)
    public Concept getAgenteJuego() {
        return agenteJuego;
    }

    public void setAgenteJuego(Concept agenteJuego) {
        this.agenteJuego = agenteJuego;
    }

    @Override
    public String toString() {
        return "JuegoAceptado{" + "juego=" + juego + ", agenteJuego=" + agenteJuego + '}';
    } 
}
