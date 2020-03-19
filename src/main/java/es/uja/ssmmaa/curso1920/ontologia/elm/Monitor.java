/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;
import jade.core.AID;

/**
 *
 * @author pedroj
 */
public class Monitor implements Concept {
    private String nombre;
    private AID agenteMonitor;

    public Monitor() {
        this.nombre = null;
        this.agenteMonitor = null;
    }
    
    public Monitor(String nombre, AID agenteMonitor) {
        this.nombre = nombre;
        this.agenteMonitor = agenteMonitor;
    }

    @Slot(mandatory=true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Slot(mandatory=true)
    public AID getAgenteMonitor() {
        return agenteMonitor;
    }

    public void setAgenteMonitor(AID agenteMonitor) {
        this.agenteMonitor = agenteMonitor;
    }
    
    @Override
    public String toString() {
        return "Monitor{" + "nombre=" + nombre + '}';
    }
}
