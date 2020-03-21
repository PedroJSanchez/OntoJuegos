/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.Quatro;

import es.uja.ssmmaa.curso1920.ontologia.elm.Partida;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class FichaEntregada implements Predicate {
    private Partida partida;
    private Ficha ficha;

    public FichaEntregada() {
        this.partida = null;
        this.ficha = null;
    }

    public FichaEntregada(Partida partida, Ficha ficha) {
        this.partida = partida;
        this.ficha = ficha;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory=true)
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public String toString() {
        return "FichaEntregada{" + "partida=" + partida + ", ficha=" + ficha + '}';
    }
}
