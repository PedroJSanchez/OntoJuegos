/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class InformarJuego implements AgentAction {
    private Organizador organizador;

    public InformarJuego() {
        this.organizador = null;
    }

    public InformarJuego(Organizador organizador) {
        this.organizador = organizador;
    }

    @Slot(mandatory=true)
    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public String toString() {
        return "InformarJuego{" + "organizador=" + organizador + '}';
    }
}
