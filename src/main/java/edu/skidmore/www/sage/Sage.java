package edu.skidmore.www.sage;

import org.apache.jena.ontology.OntModel;

import edu.skidmore.www.sage.reasoner.impl.Reasoner;

/**
 * The main class for the SAGE project.
 * 
 * @author giorgospetkakis
 *
 */
public class Sage 
{
	static OntModel model;
    public static void main( String[] args )
    {
    	model = Reasoner.getInstance().getModel();
    	PrintWriter.
    }
}
