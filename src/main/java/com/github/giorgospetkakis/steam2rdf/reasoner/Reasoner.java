package com.github.giorgospetkakis.steam2rdf.reasoner;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.log4j.Logger;

import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;
import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.scraper.SteamUserDefinedTag;

/**
 * The main ontology class- Holds graph information and coordinates inferencing.
 * 
 * @author giorgospetkakis
 *
 */
public class Reasoner {
	/**
	 * The base Ontology model of the Reasoner instance.
	 */
	protected OntModel model;
	
	private static Logger logger = Logger.getLogger(Reasoner.class);
	/**
	 * Internal constructor called by the factory.
	 * Initializes the model
	 * @param spec The user-defined specification
	 */
	protected Reasoner(OntModelSpec spec) {
		OntModel baseModel = ModelFactory.createOntologyModel(spec);
		model = (OntModel) baseModel.union(Axioms.getAxiomModel());
	}
	
	/**
	 * Adds a player to the ontology.
	 * @param player The player to be added
	 */
	protected void addPlayer(SteamId player) {
		//Add basic player info
		Resource p = 
				model.createResource(
					player.getBaseUrl())
						.addProperty(Axioms.hasUserID, player.getId().toString())
						.addProperty(Axioms.hasNickname, player.getNickname())
						.addProperty(Axioms.hasFullName, player.getRealName())
		;
		
		//Add Friends List
		try {
			for(SteamId s : player.getFriends())
				p.addProperty(Axioms.hasFriend, model.createResource(s.getBaseUrl()));
		} catch (SteamCondenserException e) {
			logger.error("Could not load friends for" + p.getURI());
		}
		
		//Add Games List
		try {
			for(SteamGame s : player.getGames().values())
				p.addProperty(Axioms.owns, model.createResource(s.getStoreUrl()));
		} catch (SteamCondenserException e) {
			logger.error("Could not load friends for" + p.getURI());
		}
	}
	
	/**
	 * Adds a game to the ontology.
	 * @param game The game to be added
	 */
	protected void addGame(SteamGame game) {
		
	}
	
	/**
	 * Adds a tag to the ontology.
	 * @param tag The tag to be added
	 */
	protected void addTag(SteamUserDefinedTag tag) {
		
	}
}
