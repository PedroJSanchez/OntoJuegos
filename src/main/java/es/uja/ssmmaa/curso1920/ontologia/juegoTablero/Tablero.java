/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Tablero implements Concept {
    private int dimX;
    private int dimY;

    public Tablero() {
        this.dimX = 0;
        this.dimY = 0;
    }

    public Tablero(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
    }

    @Slot(mandatory=true)
    public int getDimX() {
        return dimX;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    @Slot(mandatory=true)
    public int getDimY() {
        return dimY;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    @Override
    public String toString() {
        return "Tablero{" + "dimX=" + dimX + ", dimY=" + dimY + '}';
    }
}
