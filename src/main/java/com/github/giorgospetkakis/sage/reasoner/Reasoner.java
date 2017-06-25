package com.github.giorgospetkakis.sage.reasoner;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.apache.log4j.Logger;

import com.github.giorgospetkakis.sage.reasoner.impl.Axioms;

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
		model.createResource(player.getUri()).addProperty(Axioms.hasUserID, player.getId());
	}

	protected void addFriends(Player player, Player[] friends) {
		Resource pl = model.createResource(player.getUri());
		for(Player p : friends) {
			Resource f = model.createResource(p.getUri());
			pl.addProperty(Axioms.hasFriend, f);
		}
	}

	protected void addOwnedGames(Player player, Game[] games) {
		Resource pl = model.createResource(player.getUri());
		for(Game g : games) {
			Resource gameR = model.createResource(g.getUri());
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
	 * Handles loading the Axiom Model.
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
