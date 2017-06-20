package edu.skidmore.www.sage.reasoner;

import org.apache.jena.rdf.model.Resource;

/**
 * An interface for importing the player / game ontology onto the reasoner platform.
 * 
 * @author giorgospetkakis
 *
 */
public interface RDFImport {
	
	/**
	 * Adds a player to the graph.
	 * 
	 * @param player
	 */
	public void addPlayer(Resource player);
	
	/**
	 * Adds a list of friends to a player.
	 * 
	 * @param friends
	 */
	public void addFriends(Resource player, Resource[] friends);
	
	/**
	 * Adds a list of owned games to a player.
	 * 
	 * @param games
	 */
	public void addOwnedGames(Resource player, Resource[] games);
}
