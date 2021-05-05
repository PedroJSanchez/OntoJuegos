/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quoridor;

import static es.uja.ssmmaa.ontologia.Vocabulario.MUROS_QUORIDOR;
import static es.uja.ssmmaa.ontologia.Vocabulario.QUORIDOR_CENTRO;
import es.uja.ssmmaa.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class Quoridor extends InfoJuego {
    private final Tablero tablero;
    private final int numJugadores;
    private final int numMuros;
    private final int centro;

    public Quoridor() {
        this.tablero = new Tablero(TipoJuego.QUORIDOR.getDimension(),
                                   TipoJuego.QUORIDOR.getDimension());
        this.numJugadores = 2;
        this.numMuros = MUROS_QUORIDOR / this.numJugadores;
        this.centro = QUORIDOR_CENTRO;
    }
    
    public Quoridor(int numJugadores) {
        this.tablero = new Tablero(TipoJuego.QUORIDOR.getDimension(),
                                   TipoJuego.QUORIDOR.getDimension());
        this.numJugadores = numJugadores;
        this.numMuros = MUROS_QUORIDOR / this.numJugadores;
        this.centro = QUORIDOR_CENTRO;
    }
    
    public int getFilas() {
        return this.tablero.getDimX();
    }
    
    public int getColumnas() {
        return this.tablero.getDimY();
    }
    
    public int getCentro() {
        return this.centro;
    }
    
    public int getNumJugadores() {
        return this.numJugadores;
    }
    
    public int getMurosJugador() {
        return this.numMuros;
    }

    @Override
    public String toString() {
        return "Quoridor{" + "tablero=" + tablero + '}';
    }
}
