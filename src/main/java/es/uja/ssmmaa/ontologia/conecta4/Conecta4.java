/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.conecta4;

import es.uja.ssmmaa.ontologia.Vocabulario.TipoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.InfoJuego;
import es.uja.ssmmaa.ontologia.juegoTablero.Tablero;

/**
 *
 * @author pedroj
 */
public class Conecta4 extends InfoJuego {
    private final Tablero tablero;

    public Conecta4() {
        this.tablero = new Tablero(TipoJuego.CONECTA_4.getFilas(),
                                   TipoJuego.CONECTA_4.getColumnas());
    }
    
    public Conecta4(int filas, int columnas) {
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
        return "Conecta4{" + "tablero=" + tablero + '}';
    }
}
