package model;

import java.util.ArrayList;

import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

public class Clubs {
	private XmlSoccerService xmlSoccerService;
	private ArrayList<GetTeamResultDto> clubs;
	
	public Clubs() {
		xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		this.clubs = new ArrayList<GetTeamResultDto>(xmlSoccerService.getAllTeamsByLeagueAndSeason("Scottsih Premier League", "1920"));
	}
	
	public ArrayList<GetTeamResultDto> getClubs() {
		return clubs;
	}
}
