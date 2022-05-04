/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.encerrado;

import es.uja.ssmmaa.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class Encerrado extends InfoJuego {
    private final Tablero tablero;
    private final int numJugadores;

    public Encerrado() {
        this.tablero = new Tablero(TipoJuego.ENCERRADO.getFilas(),
                                   TipoJuego.ENCERRADO.getColumnas());
        this.numJugadores = 2;
    }

    public Encerrado(int numJugadores) {
        this.tablero = new Tablero(TipoJuego.ENCERRADO.getFilas(),
                                   TipoJuego.ENCERRADO.getColumnas());
        this.numJugadores = numJugadores;
    }

    public Encerrado(Tablero tablero, int numJugadores) {
        this.tablero = tablero;
        this.numJugadores = numJugadores;
    }
    
    public Encerrado(int filas, int columnas, int numJugadores) {
        this.tablero = new Tablero(filas,columnas);
        this.numJugadores = numJugadores;
    }
    
    public int getFilas() {
        return tablero.getDimX();
    }
    
    public int getColumnas() {
        return tablero.getDimY();
    }
    
    public int getNumJugadores() {
        return this.numJugadores;
    }

    @Override
    public String toString() {
        return "Encerrado{" + "tablero=" + tablero + ", numJugadores=" + numJugadores + '}';
    }
}
