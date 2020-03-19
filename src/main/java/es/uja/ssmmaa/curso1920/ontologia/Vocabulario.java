/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia;

import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;

/**
 *
 * @author pedroj
 */
public interface Vocabulario {
    // Registro en las páginas Amarillas
    public static enum TipoServicio {
        JUGADOR, TABLERO, ORGANIZADOR
    }
    public static TipoServicio[] TIPOS_SERVICIO = TipoServicio.values();
    
    public static enum TipoJuego { 
        TRES_EN_RAYA(3), QUORIDOR(9), QUATRO(4);
        
        private final int dimTablero;

        private TipoJuego(int dimTablero) {
            this.dimTablero = dimTablero;
        }
        
        /**
         * Dimensión del tablero para el juego. Todos los juegos tienen un
         * tablero cuadrado.
         * @return 
         *      número de filas y columnas
         */
        public int getDimension() {
            return dimTablero;
        }
    }
    public static TipoJuego[] JUEGOS = TipoJuego.values();
    
    // Elementos para los juegos
    public static enum Motivo { 
        JUEGOS_ACTIVOS_SUPERADOS, PARTICIPACION_EN_JUEGOS_SUPERADA, 
        TIPO_JUEGO_NO_IMPLEMENTADO, DEMASIADOS_JUEGOS_SIN_COMPLETAR
    }
    
    public static enum Incidencia {
        CANCELACION, ERROR_AGENTE, ERROR_MENSAJE_INCORRECTO, ERROR_CONTENIDO_MENSAJE
    }
    
    public static enum Estado {
        GANADOR, ABANDONO, SEGUIR_JUGANDO, FIN_PARTIDA
    }
    
    public static enum Modo { UNICO, ELIMINATORIA, TORNEO }
    public static enum Color { BLANCO, NEGRO }
    public static enum Forma { REDONDO, CUADRADO }
    public static enum Relleno { SOLIDO, HUECO }
    public static enum Altura { BAJO, ALTO }
    public static enum Orientacion { HORIZONTAL, VERTICAL }
    public static final int POSICION_NULA = -1;
    public static final int FICHAS_QUATRO = 16;
    public static final int MUROS_QUORIDOR = 20;
    
    public static enum Puntuacion {
        VICTORIA(3), EMPATE(1), DERROTA(0);
        
        private final int valor;

        public int getValor() {
            return valor;
        }

        private Puntuacion(int valor) {
            this.valor = valor;
        }
    }
    
    // Métodos
    public static Ontology getOntologia( TipoJuego tipoJuego ) throws BeanOntologyException {
        Ontology resultado = null;
        
        switch ( tipoJuego ) {
            case TRES_EN_RAYA:
                // resultado = OntoTresEnRaya.getInstance();
                break;
            case QUORIDOR:
                //resultado = OntoQuoridor.getInstance();
                break;
            case QUATRO:
                //resultado = OntoQuatro.getInstance();
                break;
            default:
                resultado = OntoJuegoTablero.getInstance();
                break;
        }
        
        return resultado;
    }
}
