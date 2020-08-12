package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.UUID;

import com.github.pabloo99.xmlsoccer.api.dto.GetHistoricMatchesResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchEventsDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchLineupsDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

import model.User;

import database.DatabaseLinker;

public class MainModel {

	private DatabaseLinker database;
	public static ArrayList<Club> clubs;
	private Players players;
	private Fixtures fixtures;
	private ArrayList<League> leagues;
	private ArrayList<User> users;
	private XmlSoccerService xmlSoccerService;

	public MainModel() {
		this.database = new DatabaseLinker();
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");

		MainModel.clubs = database.loadClubs();
		this.fixtures = new Fixtures(this.xmlSoccerService);
		this.setLeagues(new ArrayList<League>());
		this.players = new Players(database.loadPlayers());
		this.users = new ArrayList<User>();
		writePreviousFixtures();
	}

	public void writePreviousFixtures() {
		for (GetHistoricMatchesResultDto fixture : fixtures.getAllFixtures()) {
			Date date = fixture.getDate();
			LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			if (fixtureDate.isBefore(this.getTodayDate())) {
				if (!this.database.doesFixtureExist(fixture.getFixtureMatchId())) {
					this.database.writeFixture(fixture.getFixtureMatchId(), fixture.getRound(), fixture.getHomeTeamId(),
							fixture.getAwayTeamId());
					if (!this.database.doesScoreExist(fixture.getFixtureMatchId())) {
						for (Score score : this.buildScoresForFixture(fixture)) {
							this.database.writeScore(score.getRound(), score.getPlayer_id(), score.getGoals(),
									score.getAssists(), score.getRed_cards(), score.getYellow_cards(), score.getApps(),
									score.getClean_sheets(),score.getConcede_Two(), score.getOwn_goals(), score.getFixture_id());
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
	}

	public ArrayList<Score> buildScoresForFixture(GetHistoricMatchesResultDto fixture) {
		int fixture_id = fixture.getFixtureMatchId();
		ArrayList<Score> scores = new ArrayList<Score>();
		List<GetMatchLineupsDto> lineups = xmlSoccerService.getMatchLineupsByFixtureMatchId(fixture_id).stream()
				.collect(Collectors.toList());
		List<GetMatchEventsDto> match_events = xmlSoccerService.getMatchEventsByFixtureMatchId(fixture_id).stream()
				.collect(Collectors.toList());
		ArrayList<GetMatchLineupsDto> substitutes = new ArrayList<GetMatchLineupsDto>();
		ArrayList<GetMatchLineupsDto> starters = new ArrayList<GetMatchLineupsDto>();

		for (GetMatchLineupsDto participant : lineups) {
			if (participant.getLineupType().equals("Coach")) {
				continue;
			} else if (participant.getLineupType().equals("Substitute player")) {
				substitutes.add(participant);
			} else {
				starters.add(participant);
			}
		}

		for (GetMatchLineupsDto participant : starters) {
			Score score = new Score();
			int goals = 0;
			int assists = 0;
			int red_cards = 0;
			int yellow_cards = 0;
			score.setApps(1);
			int clean_sheets = calculateCleanSheet(fixture, participant);
			int concedeTwo = calculateConcedeTwo(fixture, participant);
			int own_goals = 0;
			if(participant.getParticipantName().equals("Chris Kane")) {
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			}
			else if(participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) {
				score.setPlayer_id(UUID.fromString("653e7499-9c43-4d50-b9af-4c991cd4d5bb"));
			}
			else if(participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 360) {
				score.setPlayer_id(UUID.fromString("a75b0120-4abc-4eb3-8ffa-2b7da60a7cf4"));
			}
			else
			score.setPlayer_id(this.getPlayers().getID(participant.getParticipantName()));
			score.setRound(fixture.getRound());
			for (GetMatchEventsDto event : match_events) {
				if (event.getParticipantName() == null) {
					continue;
				}
				if (event.getParticipantName().equals(participant.getParticipantName())) {
					String action = event.getEventName();
					if (action.equals("Regular goal") || action.equals("Penalty")) {
						goals++;
					} else if (action.equals("Assist")) {
						assists++;
					} else if (action.equals("Yellow card")) {
						yellow_cards++;
					} else if (action.equals("Red card")) {
						red_cards++;
					} else if (action.contentEquals("Own goal")) {
						own_goals++;
					}
				}
			}
			score.setGoals(goals);
			score.setAssists(assists);
			score.setRed_cards(red_cards);
			score.setYellow_cards(yellow_cards);
			score.setClean_sheets(clean_sheets);
			score.setConcede_Two(concedeTwo);
			score.setOwn_goals(own_goals);
			score.setFixture_id(fixture_id);
			scores.add(score);
		}
		for (GetMatchLineupsDto participant : substitutes) {
			Score score = new Score();
			int goals = 0;
			int assists = 0;
			int red_cards = 0;
			int yellow_cards = 0;
			int clean_sheets = calculateCleanSheet(fixture, participant);
			int concedeTwo = calculateConcedeTwo(fixture, participant);
			int own_goals = 0;
			if(participant.getParticipantName().equals("Chris Kane")) {
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			}
			else if(participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) {
				score.setPlayer_id(UUID.fromString("653e7499-9c43-4d50-b9af-4c991cd4d5bb"));
			}
			else if(participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 360) {
				score.setPlayer_id(UUID.fromString("a75b0120-4abc-4eb3-8ffa-2b7da60a7cf4"));
			}
			else
			score.setPlayer_id(this.getPlayers().getID(participant.getParticipantName()));
			score.setRound(fixture.getRound());
			for (GetMatchEventsDto event : match_events) {
				if (event.getParticipantName() == null) {
					continue;
				}
				if (event.getParticipantName().equals(participant.getParticipantName())) {
					String action = event.getEventName();
					if (action.equals("Substitution in")) {
						score.setApps(1);
					} else if (action.equals("Regular goal") || action.equals("Penalty")) {
						goals++;
					} else if (action.equals("Assist")) {
						assists++;
					} else if (action.equals("Yellow card")) {
						yellow_cards++;
					} else if (action.equals("Red card")) {
						red_cards++;
					} else if (action.contentEquals("Own goal")) {
						own_goals++;
					}
				}
			}
			if (score.getApps() == 0) {
				continue;
			} else {
				score.setGoals(goals);
				score.setAssists(assists);
				score.setRed_cards(red_cards);
				score.setYellow_cards(yellow_cards);
				score.setClean_sheets(clean_sheets);
				score.setConcede_Two(concedeTwo);
				score.setOwn_goals(own_goals);
				score.setFixture_id(fixture_id);
				scores.add(score);
			}
		}
		return scores;
	}

	public int calculateCleanSheet(GetHistoricMatchesResultDto fixture, GetMatchLineupsDto participant) {
		int home_goals = fixture.getHomeGoals();
		int away_goals = fixture.getAwayGoals();
		String home_team = fixture.getHomeTeam();

		if (participant.getTeamName().equals(home_team)) {
			if (away_goals > 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (home_goals > 0) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public int calculateConcedeTwo(GetHistoricMatchesResultDto fixture, GetMatchLineupsDto participant) {
		int home_goals = fixture.getHomeGoals();
		int away_goals = fixture.getAwayGoals();
		String home_team = fixture.getHomeTeam();

		if (participant.getTeamName().equals(home_team)) {
			if (away_goals > 2) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (home_goals > 2) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public UUID authenticateUser(String email, String pass) {
		String response = this.database.authenticateUser(email, pass);
		if (response != null && !response.isEmpty()) {
			UUID id = UUID.fromString(response);
			if (this.getUser(id) == null) {
				users.add(new User(email, id));
			} else {
				users.remove(this.getUserIndex(id));
				users.add(new User(email, id));
			}
			return id;
		}
		return null;
	}

	public boolean doesUserExist(String email) {
		String id = this.database.doesUserExist(email);
		if (id != null && !id.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean doesTeamExist(String email) {
		UUID team_id = this.database.doesTeamExist(email);
		if (team_id != null) {
			return true;
		}
		return false;
	}

	public void registerUser(String email, String pass) {
		;
		this.database.writeUser(email, pass);
	}

	public void registerTeam(String name, UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam();
		if (name.contains("'")) {
			String newName = name.replace("'", "''");
			team.setName(newName);
		} else {
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

	public ArrayList<GetHistoricMatchesResultDto> loadNextFixtures() {
		int nextRound = this.fixtures.whatRoundNext(this.getTodayDate());
		return this.fixtures.whatFixturesIn(nextRound);
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
	
	public static String getNameFrom(int club_id) {
		String clubName = null;
		for(Club c : MainModel.clubs) {
			if(c.getClub_id() == club_id) {
				clubName = c.getName();
			}
		}
		return clubName;
	}

	public LocalDateTime getTodayDate() {
		return LocalDateTime.now().minusYears(1).withNano(0).withSecond(0);
	}

	public Fixtures getFixtures() {
		return fixtures;
	}

	/**
	 * @return the leagues
	 */
	public ArrayList<League> getLeagues() {
		return leagues;
	}

	/**
	 * @param leagues the leagues to set
	 */
	public void setLeagues(ArrayList<League> leagues) {
		this.leagues = leagues;
	}

//	public static void main(String[] args) {
//		MainModel m = new MainModel();
//		// System.err.println(m.getPlayers().getPlayer(UUID.fromString("f5ecf81e-f227-4058-82e6-9e72d8d76139")).getName());
//		// GetHistoricMatchesResultDto fixture =
//		// m.getFixtures().getFixtureFromID(403261);
//		// ArrayList<Score> scores = new
//		// ArrayList<Score>(m.buildScoresForFixture(fixture));
//
//		for (int i = 1; i <= m.getFixtures().getAllFixtures().size(); i++) {
//			GetHistoricMatchesResultDto fixture = m.getFixtures().getAllFixtures()
//					.get(m.getFixtures().getAllFixtures().size() - i);
//			ArrayList<Score> scores = new ArrayList<Score>(m.buildScoresForFixture(fixture));
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
////		System.err.println(scores.get(3).getRound());
////		System.err.println(scores.get(3).getPlayer_id());
////		System.err.println(scores.get(3).getGoals());
////		System.err.println(scores.get(3).getAssists());
////		System.err.println(scores.get(3).getRed_cards());
////		System.err.println(scores.get(3).getYellow_cards());
////		System.err.println(scores.get(3).getApps());
////		System.err.println(scores.get(3).getClean_sheets());
////		System.err.println(scores.get(3).getConcede_Two());
////		System.err.println(scores.get(3).getFixture_id());
//	}
}
