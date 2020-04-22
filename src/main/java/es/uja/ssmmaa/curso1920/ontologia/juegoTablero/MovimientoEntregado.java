/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class MovimientoEntregado implements Predicate {
    private Partida partida;
    private Movimiento movimiento;

    public MovimientoEntregado() {
        this.partida = null;
        this.movimiento = null;
    }

    public MovimientoEntregado(Partida partida, Movimiento movimiento) {
        this.partida = partida;
        this.movimiento = movimiento;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory=true)
    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return "MovimientoEntregado{" + "partida=" + partida + ", movimiento=" + movimiento + '}';
    }
}
