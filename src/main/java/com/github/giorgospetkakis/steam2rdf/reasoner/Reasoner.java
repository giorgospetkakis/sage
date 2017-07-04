package com.github.giorgospetkakis.steam2rdf.reasoner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.apache.log4j.Logger;

import com.github.giorgospetkakis.steam2rdf.reasoner.impl.Axioms;
import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;
import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;

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
	
	protected OntModel model;
	
	//Logger
	Logger logger = Logger.getLogger(Reasoner.class);
	
	//===================================
	//Constructors
	//===================================
	
	protected Reasoner() {
		model = loadAxiomModel();
	}
	
	//===================================
	//Interface Methods
	//===================================
	
	/**
	 * Adds a player to the ontology.
	 * 
	 * @param player The player to be added.
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
		
		//Add Game List
		try {
			for(SteamGame s : player.getGames().values())
				p.addProperty(Axioms.owns, model.createResource(s.getStoreUrl()));
		} catch (SteamCondenserException e) {
			logger.error("Could not load friends for" + p.getURI());
		}
	}
	
	
	protected void addGame(SteamGame game) {
		
	}
	
	/**
	 * Write the model ontology to the console.
	 */
	protected void writeAll() {
		model.writeAll(System.out, "TURTLE");
	}
	
	/**
	 * Write the model ontology to the console, without assertions.
	 */
	protected void write() {
		model.write(System.out, "TURTLE");
	}
	
	/**
	 * Export the ontology to the specified file.
	 * @throws FileNotFoundException
	 */
	protected void export(String file) throws FileNotFoundException {
		FileOutputStream out = new FileOutputStream(file);
		System.setOut(new PrintStream(out));
		
		model.writeAll(System.out, "TURTLE");
	}
	
	//===================================
	//Internal Methods
	//===================================
	
	/**
	 * 
	 * @return The model of the of the current Reasoner.
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
			return null;
		}
	}
}
