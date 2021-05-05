/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class JuegoAceptado implements Predicate {
    private Juego juego;
    private AgenteJuego agenteJuego;

    public JuegoAceptado() {
        this.juego = null;
        this.agenteJuego = null;
    }

    public JuegoAceptado(Juego juego, AgenteJuego agenteJuego) {
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
    public AgenteJuego getAgenteJuego() {
        return agenteJuego;
    }

    public void setAgenteJuego(AgenteJuego agenteJuego) {
        this.agenteJuego = agenteJuego;
    }

    @Override
    public String toString() {
        return "JuegoAceptado{" + "juego=" + juego + ", agenteJuego=" + agenteJuego + '}';
    } 
}
