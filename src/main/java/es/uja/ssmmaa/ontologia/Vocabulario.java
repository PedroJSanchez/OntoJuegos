/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia;

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
        TRES_EN_RAYA(3,3), QUORIDOR(9,9), QUATRO(4,4), ENCERRADO(8,8), TUBERIAS(13,13), CONECTA_4(6,7);

        private final int filas;
        private final int columnas;

        private TipoJuego(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
        }

        public int getFilas() {
            return filas;
        }

        public int getColumnas() {
            return columnas;
        }
    }
    public static TipoJuego[] JUEGOS = TipoJuego.values();

    // Elementos para los juegos
    public static enum Motivo {
        JUEGOS_ACTIVOS_SUPERADOS, PARTICIPACION_EN_JUEGOS_SUPERADA,
        TIPO_JUEGO_NO_IMPLEMENTADO, DEMASIADOS_JUEGOS_SIN_COMPLETAR, SUPERADO_LIMITE_PARTIDAS,
        SUBSCRIPCION_ACEPTADA, ERROR_SUBSCRIPCION, ERROR_CANCELACION, ONTOLOGIA_DESCONOCIDA
    }

    public static enum Incidencia {
        CANCELADO, JUGADORES_INSUFICIENTES,
        ERROR_AGENTE, ERROR_MENSAJE_INCORRECTO, ERROR_CONTENIDO_MENSAJE,
    }

    public static enum Estado {
        GANADOR, ABANDONO, SEGUIR_JUGANDO, FIN_PARTIDA, JUGADOR_NO_ACTIVO
    }

    public static enum Modo {
        UNICO, ELIMINATORIA, TORNEO
    }

    public static enum Color {
        BLANCO, NEGRO, AZUL, ROJO, VERDE, NULO
    }

    public static enum Forma {
        REDONDO, CUADRADO, NULO
    }

    public static enum Relleno {
        SOLIDO, HUECO, NULO
    }

    public static enum Altura {
        BAJO, ALTO, NULO
    }

    public static enum Orientacion {
        HORIZONTAL, VERTICAL
    }

    public static enum Version {
        NORMAL, AVANZADA
    }
    public static final int POSICION_NULA = -1;
    public static final int QUATRO_NUM_FICHAS = 16;
    public static final int MUROS_QUORIDOR = 20;
    public static final int QUORIDOR_CENTRO = 5; // Posición central de partida

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
    public static Ontology getOntology(TipoJuego tipoJuego) throws BeanOntologyException {
        Ontology resultado = null;

        switch (tipoJuego) {
            case TRES_EN_RAYA:
                resultado = OntoTresEnRaya.getInstance();
                break;
            case QUORIDOR:
                resultado = OntoQuoridor.getInstance();
                break;
            case QUATRO:
                resultado = OntoQuatro.getInstance();
                break;
            case ENCERRADO:
                resultado = OntoEncerrado.getInstance();
                break;
            case TUBERIAS:
                resultado = OntoTuberias.getInstance();
                break;
            case CONECTA_4:
                resultado = OntoConecta4.getInstance();
                break;
            default:
                resultado = OntoJuegoTablero.getInstance();
                break;
        }

        return resultado;
    }
}
