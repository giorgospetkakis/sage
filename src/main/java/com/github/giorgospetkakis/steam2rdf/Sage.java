package com.github.giorgospetkakis.steam2rdf;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.github.giorgospetkakis.steam2rdf.reasoner.ReasonerFactory;
import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.scraper.WebScraper;

/**
 * The main class for the SAGE Project.
 * 
 * @author giorgospetkakis
 *
 */
public class Sage 
{
	
	private static final String KEY = "3D31F24513C0F5242FE5B3917816A745";
	static ReasonerFactory factory = new ReasonerFactory();
	
    public static void main( String[] args ) throws SteamCondenserException
    {
//		WebApi.setApiKey(KEY);
//    	String id = "RastaBacon";
//    	
//    	SteamId si;
//		si = SteamId.create(id);
//		factory.addPlayer(si);
//			
//    	try {
//			factory.export("steam-ont.ttl");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
    	try {
    		
    		FileOutputStream out = new FileOutputStream("page.xhtml");
    		System.setOut(new PrintStream(out));
			System.out.println(WebScraper.load("steamcommunity.com", "app", "35700", "screenshots", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
