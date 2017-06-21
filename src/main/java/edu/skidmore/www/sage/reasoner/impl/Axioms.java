package edu.skidmore.www.sage.reasoner.impl;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.InverseFunctionalProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
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
	
	public static OntModel getModel() {
		return axiomModel;
	}
	
	/**
	 * Initialize the model and axioms.
	 * 
	 */
	public static void init() {
		
		axiomModel = ModelFactory.createOntologyModel();

		//==========================
		//Define Ontology Classes
		//==========================
		
		OntClass player = axiomModel.createClass(NS+"Player");
		OntClass game = axiomModel.createClass(NS+"Game");
		OntClass tag = axiomModel.createClass(NS+"Tag");
		
		OntClass metaGroup = axiomModel.createClass(NS+"MetaGroup");
		
		OntClass userID = axiomModel.createClass(NS+"UserID");
		OntClass appID = axiomModel.createClass(NS+"AppID");
		OntClass tagID = axiomModel.createClass(NS+"TagID");
		OntClass metaGroupID = axiomModel.createClass(NS+"MetaGroupID");
		
		OntClass firstName = axiomModel.createClass(FOAF+"term_firstName");
		OntClass lastName = axiomModel.createClass(FOAF+"term_lastName");
		OntClass nick = axiomModel.createClass(FOAF+"term_nick");
		
		OntClass title = axiomModel.createClass(NS+"Title");
		
		OntClass description = axiomModel.createClass(NS+"TagDescription");
		
		//==========================
		//Define Ontology Properties
		//==========================
		player.addProperty(RDFS.subClassOf, FOAF + "term_Person");
		
		InverseFunctionalProperty hasUserID = axiomModel.createInverseFunctionalProperty(NS+"hasUserID", true);
		hasUserID.addDomain(player);
		hasUserID.addRange(userID);
		
		InverseFunctionalProperty hasAppID = axiomModel.createInverseFunctionalProperty(NS+"hasAppID", true);
		hasAppID.addDomain(game);
		hasAppID.addRange(appID);
		
		InverseFunctionalProperty hasTagID = axiomModel.createInverseFunctionalProperty(NS+"hasTagID", true);
		hasTagID.addDomain(tag);
		hasTagID.addRange(tagID);
		
		InverseFunctionalProperty hasMetaGroupID = axiomModel.createInverseFunctionalProperty(NS+"hasMetaGroupID", true);
		hasMetaGroupID.addDomain(metaGroup);
		hasMetaGroupID.addRange(metaGroupID);
		
		DatatypeProperty hasFirstName = axiomModel.createDatatypeProperty(NS+"hasFirstName", true);
		hasFirstName.addDomain(player);
		hasFirstName.addRange(firstName);
		
		DatatypeProperty hasLastName = axiomModel.createDatatypeProperty(NS+"hasLastName", true);
		hasLastName.addDomain(player);
		hasLastName.addRange(lastName);
		
		DatatypeProperty hasNickname = axiomModel.createDatatypeProperty(NS+"hasNickname", false);
		hasNickname.addDomain(player);
		hasNickname.addRange(nick);
		
		DatatypeProperty belongsTo = axiomModel.createDatatypeProperty(NS+"belongsTo", true);
		belongsTo.addDomain(player);
		belongsTo.addRange(metaGroup);
		
		DatatypeProperty hasTitle = axiomModel.createDatatypeProperty(NS+"hasFirstName", true);
		hasTitle.addDomain(game);
		hasTitle.addRange(title);
		
		DatatypeProperty hasDescription = axiomModel.createDatatypeProperty(NS+"hasDescription", true);
		hasDescription.addDomain(tag);
		hasDescription.addRange(description);
		
		SymmetricProperty hasFriend = axiomModel.createSymmetricProperty(NS+"hasFriend");
		hasFriend.addDomain(player);
		hasFriend.addRange(player);
		
		DatatypeProperty owns = axiomModel.createDatatypeProperty(NS+"owns");
		DatatypeProperty isOwned = axiomModel.createDatatypeProperty(NS+"isOwned");
		owns.addDomain(player);
		owns.addRange(game);
		owns.addInverseOf(isOwned);
		
		DatatypeProperty hasFavorite = axiomModel.createDatatypeProperty(NS+"hasFavorite");
		DatatypeProperty isFavoredBy = axiomModel.createDatatypeProperty(NS+"isFavoredBy");
		hasFavorite.addDomain(player);
		hasFavorite.addRange(game);
		hasFavorite.addInverseOf(isFavoredBy);
		
		DatatypeProperty hasTag = axiomModel.createDatatypeProperty(NS+"hasTag");
		DatatypeProperty isTagOf = axiomModel.createDatatypeProperty(NS+"isTagOf");
		hasTag.addDomain(tag);
		hasTag.addRange(game);
		hasTag.addInverseOf(isTagOf);
	}
}
