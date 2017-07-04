package com.github.giorgospetkakis.steam2rdf.reasoner;

import org.apache.jena.ontology.OntModelSpec;

import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;
import com.github.koraktor.steamcondenser.scraper.SteamUserDefinedTag;

/**
 * A public factory for the Reasoner.
 * Recommended way of adding nodes to the ontology
 * 
 * @author giorgospetkakis
 *
 */
public class ReasonerFactory {
	/**
	 * The default reasoning specification.
	 */
	private final static OntModelSpec DEFAULT_SPEC = OntModelSpec.OWL_DL_MEM;
	
	/**
	 * The Reasoner instance that corresponds to this instance.
	 * of the factory.
	 */
	private Reasoner theReasoner;

	/**
	 * A public factory for the Reasoner.
	 * Allows entry of ontology data into the internal ontology model
	 * 
	 * @param spec The reasoning specification for this reasoner
	 */
	public ReasonerFactory(OntModelSpec spec) {
		theReasoner = new Reasoner(spec);
	}
	/**
	 * Default constructor for the Reasoner public factory.
	 * Allows entry of ontology data into the internal ontology model
	 */
	public ReasonerFactory() {
		theReasoner = new Reasoner(DEFAULT_SPEC);
	}
	/**
	 * Adds a player to the ontology.
	 * @param player The player to be added
	 */
	public void addPlayer(SteamId player) {
		theReasoner.addPlayer(player); 
	}
	/**
	 * Adds a player array to the ontology.
	 * @param players The players to be added
	 */
	public void addPlayers(SteamId[] players) {
		for(SteamId p : players) {
			theReasoner.addPlayer(p); 
		}
	}
	/**
	 * Adds a game to the ontology.
	 * @param game The game to be added
	 */
	public void addGame(SteamGame game){
		theReasoner.addGame(game);
	}
	/**
	 * Adds a game array to the ontology.
	 * @param games The games to be added
	 */
	public void addGames(SteamGame[] games) {
		for(SteamGame g : games){
			theReasoner.addGame(g); 
		}
	}
	/**
	 * Adds a user-defined tag to the ontology.
	 * @param tag The tag to be added
	 */
	public void addTag(SteamUserDefinedTag tag) {
		theReasoner.addTag(tag);
	}
	/**
	 * Adds a user-defined tag array to the ontology.
	 * @param tags The tag array to be added
	 */
	public void addTags(SteamUserDefinedTag[] tags){
		for(SteamUserDefinedTag t : tags){
			theReasoner.addTag(t);
		}
	}
}
