package edu.skidmore.www.sage.reasoner;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

import edu.skidmore.www.sage.reasoner.impl.Axioms;

/**
 * The main ontology class- Holds graph information and coordinates inferencing.
 * 
 * @author giorgospetkakis
 *
 */
public class Reasoner implements RDFImport {
	
	private Model model;
	private Reasoner instance;
	private Reasoner() {
		
	}
	
	//===================================
	//Interface Methods
	//===================================
	
	public void addPlayer(Resource player) {
		// TODO Auto-generated method stub
		
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
	 * @return The singleton instance of the Reasoner
	 */
	public Reasoner getInstance(){
		if(instance != this){
			instance = this;
		}
		return instance;
	}
	
	/**
	 * Initializes the Reasoner class.
	 * 
	 */
	public void init() {
		model = ModelFactory.createDefaultModel();
		model = loadAxiomModel(model);
	}
	
	/**
	 * Returns a union of the existing model and the project axioms.
	 * 
	 * @param model
	 * @return The model union
	 */
	public Model loadAxiomModel(Model model){
		try {
			return ModelFactory.createUnion(model, Axioms.getModel());
		} catch (NullPointerException e) {
			System.err.println("Could not load axioms model");
			return model;
		}
	}
}
