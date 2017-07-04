package com.github.giorgospetkakis.steam2rdf.reasoner;

import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;

/**
 * An interface for importing the player / game beans onto the reasoner platform.
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
	public void addPlayer(SteamId player);
	
	public void addGame(SteamGame game);
}
