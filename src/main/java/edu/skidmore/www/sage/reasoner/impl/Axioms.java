package edu.skidmore.www.sage.reasoner.impl;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class Axioms {
	private static Model axiomModel;
	
	public static Model getModel() {
		return axiomModel;
	}
	
	public static void init() {
		axiomModel = ModelFactory.createDefaultModel();
	}
}
