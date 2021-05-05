/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quoridor;

import es.uja.ssmmaa.ontologia.Vocabulario.Orientacion;
import es.uja.ssmmaa.ontologia.juegoTablero.FichaJuego;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Muro extends FichaJuego {
    private Orientacion orientacion;

    public Muro() {
        this.orientacion = null;
    }

    public Muro(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    @Slot(mandatory=true)
    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public String toString() {
        return "Muro{" + "orientacion=" + orientacion + '}';
    }
}
