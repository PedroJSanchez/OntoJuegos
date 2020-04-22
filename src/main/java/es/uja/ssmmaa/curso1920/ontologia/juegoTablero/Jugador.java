/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import jade.content.onto.annotations.Slot;
import jade.core.AID;

/**
 *
 * @author pedroj
 */
public class Jugador extends AgenteJuego {
    private String nombre;
    private AID agenteJugador;

    public Jugador() {
        this.nombre = null;
        this.agenteJugador = null;
    }

    public Jugador(String nombre, AID agenteJugador) {
        this.nombre = nombre;
        this.agenteJugador = agenteJugador;
    }

    @Slot(mandatory=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Slot(mandatory=true)
    public AID getAgenteJugador() {
        return agenteJugador;
    }

    public void setAgenteJugador(AID agenteJugador) {
        this.agenteJugador = agenteJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }
}
