/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.juegoTablero;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class InformarResultado implements AgentAction {
    private AgenteJuego agenteJuego;

    public InformarResultado() {
        this.agenteJuego = null;
    }

    public InformarResultado(AgenteJuego agenteJuego) {
        this.agenteJuego = agenteJuego;
    }

    @Slot(mandatory=true)
    public AgenteJuego getAgente() {
        return agenteJuego;
    }

    public void setAgente(AgenteJuego agenteJuego) {
        this.agenteJuego = agenteJuego;
    }

    @Override
    public String toString() {
        return "InformarResultado{" + "agente=" + agenteJuego + '}';
    }
}
