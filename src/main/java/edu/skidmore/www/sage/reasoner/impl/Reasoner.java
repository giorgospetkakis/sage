package edu.skidmore.www.sage.reasoner.impl;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import edu.skidmore.www.sage.reasoner.RDFImport;

/**
 * The main ontology class- Holds graph information and coordinates inferencing.
 * 
 * @author giorgospetkakis
 *
 */
public class Reasoner {
	
	private static OntModel model;
	private static Reasoner instance;
	private Reasoner() {
		
	}
	
	static {
		init();
	}
	
	//===================================
	//Interface Methods
	//===================================
	
	public void addPlayer(Resource player) {
		
	}

	public void addFriends(Resource player, Resource[] friends) {
		// TODO Auto-generated method stub
		
	}

	public void addOwnedGames(Resource player, Resource[] games) {
		// TODO Auto-generated method stub
		
	}
	
	//===================================
	//Internal Methods
	//===================================
	
	/**
	 * 
	 * @return The singleton instance of the Reasoner.
	 */
	public static Reasoner getInstance(){
		return instance;
	}
	
	/**
	 * 
	 * @return The model of the of the Reasoner.
	 */
	public OntModel getModel(){
		return model;
	}
	
	/**
	 * Initializes the Reasoner class.
	 * 
	 */
	private static void init() {
		instance = new Reasoner();
		model = loadAxiomModel();
	}
	
	/**
	 * Returns a union of the existing model and the project axioms.
	 * 
	 * @param model
	 * @return The model union
	 */
	private static OntModel loadAxiomModel(){
		try {
			return Axioms.getModel();
		} catch (NullPointerException e) {
			System.err.println("Could not load axioms model");
			return model;
		}
	}
}
