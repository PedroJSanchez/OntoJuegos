/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quatro;

import es.uja.ssmmaa.ontologia.juegoTablero.Jugador;
import es.uja.ssmmaa.ontologia.juegoTablero.Movimiento;
import es.uja.ssmmaa.ontologia.juegoTablero.Partida;
import es.uja.ssmmaa.ontologia.juegoTablero.PedirMovimiento;

/**
 *
 * @author pedroj
 */
public class PedirMovimientoQuatro extends PedirMovimiento {
    private Movimiento movAnterior;

    public PedirMovimientoQuatro() {
        super();
        
        this.movAnterior = null;
    }

    public PedirMovimientoQuatro(Partida partida, Jugador jugadorActivo,
                                                  Movimiento movAnterior) {
        super(partida, jugadorActivo);
        
        this.movAnterior = movAnterior;
    }

    public Movimiento getMovAnterior() {
        return movAnterior;
    }

    public void setMovAnterior(Movimiento movAnterior) {
        this.movAnterior = movAnterior;
    }

    @Override
    public String toString() {
        return "PedirMovimientoQuatro{" + "movimientoAnterior=" + movAnterior + '}';
    }
}
