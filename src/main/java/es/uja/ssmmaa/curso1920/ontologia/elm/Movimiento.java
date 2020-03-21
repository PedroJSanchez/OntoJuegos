/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Movimiento implements Concept {
    private FichaJuego ficha;
    private Posicion posicion;

    public Movimiento() {
        this.ficha = null;
        this.posicion = null;
    }

    public Movimiento(FichaJuego ficha, Posicion posicion) {
        this.ficha = ficha;
        this.posicion = posicion;
    }

    @Slot(mandatory=true)
    public FichaJuego getFicha() {
        return ficha;
    }

    public void setFicha(FichaJuego ficha) {
        this.ficha = ficha;
    }

    @Slot(mandatory=true)
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "ficha=" + ficha + ", posicion=" + posicion + '}';
    }
}
