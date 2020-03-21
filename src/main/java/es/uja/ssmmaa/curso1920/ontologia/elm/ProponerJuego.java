/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Modo;
import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class ProponerJuego implements AgentAction {
    private Juego juego;
    private Modo modo;
    private InfoJuego infoJuego;

    public ProponerJuego() {
        this.juego = null;
        this.modo = null;
        this.infoJuego = null;
    }

    public ProponerJuego(Juego juego, InfoJuego infoJuego) {
        this.juego = juego;
        this.infoJuego = infoJuego;
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
    public InfoJuego getInfoJuego() {
        return infoJuego;
    }

    public void setInfoJuego(InfoJuego infoJuego) {
        this.infoJuego = infoJuego;
    }

    @Override
    public String toString() {
        return "ProponerJuego{" + "juego=" + juego + ", modo=" + modo + ", infoJuego=" + infoJuego + '}';
    }
}
