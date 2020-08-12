package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
		this.xmlSoccerService = xmlSoccerService;
		this.allFixtures = xmlSoccerService
				.getHistoricMatchesByLeagueAndSeason(Leagues.SCOTTISH_PREMIER_LEAGUE.getParam(), "1920").stream()
				.collect(Collectors.toList());

	}

	public int whatRoundNext(LocalDateTime today) {
		int round = 0;
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			Date date = fixture.getDate();
			LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			if (fixtureDate.isAfter(today)) {
				round = fixture.getRound();
			}
		}
		return round;

	}

	public ArrayList<GetHistoricMatchesResultDto> whatFixturesIn(int round) {
		ArrayList<GetHistoricMatchesResultDto> fixtures = new ArrayList<GetHistoricMatchesResultDto>();
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			if (fixture.getRound() == round) {
				fixtures.add(fixture);
			}
		}
		return fixtures;
	}

	public LocalDateTime startDateOfRound(int round) {
		ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			if (fixture.getRound() != round) {
				continue;
			} else {
				Date date = fixture.getDate();
				LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				dates.add(fixtureDate);
			}
		}
		return Collections.min(dates);

	}

	public LocalDateTime endDateOfRound(int round) {
		ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			if (fixture.getRound() != round) {
				continue;
			} else {
				Date date = fixture.getDate();
				LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				dates.add(fixtureDate);
			}
		}
		return Collections.max(dates);

	}

	public List<GetHistoricMatchesResultDto> getAllFixtures() {
		return allFixtures;
	}

	public GetHistoricMatchesResultDto getFixtureFromID(int fixture_id) {
		GetHistoricMatchesResultDto result = null;
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			if (fixture.getFixtureMatchId() == fixture_id) {
				result = fixture;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		XmlSoccerService xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		LocalDateTime today = LocalDateTime.now().minusYears(1).withNano(0).withSecond(0);
		LocalDateTime fakeToday = LocalDateTime.parse("2019-08-11T15:00");
		Fixtures f = new Fixtures(xmlSoccerService);
		Date date = f.getAllFixtures().get(f.getAllFixtures().size() - 11).getDate();
		LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.err.println(fakeToday);
		System.err.println(fixtureDate);
		if (fixtureDate.isBefore(fakeToday)) {
			System.err.println("bef");
		} else if (fixtureDate.isAfter(fakeToday)) {
			System.err.println("aft");
		} else if (fixtureDate.isEqual(fakeToday)) {
			System.err.println("same");
		}
		int round = f.whatRoundNext(today);
		System.err.println(round);
		System.err.println(f.whatFixturesIn(round).toString());
		System.err.println(f.startDateOfRound(round));
		System.err.println(f.endDateOfRound(round));
	}
}
