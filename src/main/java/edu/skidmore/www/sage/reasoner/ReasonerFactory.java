package edu.skidmore.www.sage.reasoner;

/**
 * Factory for the reasoner class. Recommended way to add data to the ontology.
 * 
 * @author giorgospetkakis
 *
 */
public class ReasonerFactory implements RDFImport {
	
	public ReasonerFactory() {
		
	}
	
	public void addPlayer(Player player) 
	{ Reasoner.getInstance().addPlayer(player); }
	
	public void addFriends(Player player, Player[] friends) 
	{ Reasoner.getInstance().addFriends(player, friends); }
	
	public void addOwnedGames(Player player, Game[] games) 
	{ Reasoner.getInstance().addOwnedGames(player, games); }
	
	public void writeAll()
	{ Reasoner.getInstance().writeAll(); }
}
