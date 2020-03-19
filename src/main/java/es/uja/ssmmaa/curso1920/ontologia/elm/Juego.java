/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.elm;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.TipoJuego;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Juego implements Concept {
    private String idJuego;
    private TipoJuego tipoJuego;
    

    public Juego() {
        this.idJuego = null;
        this.tipoJuego = null;
    }

    public Juego(String idJuego, TipoJuego tipoJuego) {
        this.idJuego = idJuego;
        this.tipoJuego = tipoJuego;
    }
    
    @Slot(mandatory=true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory=true)
    public TipoJuego getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idJuego + ", tipoJuego=" + tipoJuego + '}';
    }
}
