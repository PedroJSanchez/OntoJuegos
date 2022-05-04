/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.tuberias;

import es.uja.ssmmaa.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class Tuberias extends InfoJuego {
    private final Tablero tablero;

    public Tuberias() {
        this.tablero = new Tablero(TipoJuego.TUBERIAS.getFilas(),
                TipoJuego.TUBERIAS.getColumnas());
    }
    
    public Tuberias(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public Tuberias(int filas, int columnas) {
        this.tablero = new Tablero(filas,columnas);
    }

    public int getFilas() {
        return tablero.getDimX();
    }
    
    public int getColumnas() {
        return tablero.getDimY();
    }

    @Override
    public String toString() {
        return "Tuberias{" + "tablero=" + tablero + '}';
    }
}
