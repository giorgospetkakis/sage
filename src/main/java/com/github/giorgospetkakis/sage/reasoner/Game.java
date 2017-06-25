package com.github.giorgospetkakis.sage.reasoner;

/**
 * Internal game class for an app's data.
 * Used as a Java Bean between the ReasonerFactory and the Reasoner.
 * 
 * @author giorgospetkakis
 *
 */
public class Game {
	
	private static final String BASE_URI = "http://store.steampowered.com/app/";
	
	private String uri;
	private String id;
	private String name;
	private String[] tags;
	
	/**
	 * Basic constructor requiring just the game id.
	 * @param id
	 */
	public Game(String id) {
		this.id = id;
		this.setUri(BASE_URI + id + "/");
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
	
	/**
	 * @return the uri
	 */
	protected String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	protected void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the id
	 */
	protected String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	protected void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the tags
	 */
	protected String[] getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	protected void setTags(String[] tags) {
		this.tags = tags;
	}
}
