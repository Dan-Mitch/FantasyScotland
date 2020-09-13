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

/**
 * This class holds all methods related to communicating with the football data API to return and 
 * hold fixture data. 
 * <p>
 * All fixture objects held in this class are created by the football data API. There is no designed 
 * data transfer object.
 * @author d_mit
 *
 */
public class Fixtures {
	
	XmlSoccerService xmlSoccerService; //football data api service
	private List<GetHistoricMatchesResultDto> allFixtures;

	/**
	 * This constuctor method is called immediately when the application first starts.
	 * It is passed the xmlSoccerService parameter from the main method and makes a call to the service
	 * to return all 2019/20 fixture objects.
	 * @param xmlSoccerService
	 */
	public Fixtures(XmlSoccerService xmlSoccerService) {
		this.xmlSoccerService = xmlSoccerService;
		this.allFixtures = xmlSoccerService
				.getHistoricMatchesByLeagueAndSeason(Leagues.SCOTTISH_PREMIER_LEAGUE.getParam(), "1920").stream()
				.collect(Collectors.toList());
	}

	//___________________GET ROUNDS_____________________
	
	/**
	 * This method returns the current upcomming round according to the date.
	 * <p>
	 * The method analyses all the fixtures and determines what round is being played 
	 * by returning the round attribute of the next fixture object that hasnt been played.
	 * @param today the local date time
	 * @return the round 
	 */
	public int whatsCurrentRound(LocalDateTime today) {
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
	
	/**
	 * This method is used to determine what is the last round attibute included in the fixture objects
	 * returned by the api.
	 * <p>
	 * It is used in the points history building, to determine what limit of rounds the application should search the database for.
	 * @return
	 */
	public int whatsLastRound() {
		ArrayList<Integer> rounds = new ArrayList<Integer>();
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			int round = fixture.getRound();
			rounds.add(round);
		}
		return Collections.max(rounds);

	}
	//___________________GET DATES______________________
	
	/**
	 * This method returns the start date for a round of fixtures.
	 * @param round the number representing the round
	 * @return the start date of the round
	 */
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
	
	/**
	 * This method returns the correct next round start date when a fixture round is in the process of being played.
	 * <p>
	 * This method is used for scheduling the next block after a round has started.
	 * @param date current date time 
	 * @return start date of the next round
	 */
	public LocalDateTime getNextStartDate(LocalDateTime date) {
		int round = whatsCurrentRound(date);
		int nextRound = round + 1;
		
		LocalDateTime roundDate = startDateOfRound(round);
		LocalDateTime nextRoundDate = startDateOfRound(nextRound);
		
		if(date.isBefore(nextRoundDate) && date.isAfter(roundDate)) {
			return nextRoundDate;
		}
		else {
			return roundDate;
		}
	}

	/**
	 * This method returns the end date for a round of fixtures.
	 * <p>
	 * The football data API was returning inaccurate and misleading data related to the end dates of later rounds. This was due to a badly maintained
	 * API that was disrupted due to the COVID-19 outbreak. In order to keep the application functioning properly, hard coded fixes had to be implmented to return the correct
	 * end dates in the two instances that the wrong data was being returned.
	 * @param round the number representing the round
	 * @return the end date of the round
	 */
	public LocalDateTime endDateOfRound(int round) {
		if(round == 28) {
			return LocalDateTime.of(2020, 2, 23, 15, 0); //hard coded fix for round 28 end date
		}
		if(round == 27) {
			return LocalDateTime.of(2020, 2, 16, 16, 30); //hard coded fix for round 27 end date
		}
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
	
	//___________________GET FIXTURES___________________
	
	/**
	 * This method returns the whole list of fixture objects.
	 * @return list of all fixtures
	 */
	public List<GetHistoricMatchesResultDto> getAllFixtures() {
		return allFixtures;
	}
	
	/**
	 * This method is used to return a set amount of fixture objects based on the round the fixtures 
	 * occur in.
	 * <p>
	 * This method is used for returning the next set of upcomming fixtures which are
	 * displayed on the home screen.
	 * @param round the number representing the round
	 * @return a list of fixtures
	 */
	public ArrayList<GetHistoricMatchesResultDto> whatFixturesIn(int round) {
		ArrayList<GetHistoricMatchesResultDto> fixtures = new ArrayList<GetHistoricMatchesResultDto>();
		for (GetHistoricMatchesResultDto fixture : this.getAllFixtures()) {
			if (fixture.getRound() == round) {
				fixtures.add(fixture);
			}
		}
		return fixtures;
	}
}