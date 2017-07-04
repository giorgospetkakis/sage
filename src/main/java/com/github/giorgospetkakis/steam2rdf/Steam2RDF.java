package com.github.giorgospetkakis.steam2rdf;

import org.apache.jena.ontology.OntModelSpec;

import com.github.giorgospetkakis.steam2rdf.reasoner.ReasonerFactory;
import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;
import com.github.koraktor.steamcondenser.scraper.SteamUserDefinedTag;

/**
 * The main class for the SAGE Project.
 * 
 * @author giorgospetkakis
 *
 */
public abstract class Steam2RDF
{
	/**
	 * The ontology model used to make inferences.
	 */
	private ReasonerFactory reasonerFactory;
	
	/**
	 * TODO
	 */
	public Steam2RDF(){
		reasonerFactory = new ReasonerFactory();
	}
	/**
	 * TODO
	 */
	public Steam2RDF(OntModelSpec spec){
		reasonerFactory = new ReasonerFactory(spec);
	}
	/**
	 * Adds the specified players to the ontology.
	 * @param players The players to be added
	 */
	public void addPlayers(SteamId[] players){
		reasonerFactory.addPlayers(players);
	}
	/**
	 * Adds the specified players to the ontology.
	 * @param games The games to be added
	 */
	public void addGames(SteamGame[] games){
		reasonerFactory.addGames(games);
	}
	/**
	 * Adds the specified tags to the ontology.
	 * @param tags The tags to be added
	 */
	public void addUserTags(SteamUserDefinedTag[] tags){
		reasonerFactory.addTags(tags);
	}
}
