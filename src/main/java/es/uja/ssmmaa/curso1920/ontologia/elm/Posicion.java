/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import static es.uja.ssmmaa.curso1920.ontologia.Vocabulario.POSICION_NULA;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Posicion implements Concept {
    private int coorX;
    private int coorY;

    public Posicion() {
        this.coorX = POSICION_NULA;
        this.coorY = POSICION_NULA;
    }

    public Posicion(int coorX, int coorY) {
        this.coorX = coorX;
        this.coorY = coorY;
    }

    @Slot(mandatory=true)
    public int getCoorX() {
        return coorX;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    @Slot(mandatory=true)
    public int getCoorY() {
        return coorY;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    @Override
    public String toString() {
        return "Posicion{" + "coorX=" + coorX + ", coorY=" + coorY + '}';
    }
}
