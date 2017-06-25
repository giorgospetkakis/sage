package edu.skidmore.www.sage.reasoner;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.log4j.Logger;

import edu.skidmore.www.sage.reasoner.impl.Axioms;

/**
 * The main ontology class- Holds graph information and coordinates inferencing.
 * 
 * @author giorgospetkakis
 *
 */
public class Reasoner {
	
	//===================================
	//Class variables
	//===================================
	
	private static OntModel model;
	private static Reasoner instance;
	private static final String NS = "steamOnt:";
	
	//Logger
	Logger logger = Logger.getLogger(Reasoner.class);
	
	static {
		instance = new Reasoner();
		model = loadAxiomModel();
	}
	
	//===================================
	//Interface Methods
	//===================================
	
	protected void addPlayer(Player player) {
		model.createResource(NS + player.getId()).addProperty(Axioms.hasUserID, player.getId());
	}

	protected void addFriends(Player player, Player[] friends) {
		Resource pl = model.createResource(NS + player.getId());
		for(Player p : friends) {
			Resource f = model.createResource(NS + p.getId());
			pl.addProperty(Axioms.hasFriend, f);
		}
	}

	protected void addOwnedGames(Player player, Game[] games) {
		Resource pl = model.createResource(NS + player.getId());
		for(Game g : games) {
			Resource gameR = model.createResource(NS + g.getId());
			pl.addProperty(Axioms.owns, gameR);
		}
	}
	
	protected void writeAll() {
		model.writeAll(System.out, "TURTLE");
	}
	
	//===================================
	//Internal Methods
	//===================================
	
	/**
	 * 
	 * @return The singleton instance of the Reasoner.
	 */
	protected static Reasoner getInstance(){
		return instance;
	}
	
	/**
	 * 
	 * @return The model of the of the Reasoner.
	 */
	protected OntModel getModel(){
		return model;
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
			System.err.println("Could not load axiom model");
			return model;
		}
	}
}
