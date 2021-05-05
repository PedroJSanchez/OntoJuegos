/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.juegoTablero;

import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class ResultadoPartida extends SubInform {
    private Partida partida;
    private Jugador ganador;

    public ResultadoPartida() {
        this.partida = null;
        this.ganador = null;
    }

    public ResultadoPartida(Partida partida, Jugador ganador) {
        this.partida = partida;
        this.ganador = ganador;
    }

    @Slot(mandatory=true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory=false)
    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        String result = "Resultado{" + "partida= " + partida;
        
        if( ganador == null )
            result += " JUEGO EMPATADO }";
        else
            result += ", ganador=" + ganador + '}';
                    
        return  result;
    }
}
