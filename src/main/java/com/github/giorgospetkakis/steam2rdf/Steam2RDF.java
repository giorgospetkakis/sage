package com.github.giorgospetkakis.steam2rdf;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;

import com.github.giorgospetkakis.steam2rdf.reasoner.ReasonerFactory;
import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;
import com.github.koraktor.steamcondenser.scraper.SteamUserDefinedTag;

/**
 * The main class for the Steam2RDF Project.
 * 
 * @author Giorgos Petkakis
 *
 */
public abstract class Steam2RDF
{
	/**
	 * The ontology model used to make inferences.
	 */
	private ReasonerFactory reasonerFactory;
	
	//Constructors
	
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
	
	//Class Methods
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
	public void addUserDefinedTags(SteamUserDefinedTag[] tags){
		reasonerFactory.addTags(tags);
	}
	/**
	 * Returns the current OntModel.
	 * Adding resources to the OntModel directly
	 * is highly discouraged
	 * @return The current ontology model
	 */
	public OntModel getModel() {
		return reasonerFactory.getModel();
	}
	/**
	 * Returns an XML representation of the ontology.
	 * @return The full XML in <code>String</code> type
	 */
	public String getXML() {
		return getOntText("XML");
	}
	/**
	 * Returns an Turtle representation of the ontology.
	 * @return The full Turtle in <code>String</code> type
	 */
	public String getTtl() {
		return getOntText("TURTLE");
	}
	/**
	 * Returns the current ontology (all nodes) in the specified form.
	 * @param format The output format of the String
	 * @return The ontology in String form
	 */
	private String getOntText(String format){
		StringWriter sw = new StringWriter();
		getModel().writeAll(sw, format);
		return sw.toString();
	}
}
