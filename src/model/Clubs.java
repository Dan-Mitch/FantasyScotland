package model;

import java.util.ArrayList;

import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

public final class Clubs {
	private XmlSoccerService xmlSoccerService;
	public static ArrayList<GetTeamResultDto> clubs;
	public static ArrayList<Integer> club_ids;
	
	public Clubs() {
		xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		clubs = new ArrayList<GetTeamResultDto>(xmlSoccerService.getAllTeamsByLeagueAndSeason("Scottsih Premier League", "1920"));
		club_ids = new ArrayList<Integer>();
		for(GetTeamResultDto club: clubs) {
			club_ids.add(club.getTeamId());
		}
	}
}
