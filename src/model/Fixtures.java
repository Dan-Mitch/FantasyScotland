package model;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pabloo99.xmlsoccer.api.dto.GetHistoricMatchesResultDto;
import com.github.pabloo99.xmlsoccer.model.enums.Leagues;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl; 

public class Fixtures {
	XmlSoccerService xmlSoccerService;
	List<GetHistoricMatchesResultDto> allFixtures;
	
	public Fixtures(XmlSoccerService xmlSoccerService) {
		xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.allFixtures  = xmlSoccerService.getHistoricMatchesByLeagueAndSeason(Leagues.SCOTTISH_PREMIER_LEAGUE.getParam(), "1920")
                .stream().
                collect(Collectors.toList());
		
	}
	
	public List<GetHistoricMatchesResultDto> getWeekFixtures(LocalDate date){
		List<GetHistoricMatchesResultDto> weekFixtures = xmlSoccerService.getHistoricMatchesByLeagueAndDateInterval(Leagues.SCOTTISH_PREMIER_LEAGUE.getParam(), date.toString(), date.plusWeeks(1).toString()).stream().
                collect(Collectors.toList());
		return weekFixtures;
	}
	
	public List<GetHistoricMatchesResultDto> getAllFixtures() {
		return allFixtures;
	}

//	public static void main(String[] args) {
//		Fixtures f = new Fixtures();
//		Date date = f.getAllFixtures().get(f.getAllFixtures().size()-10).getDate();
//		LocalDateTime fixtureDate = date.toInstant()
//			      .atZone(ZoneId.systemDefault())
//			      .toLocalDateTime();
//		System.err.println(fixtureDate);
//		LocalDateTime localDate = LocalDateTime.now().minusYears(1).withNano(0).withSecond(0);
//	
//		System.err.println(localDate);
//		
//
//		if(fixtureDate.isBefore(localDate)) {
//			System.err.println("date before today");
//		}
//		else if(fixtureDate.isAfter(localDate)) {
//			System.err.println("date after today");
//		}
//	}
}
