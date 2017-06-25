package com.github.giorgospetkakis.sage;

import com.github.giorgospetkakis.sage.reasoner.Game;
import com.github.giorgospetkakis.sage.reasoner.Player;
import com.github.giorgospetkakis.sage.reasoner.ReasonerFactory;

/**
 * The main class for the SAGE Project.
 * 
 * @author giorgospetkakis
 *
 */
public class Sage 
{
	static ReasonerFactory factory = new ReasonerFactory();
	
    public static void main( String[] args )
    {
    	String[] ids = {
    			"76561198289999115",
    			"76561198064924496",
    			"76561198188527799",
    			"76561197960265731",
    			"76561197960265738",
    			"76561197960265740",
    			"76561197960265747",
    			"76561197960265749",
    			"76561197960268093",
    			"76561197960269040",
    			"76561197960270258",
    			"76561197960270457",
    			"76561197960271661",
    			"76561197960273963",
    			"76561197960274006",
    			"76561197960274521",
    			"76561197960277670",
    	};
    	
    	String [] appids = {
    			"2900",
    			"301111",
    			"421880",
    			"371440",
    			"319280",
    			"31970",
    			"390399",
    			"97308",
    			"81862",
    			"214100",
    			"282516",
    			"406422",
    			"385520",
    			"301910",
    			"400984",
    			"569160",
    			"316500",
    			"540800",
    			"10545",
    			"525816",
    			"287980",
    			"541310",
    			"564070",
    			"598710",
    			"91603",
    			"429904",
    	};
    	
    	for(String s : ids) {
    		Player p = new Player(s);
    		factory.addPlayer(p);
    	}
    	
    	Player f = new Player("76561197960279106");
    	factory.addFriends(f, Player.toPlayerArray(ids));
    	factory.addOwnedGames(f, Game.toGameArray(appids));
    	
    	Player f2 = new Player("76561197960279107");
    	factory.addFriends(f2, Player.toPlayerArray(ids));
    	factory.addOwnedGames(f2, Game.toGameArray(appids));
    	
    	factory.writeAll();
    }
}
