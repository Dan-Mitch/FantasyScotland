package model;
import com.github.pabloo99.xmlsoccer.*;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

import java.util.ArrayList;

public class Players {
	private ArrayList<Player> roster;
	private int numOfPlayers;
	
	public static void buildRoster(){
		XmlSoccerService xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		System.out.println(xmlSoccerService.getAllTeamsByLeagueAndSeason("Scottish Premier League", "1920"));
		
		
	}
	
	public static void main(String[] args) {
		buildRoster();
	}
}
