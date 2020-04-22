/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.quatro;

import static es.uja.ssmmaa.curso1920.ontologia.Vocabulario.QUATRO_NUM_FICHAS;
import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Version;
import static es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Version.NORMAL;
import es.uja.ssmmaa.curso1920.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.curso1920.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class Quatro extends InfoJuego {
    private final Tablero tablero;
    private final Version version;
    private final int numFichas;

    public Quatro() {
        this.tablero = new Tablero(TipoJuego.QUATRO.getDimension(),
                                   TipoJuego.QUATRO.getDimension());
        this.version = NORMAL;
        this.numFichas = QUATRO_NUM_FICHAS;
    }
    
    public Quatro(Version version) {
        this.tablero = new Tablero(TipoJuego.QUATRO.getDimension(),
                                   TipoJuego.QUATRO.getDimension());
        this.version = version;
        this.numFichas = QUATRO_NUM_FICHAS;
    }
    
    public int getFilas() {
        return tablero.getDimX();
    }
    
    public int getColumnas() {
        return tablero.getDimY();
    }
    
    public Version getVersion() {
        return this.version;
    }
    
    public int getNumFichas() {
        return this.numFichas;
    }

    @Override
    public String toString() {
        return "Quatro!{" + "tablero=" + tablero + '}';
    }
}
