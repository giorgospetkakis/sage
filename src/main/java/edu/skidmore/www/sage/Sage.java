package edu.skidmore.www.sage;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import edu.skidmore.www.sage.reasoner.ReasonerFactory;
import edu.skidmore.www.sage.reasoner.impl.Axioms;

/**
 * The main class for the SAGE Project.
 * 
 * @author giorgospetkakis
 *
 */
public class Sage 
{
	static OntModel model;
    public static void main( String[] args )
    {
    	String[] ids = {
    			"76561198289999115",
    			"76561198064924496",
    			"76561198188527799",
    			"76561197960265731",
    			"76561197960265738",
    			"76561197960265740",
    			"76561197960265747",
    			"76561197960265749",
    			"76561197960268093",
    			"76561197960269040",
    			"76561197960270258",
    			"76561197960270457",
    			"76561197960271661",
    			"76561197960273963",
    			"76561197960274006",
    			"76561197960274521",
    			"76561197960277670"
    	};
    	
    	model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);
    	Resource t = model.createResource().addProperty(Axioms.hasUserID, "76561197960279106");
    	ReasonerFactory.getInstance().addPlayer(t);
    	
    	for(String s : ids) {
    		Resource pl = model.createResource().addProperty(Axioms.hasUserID, s);
    		pl.addProperty(Axioms.hasFriend, t);
    		ReasonerFactory.getInstance().addPlayer(pl);
    	}
    	model.writeAll(System.out, "TURTLE");
    }
}
