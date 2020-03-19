/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.tresEnRaya;

import es.uja.ssmmaa.curso1920.ontologia.elm.Posicion;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Movimiento implements Concept {
    private Ficha ficha;
    private Posicion posicion;

    public Movimiento() {
        this.ficha = null;
        this.posicion = null;
    }

    public Movimiento(Ficha ficha, Posicion posicion) {
        this.ficha = ficha;
        this.posicion = posicion;
    }

    @Slot(mandatory=true)
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
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
