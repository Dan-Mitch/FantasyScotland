package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.UUID;

import com.github.pabloo99.xmlsoccer.api.dto.GetHistoricMatchesResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchEventsDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchLineupsDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;
import com.github.pabloo99.xmlsoccer.model.enums.Leagues;

import model.User;

import database.DatabaseLinker;

public class MainModel {
	
	private DatabaseLinker database;
	public static ArrayList<Club> clubs;
	private Players players;
	private Fixtures fixtures;
	//private Leagues leagues;
	private ArrayList<User> users;
	private LocalDateTime localDate;
	private XmlSoccerService xmlSoccerService;
	
	public MainModel() {
		this.database = new DatabaseLinker();
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.clubs = database.loadClubs();
		this.fixtures = new Fixtures(this.xmlSoccerService);
		//this.leagues = new Leagues();
		this.players = new Players(database.loadPlayers());
		this.users = new ArrayList<User>();
		
		refreshDate();
	}
	
	public void checkPreviousFixtures() {
		for(GetHistoricMatchesResultDto fixture : fixtures.getAllFixtures()) {
			Date date = fixture.getDate();
			LocalDateTime fixtureDate = date.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDateTime();
			refreshDate();
			if(fixtureDate.isBefore(localDate)) {
				if(!this.database.doesFixtureExist(fixture.getFixtureMatchId())) {
					this.database.writeFixture(fixture.getFixtureMatchId(), fixture.getRound(), fixture.getHomeTeamId(), fixture.getAwayTeamId());
					if(!this.database.doesScoreExist(fixture.getFixtureMatchId())){
						for(Score score : this.buildScoresForFixture(fixture.getFixtureMatchId(), fixture.getRound())) {
							this.database.writeScore(score.getRound(), score.getPlayer_id(), score.getGoals(), score.getAssists(), score.getRed_cards(), score.getYellow_cards(), score.getApps(), score.getClean_sheets(), score.getFixture_id());
						}
					}
					else {
						continue;
					}
				}
				else {
					continue;
				}
			}
			else {
				continue;
			}
		}
	}
	
	public ArrayList<Score> buildScoresForFixture(int fixture_id, int round) {
		ArrayList<Score> scores = new ArrayList<Score>();
		List<GetMatchEventsDto> match_events  = xmlSoccerService.getMatchEventsByFixtureMatchId(fixture_id)
                .stream().
                collect(Collectors.toList());
		List<GetMatchLineupsDto> lineups = xmlSoccerService.getMatchLineupsByFixtureMatchId(fixture_id)
                .stream().
                collect(Collectors.toList());
		ArrayList<String> substitutes = new ArrayList<String>();
		ArrayList<String> starters = new ArrayList<String>();
		
		for(GetMatchLineupsDto participant : lineups) {
			if(participant.getLineupType().equals("Coach")) {
				continue;
			}
			else if(participant.getParticipantName().equals("Substitute player")) {
				substitutes.add(participant.getParticipantName());
			}
			else {
				starters.add(participant.getParticipantName());
			}
		}
		//left off here
		return scores;
	}
	
	public UUID authenticateUser(String email, String pass) {
		String response = this.database.authenticateUser(email, pass);
		if (response != null && !response.isEmpty()) {
			UUID id = UUID.fromString(response);
			if(this.getUser(id) == null) {
				users.add(new User(email, id));
			}
			else {
				users.remove(this.getUserIndex(id));
				users.add(new User(email, id));
			}
			return id;
		}
		return null;
	}
	
	public boolean doesUserExist(String email) {
		String id = this.database.doesUserExist(email);
		if(id != null && !id.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean doesTeamExist(String email) {
		UUID team_id = this.database.doesTeamExist(email);
		if(team_id != null) {
			return true;
		}
		return false;
	}
	
	public void registerUser(String email, String pass) {;
		this.database.writeUser(email, pass);
	}
	
	public void registerTeam(String name, UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam();
		if(name.contains("'")) {
			String newName = name.replace("'", "''");
			team.setName(newName);
		}else {
			team.setName(name);
		}
		team.setTeam_id(UUID.randomUUID());
		team.setRandomCaptain();
		this.database.writeTeamDetails(team.getTeam_id(), team.getName(), team.getTransferBudget(),
				team.getCaptain().getPlayer_id());
		this.database.writeTeam(team.getTeam_id(), team.getOwner_id());
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.writeTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(), entry.getKey());
		}
	}
	
	public String addPlayerToTeam(UUID id, int position, UUID user_id) {
		Player player = this.players.getPlayer(id);
		return this.getUser(user_id).addPlayerToTeam(player, position);
	}
	
	public String removePlayerFromTeam(int position, UUID user_id) {
			return this.getUser(user_id).removePlayerFromTeam(position);
	}
	
	public void loadTeam(UUID user_id) {
		Team team = this.database.loadTeam(user_id);
		User user = this.getUser(user_id);
		user.setTeam(team);
	}

	public Players getPlayers() {
		return players;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public User getUser(UUID id) {
		for (User u : this.getUsers()) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}
	
	public int getUserIndex(UUID id) {
		ArrayList<User> u = this.getUsers();
		User user = this.getUser(id);
		return u.indexOf(user);
	}
	
	public void refreshDate() {
		this.localDate = LocalDateTime.now().minusYears(1).withNano(0).withSecond(0);
	}
}
