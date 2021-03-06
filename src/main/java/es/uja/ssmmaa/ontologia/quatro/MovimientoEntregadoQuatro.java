/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quatro;

import es.uja.ssmmaa.ontologia.Vocabulario.Estado;
import es.uja.ssmmaa.ontologia.juegoTablero.Movimiento;
import es.uja.ssmmaa.ontologia.juegoTablero.MovimientoEntregado;
import es.uja.ssmmaa.ontologia.juegoTablero.Partida;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class MovimientoEntregadoQuatro extends MovimientoEntregado {
    private Estado estadoPartida; 

    public MovimientoEntregadoQuatro() {
        super();
        
        this.estadoPartida = null;
    }

    public MovimientoEntregadoQuatro(Partida partida, Movimiento movimiento,
                                                      Estado estadoPartida) {
        super(partida, movimiento);
        
        this.estadoPartida = estadoPartida;
    }

    @Slot(mandatory=true)
    public Estado getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(Estado estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    @Override
    public String toString() {
        return "MovimientoEntregadoQuatro{" + "estadoPartida=" + estadoPartida + '}';
    }
}
