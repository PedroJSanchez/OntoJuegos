/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.tresEnRaya;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.curso1920.ontologia.elm.Tablero;
import jade.content.Concept;

/**
 *
 * @author pedroj
 */
public class TresEnRaya implements Concept {
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
