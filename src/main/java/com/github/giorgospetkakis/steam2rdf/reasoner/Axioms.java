package com.github.giorgospetkakis.steam2rdf.reasoner;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.InverseFunctionalProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.SymmetricProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDFS;

/**
 * The Axiomatic relationships between different Steam entities.
 * 
 * @author giorgospetkakis
 *
 */
public class Axioms {
	/**
	 * The Axiom ontology model.
	 */
	private static OntModel axiomModel;
	/**
	 * The Axiom namespace.
	 * Refers to the project URI
	 */
	private final static String NS = "http://github.com/giorgospetkakis/steam2RDF/#";
	/**
	 * The FOAF namespace.
	 */
	private final static String FOAF = "http://xmlns.com/foaf/spec/#";
	/**
	 * A Steam player.
	 */
	public static OntClass player;
	/**
	 * A Steam app.
	 */
	public static OntClass app;
	/**
	 * A Steam user-defined tag for an app.
	 */
	public static OntClass tag;
	/**
	 * An experimental grouping of players.
	 */
	public static OntClass metaGroup;
	/**
	 * A Steam <code>player</code>'s unique id. 
	 */
	public static OntClass userID;
	/**
	 * A Steam <code>app</code>'s unique id.
	 */
	public static OntClass appID;
	/**
	 * A Steam <code>user-defined tag</code>'s unique id.
	 */
	public static OntClass tagID;
	/**
	 * An experimental <code>metaGroup</code>'s unique id.
	 */
	public static OntClass metaGroupID;
	/**
	 * A Steam <code>player</code>'s full name.
	 */
	public static OntClass fullName;
	/**
	 * A Steam <code>player</code>'s nickaname.
	 */
	public static OntClass nick;
	/**
	 * A Steam <code>app</code>'s given title.
	 */
	public static OntClass title;
	/**
	 * A Steam <code>user-defined tag</code>'s description.
	 */
	public static OntClass description;
	/**
	 * The property that describes a Steam <code>player</code> being assigned a unique ID.
	 */
	public static InverseFunctionalProperty hasUserID;
	/**
	 * The property that describes a Steam <code>app</code> being assigned a unique ID.
	 */
	public static InverseFunctionalProperty hasAppID;
	/**
	 * The property that describes a Steam <code>tag</code> being assigned a unique ID.
	 */
	public static InverseFunctionalProperty hasTagID;
	/**
	 * The property that describes a Steam <code>meta-group</code> being assigned a unique ID.
	 */
	public static InverseFunctionalProperty hasMetaGroupID;
	/**
	 * The property that describes a Steam <code>player</code> having a full name.
	 */
	public static DatatypeProperty hasFullName;
	/**
	 * The property that describes a Steam <code>player</code> having a nickname.
	 */
	public static DatatypeProperty hasNickname;
	/**
	 * The property that describes a Steam <code>app</code> having an owner.
	 * This is not limited to one owner per game.
	 */
	public static DatatypeProperty belongsTo;
	/**
	 * The property that describes a Steam <code>app</code> having a title.
	 */
	public static DatatypeProperty hasTitle;
	/**
	 * The property that describes a Steam <code>tag</code> having a description.
	 */
	public static DatatypeProperty hasDescription;
	/**
	 * The property that describes a Steam <code>player</code> having 
	 * another Steam <code> player </code> as a friend.
	 */
	public static SymmetricProperty hasFriend;
	/**
	 * The property that describes a Steam <code>player</code> owning 
	 * a Steam <code> app </code>.
	 */
	public static DatatypeProperty owns;
	/**
	 * The property that describes a Steam <code>app</code> being 
	 * owned by a Steam <code> player </code>.
	 */
	public static DatatypeProperty isOwnedBy;
	/**
	 * The property that describes a Steam <code>app</code> having 
	 * been assigned a <code> user-defined tag </code>.
	 */
	public static DatatypeProperty hasTag;
	/**
	 * The property that describes a Steam <code>user-defined tag</code> having 
	 * been assigned to a <code>game</code>.
	 */
	public static DatatypeProperty isTagOf;
	
	static {
		//==========================
		//Define Ontology Classes
		//==========================
		
		player = axiomModel.createClass(NS+"Player");
		app = axiomModel.createClass(NS+"Game");
		tag = axiomModel.createClass(NS+"Tag");
		
		metaGroup = axiomModel.createClass(NS+"MetaGroup");
		
		userID = axiomModel.createClass(NS+"UserID");
		appID = axiomModel.createClass(NS+"AppID");
		tagID = axiomModel.createClass(NS+"TagID");
		metaGroupID = axiomModel.createClass(NS+"MetaGroupID");
		
		fullName = axiomModel.createClass(FOAF+"term_fullName");
		nick = axiomModel.createClass(FOAF+"term_nick");
		
		title = axiomModel.createClass(NS+"Title");
		
		description = axiomModel.createClass(NS+"TagDescription");
		
		//==========================
		//Define Ontology Properties
		//==========================
		player.addProperty(RDFS.subClassOf, FOAF + "term_Person");
		
		hasUserID = axiomModel.createInverseFunctionalProperty(NS+"hasUserID", true);
		hasUserID.addDomain(player);
		hasUserID.addRange(userID);
		
		hasAppID = axiomModel.createInverseFunctionalProperty(NS+"hasAppID", true);
		hasAppID.addDomain(app);
		hasAppID.addRange(appID);
		
		hasTagID = axiomModel.createInverseFunctionalProperty(NS+"hasTagID", true);
		hasTagID.addDomain(tag);
		hasTagID.addRange(tagID);
		
		hasMetaGroupID = axiomModel.createInverseFunctionalProperty(NS+"hasMetaGroupID", true);
		hasMetaGroupID.addDomain(metaGroup);
		hasMetaGroupID.addRange(metaGroupID);
		
		hasFullName = axiomModel.createDatatypeProperty(NS+"hasFullName", true);
		hasFullName.addDomain(player);
		hasFullName.addRange(fullName);
		
		hasNickname = axiomModel.createDatatypeProperty(NS+"hasNickname", false);
		hasNickname.addDomain(player);
		hasNickname.addRange(nick);
		
		belongsTo = axiomModel.createDatatypeProperty(NS+"belongsTo", true);
		belongsTo.addDomain(player);
		belongsTo.addRange(metaGroup);
		
		hasTitle = axiomModel.createDatatypeProperty(NS+"hasFirstName", true);
		hasTitle.addDomain(app);
		hasTitle.addRange(title);
		
		hasDescription = axiomModel.createDatatypeProperty(NS+"hasDescription", true);
		hasDescription.addDomain(tag);
		hasDescription.addRange(description);
		
		hasFriend = axiomModel.createSymmetricProperty(NS+"hasFriend");
		hasFriend.addDomain(player);
		hasFriend.addRange(player);
		
		owns = axiomModel.createDatatypeProperty(NS+"owns");
		isOwnedBy = axiomModel.createDatatypeProperty(NS+"isOwned");
		owns.addDomain(player);
		owns.addRange(app);
		owns.addInverseOf(isOwnedBy);
		
		hasTag = axiomModel.createDatatypeProperty(NS+"hasTag");
		isTagOf = axiomModel.createDatatypeProperty(NS+"isTagOf");
		hasTag.addDomain(tag);
		hasTag.addRange(app);
		hasTag.addInverseOf(isTagOf);
	}
	
	/**
	 * Returns the Axiom model.
	 * 
	 * @return The Steam Ontology Axiom model
	 */
	protected static OntModel getAxiomModel() {
		return axiomModel;
	}
}
