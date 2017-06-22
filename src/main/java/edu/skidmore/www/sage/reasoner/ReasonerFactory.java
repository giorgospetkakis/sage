package edu.skidmore.www.sage.reasoner;

import org.apache.jena.rdf.model.Resource;

import edu.skidmore.www.sage.reasoner.impl.Reasoner;

/**
 * Factory for the reasoner class. Recommended way to add data to the ontology.
 * 
 * @author giorgospetkakis
 *
 */
public class ReasonerFactory implements RDFImport {
	
	protected static ReasonerFactory instance;
	protected ReasonerFactory(){}
	
	static {
		instance = new ReasonerFactory();
	}
	
	public static ReasonerFactory getInstance(){
		return instance;
	}

	public void addPlayer(Resource player) {
		Reasoner.getInstance().addPlayer(player);
	}

	public void addFriends(Resource player, Resource[] friends) {
		Reasoner.getInstance().addFriends(player, friends);	
	}

	public void addOwnedGames(Resource player, Resource[] games) {
		Reasoner.getInstance().addOwnedGames(player, games);
	}
}
