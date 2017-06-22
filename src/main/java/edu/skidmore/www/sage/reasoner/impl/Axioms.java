package edu.skidmore.www.sage.reasoner.impl;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.InverseFunctionalProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.SymmetricProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDFS;

/**
 * A list of axioms for the ontology.
 * 
 * @author giorgospetkakis
 *
 */
public class Axioms {
	private static OntModel axiomModel;
	private final static String NS = "http://www.skidmore.edu/~gpetkaki/#";
	private final static String FOAF = "http://xmlns.com/foaf/spec/#";

	public static OntClass player; 	
	public static OntClass game; 	
	public static OntClass tag; 		                    
	public static OntClass metaGroup;                  
	public static OntClass userID; 	
	public static OntClass appID; 	
	public static OntClass tagID; 	
	public static OntClass metaGroupID;                  
	public static OntClass firstName;
	public static OntClass lastName; 
	public static OntClass nick; 	                   
	public static OntClass title; 	                   
	public static OntClass description;
	
	public static InverseFunctionalProperty hasUserID;
	public static InverseFunctionalProperty hasAppID;
	public static InverseFunctionalProperty hasTagID;
	public static InverseFunctionalProperty hasMetaGroupID;
	public static DatatypeProperty hasFirstName;
	public static DatatypeProperty hasLastName;
	public static DatatypeProperty hasNickname;
	public static DatatypeProperty belongsTo;
	public static DatatypeProperty hasTitle;
	public static DatatypeProperty hasDescription;
	public static SymmetricProperty hasFriend;
	public static DatatypeProperty owns;
	public static DatatypeProperty isOwnedBy;
	public static DatatypeProperty hasFavorite;
	public static DatatypeProperty isFavoredBy;
	public static DatatypeProperty hasTag;
	public static DatatypeProperty isTagOf;
	
	static {
		init();
	}
	
	public static OntModel getModel() {
		return axiomModel;
	}
	
	/**
	 * Initialize the model and axioms.
	 * 
	 */
	public static void init() {
		
		//Initialize Full OWL through Jena
		axiomModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);

		//==========================
		//Define Ontology Classes
		//==========================
		
		player = axiomModel.createClass(NS+"Player");
		game = axiomModel.createClass(NS+"Game");
		tag = axiomModel.createClass(NS+"Tag");
		
		metaGroup = axiomModel.createClass(NS+"MetaGroup");
		
		userID = axiomModel.createClass(NS+"UserID");
		appID = axiomModel.createClass(NS+"AppID");
		tagID = axiomModel.createClass(NS+"TagID");
		metaGroupID = axiomModel.createClass(NS+"MetaGroupID");
		
		firstName = axiomModel.createClass(FOAF+"term_firstName");
		lastName = axiomModel.createClass(FOAF+"term_lastName");
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
		hasAppID.addDomain(game);
		hasAppID.addRange(appID);
		
		hasTagID = axiomModel.createInverseFunctionalProperty(NS+"hasTagID", true);
		hasTagID.addDomain(tag);
		hasTagID.addRange(tagID);
		
		hasMetaGroupID = axiomModel.createInverseFunctionalProperty(NS+"hasMetaGroupID", true);
		hasMetaGroupID.addDomain(metaGroup);
		hasMetaGroupID.addRange(metaGroupID);
		
		hasFirstName = axiomModel.createDatatypeProperty(NS+"hasFirstName", true);
		hasFirstName.addDomain(player);
		hasFirstName.addRange(firstName);
		
		hasLastName = axiomModel.createDatatypeProperty(NS+"hasLastName", true);
		hasLastName.addDomain(player);
		hasLastName.addRange(lastName);
		
		hasNickname = axiomModel.createDatatypeProperty(NS+"hasNickname", false);
		hasNickname.addDomain(player);
		hasNickname.addRange(nick);
		
		belongsTo = axiomModel.createDatatypeProperty(NS+"belongsTo", true);
		belongsTo.addDomain(player);
		belongsTo.addRange(metaGroup);
		
		hasTitle = axiomModel.createDatatypeProperty(NS+"hasFirstName", true);
		hasTitle.addDomain(game);
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
		owns.addRange(game);
		owns.addInverseOf(isOwnedBy);
		
		hasFavorite = axiomModel.createDatatypeProperty(NS+"hasFavorite");
		isFavoredBy = axiomModel.createDatatypeProperty(NS+"isFavoredBy");
		hasFavorite.addDomain(player);
		hasFavorite.addRange(game);
		hasFavorite.addInverseOf(isFavoredBy);
		
		hasTag = axiomModel.createDatatypeProperty(NS+"hasTag");
		isTagOf = axiomModel.createDatatypeProperty(NS+"isTagOf");
		hasTag.addDomain(tag);
		hasTag.addRange(game);
		hasTag.addInverseOf(isTagOf);
	}
}
