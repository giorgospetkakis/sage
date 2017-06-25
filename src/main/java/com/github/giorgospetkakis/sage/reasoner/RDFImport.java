package com.github.giorgospetkakis.sage.reasoner;

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
	public void addPlayer(Player player);
	
	/**
	 * Adds a list of friends to a player.
	 * 
	 * @param player
	 * @param friends
	 */
	public void addFriends(Player player, Player[] friends);
	
	/**
	 * Adds a list of owned games to a player.
	 * 
	 * @param player
	 * @param games
	 */
	public void addOwnedGames(Player player, Game[] games);
}
