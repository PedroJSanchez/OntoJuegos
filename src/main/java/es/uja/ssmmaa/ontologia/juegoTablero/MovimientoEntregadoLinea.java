/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import es.uja.ssmmaa.ontologia.Vocabulario.Orientacion;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class MovimientoEntregadoLinea extends MovimientoEntregado {
    private Orientacion orientacion;

    public MovimientoEntregadoLinea() {
        super();
        
        this.orientacion = null;
    }

    public MovimientoEntregadoLinea(Partida partida, Movimiento movimiento,
                                    Orientacion orientacion) {
        super(partida, movimiento);
        
        this.orientacion = orientacion;
    }

    @Slot(mandatory=true)
    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public String toString() {
        return "MovimientoEntregadoLinea{" + "orientacion=" + orientacion + '}';
    }
}
