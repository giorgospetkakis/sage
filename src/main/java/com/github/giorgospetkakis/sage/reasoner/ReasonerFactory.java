package com.github.giorgospetkakis.sage.reasoner;

import java.io.FileNotFoundException;

import com.github.koraktor.steamcondenser.community.SteamGame;
import com.github.koraktor.steamcondenser.community.SteamId;

/**
 * Factory for the reasoner class. Recommended way to add data to the ontology.
 * 
 * @author giorgospetkakis
 *
 */
public class ReasonerFactory implements RDFImport {
	
	private Reasoner r;
	
	public ReasonerFactory() {
		r = new Reasoner();
	}
	
	public void addPlayer(SteamId player) 
	{ r.addPlayer(player); }
	
	public void addGame(SteamGame game) 
	{ r.addGame(game); }
	
	public void writeAll()
	{ r.writeAll(); }

	public void write() 
	{ r.write(); }
	
	public void export(String file) throws FileNotFoundException 
	{ r.export(file); }


}
