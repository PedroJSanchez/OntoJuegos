/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssmmaa.ontologia;

import jade.content.onto.BeanOntology;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;

/**
 *
 * @author pedroj
 */
public class OntoQuoridor extends BeanOntology {
    private static final long serialVersionUID = 1L;
    
    // NOMBRE
    public static final String ONTOLOGY_NAME = "Ontologia_Quoridor";
    
    // The singleton instance of this ontology
    private static Ontology INSTANCE;
    
    public synchronized final static Ontology getInstance() throws BeanOntologyException {
        
        if (INSTANCE == null) {
            INSTANCE = new OntoQuoridor();
	}
            
        return INSTANCE;
    }

    /**
     * Constructor
     * 
     * @throws BeanOntologyException
     */
    private OntoQuoridor() throws BeanOntologyException {
	
        super(ONTOLOGY_NAME, OntoJuegoTablero.getInstance());
        
        add("es.uja.ssmmaa.ontologia.quoridor");
    }
}
