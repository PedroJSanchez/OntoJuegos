/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Modo;
import jade.content.AgentAction;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class ProponerJuego implements AgentAction {
    private Juego juego;
    private Modo modo;
    private Concept tipoJuego;

    public ProponerJuego() {
        this.juego = null;
        this.modo = null;
        this.tipoJuego = null;
    }

    public ProponerJuego(Juego juego, Concept tipoJuego) {
        this.juego = juego;
        this.tipoJuego = tipoJuego;
    }

    @Slot(mandatory = true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory=true)
    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    @Slot(mandatory=true)
    public Concept getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(Concept tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    @Override
    public String toString() {
        return "ProponerJuego{" + "juego=" + juego + ", modo=" + modo + ", tipoJuego=" + tipoJuego + '}';
    }
}
