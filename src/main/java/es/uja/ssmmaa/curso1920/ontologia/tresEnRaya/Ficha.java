/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.curso1920.ontologia.tresEnRaya;

import es.uja.ssmmaa.curso1920.ontologia.Vocabulario.Color;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

/**
 *
 * @author pedroj
 */
public class Ficha implements Concept {
    private Color color;

    public Ficha() {
        this.color = null;
    }

    public Ficha(Color color) {
        this.color = color;
    }

    @Slot(mandatory=true)
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ficha{" + "color=" + color + '}';
    }
}
