/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia.quatro;

import es.uja.ssmmaa.ontologia.Vocabulario.Altura;
import es.uja.ssmmaa.ontologia.Vocabulario.Color;
import es.uja.ssmmaa.ontologia.Vocabulario.Forma;
import es.uja.ssmmaa.ontologia.Vocabulario.Relleno;
import es.uja.ssmmaa.ontologia.juegoTablero.FichaJuego;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Ficha extends FichaJuego {
    private Color color;
    private Forma forma;
    private Relleno relleno;
    private Altura altura;

    public Ficha() {
        this.color = Color.NULO;
        this.forma = Forma.NULO;
        this.relleno = Relleno.NULO;
        this.altura = Altura.NULO;
    }

    public Ficha(Color color, Forma forma, Relleno relleno, Altura altura) {
        this.color = color;
        this.forma = forma;
        this.relleno = relleno;
        this.altura = altura;
    }

    @Slot(mandatory=true)
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Slot(mandatory=true)
    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    @Slot(mandatory=true)
    public Relleno getRelleno() {
        return relleno;
    }

    public void setRelleno(Relleno relleno) {
        this.relleno = relleno;
    }

    @Slot(mandatory=true)
    public Altura getAltura() {
        return altura;
    }

    public void setAltura(Altura altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Ficha{" + "color=" + color + ", forma=" + forma + ", relleno=" 
                + relleno + ", altura=" + altura + '}';
    }
}
