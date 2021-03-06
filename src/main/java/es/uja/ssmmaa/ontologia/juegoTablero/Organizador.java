/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.onto.annotations.Slot;
import jade.core.AID;

/**
 *
 * @author pedroj
 */
public class Organizador extends AgenteJuego {
    private String nombre;
    private AID agenteOrganizador;

    public Organizador() {
        this.nombre = null;
        this.agenteOrganizador = null;
    }

    public Organizador(String nombre, AID agenteOrganizador) {
        this.nombre = nombre;
        this.agenteOrganizador = agenteOrganizador;
    }

    @Slot(mandatory=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Slot(mandatory=true)
    public AID getAgenteOrganizador() {
        return agenteOrganizador;
    }

    public void setAgenteOrganizador(AID agenteOrganizador) {
        this.agenteOrganizador = agenteOrganizador;
    }

    @Override
    public String toString() {
        return "Organizador{" + "nombre=" + nombre + '}';
    }
}
