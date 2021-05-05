/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.tresEnRaya;

import es.uja.ssmmaa.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class TresEnRaya extends InfoJuego {
    private final Tablero tablero;

    public TresEnRaya() {
        this.tablero = new Tablero(TipoJuego.TRES_EN_RAYA.getDimension(),
                                   TipoJuego.TRES_EN_RAYA.getDimension());
    }
    
    public int getFilas() {
        return tablero.getDimX();
    }
    
    public int getColumnas() {
        return tablero.getDimY();
    }

    @Override
    public String toString() {
        return "TresEnRaya{" + "tablero=" + tablero + '}';
    }
}
