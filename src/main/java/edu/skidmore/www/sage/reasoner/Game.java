package edu.skidmore.www.sage.reasoner;

/**
 * Internal game class for an app's data.
 * Used as a Java Bean between the ReasonerFactory and the Reasoner.
 * 
 * @author giorgospetkakis
 *
 */
public class Game {
	
	private String id;
	private String name;
	private String[] tags;
	
	/**
	 * Basic constructor requiring just the game id.
	 * @param id
	 */
	public Game(String id) {
		this.id = id;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	/**
	 * Use game ids to generate game array.
	 * 
	 * @param ids
	 * @return
	 */
	public static Game[] toGameArray(String [] ids) {
		Game[] games = new Game[ids.length];
		for(int i = 0; i < games.length; i++) {
			games[i] = new Game(ids[i]);
		}
		return games;
	}
}
