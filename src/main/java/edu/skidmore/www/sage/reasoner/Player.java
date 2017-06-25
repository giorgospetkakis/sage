package edu.skidmore.www.sage.reasoner;

/**
 * Internal wrapper class for a single player's data.
 * Used as a Java Bean between the ReasonerFactory and the Reasoner.
 * 
 * @author giorgospetkakis
 *
 */
public class Player {
	
	private String id;
	private String firstName;
	private String lastName;
	private String nickName;
	private String[] gamesOwned;
	private String[] friends;
	
	/**
	 * Creates a new player object. Used for internal data processing only.
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param nickName
	 * @param gamesOwned
	 * @param friends
	 */
	public Player(String id, String firstName, String lastName, String nickName, String[] gamesOwned, String[] friends){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.gamesOwned = gamesOwned;
		this.friends = friends;
	}
	
	/**
	 * Creates new player object using only the player id.
	 * 
	 * @param id
	 */
	public Player(String id){
		this.id = id;
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
	 * @return the firstName
	 */
	protected String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	protected String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the nickName
	 */
	protected String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	protected void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the gamesOwned
	 */
	protected String[] getGamesOwned() {
		return gamesOwned;
	}
	/**
	 * @param gamesOwned the gamesOwned to set
	 */
	protected void setGamesOwned(String[] gamesOwned) {
		this.gamesOwned = gamesOwned;
	}
	/**
	 * @return the friends
	 */
	protected String[] getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	protected void setFriends(String[] friends) {
		this.friends = friends;
	}
	
	/**
	 * Use player ids to generate player array.
	 * 
	 * @param ids
	 * @return
	 */
	public static Player[] toPlayerArray(String[] ids) {
		Player[] ps = new Player[ids.length];
		for(int i = 0; i < ids.length; i++){
			ps[i] = new Player(ids[i]);
		}
		return ps;
	}
}
