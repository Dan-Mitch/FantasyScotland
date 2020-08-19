package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.pabloo99.xmlsoccer.api.dto.GetHistoricMatchesResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchEventsDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetMatchLineupsDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

import Constants.Scores;
import model.User;

import database.DatabaseLinker;

public class MainModel {

	private DatabaseLinker database;
	public static ArrayList<Club> clubs;
	private Players players;
	private static Fixtures fixtures;
	private ArrayList<League> leagues;
	private ArrayList<User> users;
	private XmlSoccerService xmlSoccerService;
	private boolean isRoundRunning;
	private OffsetDateTime nextUpdate;
	private OffsetDateTime nextBlock;
	
	public MainModel() {
		this.database = new DatabaseLinker();
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		MainModel.clubs = database.loadClubs();
		fixtures = new Fixtures(this.xmlSoccerService);
		this.players = new Players(database.loadPlayers());
		initialise();
		scheduleUpdate();
		scheduleBlock();
	}

	public void initialise() {
		this.nextUpdate = OffsetDateTime.of(MainModel.getRoundEndDate(), ZoneOffset.UTC).plusMinutes(1);
		this.nextBlock = OffsetDateTime.of(MainModel.getFixtures().getNextStartDate(MainModel.getTodayDate()), ZoneOffset.UTC).plusMinutes(1);   
		this.leagues = new ArrayList<League>(database.loadLeagues());
		this.users = new ArrayList<User>(database.loadUsers());	//Loads users and their teams.
	}
	
	public void isGameOver() {
		if(!MainModel.getTodayDate().isBefore(MainModel.getFixtures().endDateOfRound(MainModel.getFixtures().whatsLastRound()))) {
			System.err.println("The game has finished");
			System.exit(0);
		}
	}
	
	private void scheduleUpdate () {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run ( ) {
                try {
                	ZonedDateTime zdt = ZonedDateTime.of(getTodayDate(), ZoneId.systemDefault()); // Capture the current moment.
                    System.err.println( "Current moment: " + zdt ); // Report the current moment.
                    // Schedule the next run of this task.
                    OffsetDateTime now = OffsetDateTime.of(getTodayDate(), ZoneOffset.UTC);
                    if(!now.isBefore(nextUpdate)) {
                    	initialise();
                    	writePreviousFixtures();
                    	writeTeamScores();
                    	setTransferAll(true);	//Allows users to make transfers again at the start of the next round.    
                    	setRoundRunning(false);
                    }
                    System.err.println("Setting new schedule - Will next execute update at: " + nextUpdate.toString());
                    Duration d = Duration.between( now , nextUpdate ) ;
                    long seconds = d.toMillis() ; // Truncates any fractional second.
                    scheduledExecutorService.schedule( this , seconds , TimeUnit.MILLISECONDS );  // Delay will not be *exactly* this amount of time due to interruptions of scheduling cores on CPU and threads by the JVM and host OS.	
                } catch ( Exception e ) {
                    // TODO: Handle unexpected exeption.
                    System.err.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service. Message # 55cbae82-8492-4638-9630-60c5b28ad876." );
                }
            }
        };

        // Jump-start this perpetual motion machine.
        scheduledExecutorService.schedule( runnable , 0L , TimeUnit.SECONDS );  // Start immediately, no delay.
        try {
            Thread.sleep( TimeUnit.SECONDS.toMillis( 2 ) );  // Let our app, and the executor, run for 2 seconds, then shut them both down.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        System.out.println( "INFO - Executor shutting down. App exiting. " + ZonedDateTime.now( ZoneId.systemDefault() ) );

    }
	
	private void scheduleBlock () {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run ( ) {
                try {
                	ZonedDateTime zdt = ZonedDateTime.of(getTodayDate(), ZoneId.systemDefault()); // Capture the current moment.
                    System.out.println( "Current moment: " + zdt ); // Report the current moment.
                    // Schedule the next run of this task.
                    OffsetDateTime now = OffsetDateTime.of(getTodayDate(), ZoneOffset.UTC);            
                    if(!now.isBefore(nextBlock)) {
                    	isGameOver();
                    	initialise();
                    	setTransferAll(false);	//Blocks all users to make transfers again at the start of the next round.
                    	setRoundRunning(true);
                    }
                    System.err.println("Setting new schedule - Will next execute block at: " + nextBlock.toString());
                    Duration d = Duration.between( now , nextBlock ) ;
                    long seconds = d.toMillis() ; // Truncates any fractional second.
                    scheduledExecutorService.schedule( this , seconds , TimeUnit.MILLISECONDS );  // Delay will not be *exactly* this amount of time due to interruptions of scheduling cores on CPU and threads by the JVM and host OS.	
                } catch ( Exception e ) {
                    // TODO: Handle unexpected exeption.
                    System.err.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service. Message # 55cbae82-8492-4638-9630-60c5b28ad876." );
                }
            }
        };

        // Jump-start this perpetual motion machine.
        scheduledExecutorService.schedule( runnable , 0L , TimeUnit.SECONDS );  // Start immediately, no delay.
        try {
            Thread.sleep( TimeUnit.SECONDS.toMillis( 2 ) );  // Let our app, and the executor, run for 2 seconds, then shut them both down.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        System.out.println( "INFO - Executor shutting down. App exiting. " + ZonedDateTime.now( ZoneId.systemDefault() ) );

    }

	public void writePreviousFixtures() {
		for (GetHistoricMatchesResultDto fixture : fixtures.getAllFixtures()) {
			Date date = fixture.getDate();
			LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			if (fixtureDate.isBefore(MainModel.getTodayDate())) {
				if (!this.database.doesFixtureExist(fixture.getFixtureMatchId())) {
					this.database.writeFixture(fixture.getFixtureMatchId(), fixture.getRound(), fixture.getHomeTeamId(),
							fixture.getAwayTeamId());
					if (!this.database.doesScoreExist(fixture.getFixtureMatchId())) {
						ArrayList<Score> scores = new ArrayList<Score>(this.buildScoresForFixture(fixture));
						for (Score score : scores) {
							this.database.writeScore(score.getRound(), score.getPlayer_id(), score.getGoals(),
									score.getAssists(), score.getRed_cards(), score.getYellow_cards(), score.getApps(),
									score.getClean_sheets(), score.getConcede_Two(), score.getOwn_goals(),
									score.getFixture_id());
							if(!this.database.doesPlayerPointsExist(score.getPlayer_id(), score.getRound())) {
								this.database.writePlayerPoints(score.getPlayer_id(), score.getRound(),
										this.calculatePointsFrom(score));
							}
							else {
								continue;
							}
							
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

	public void writeTeamScores() {
		int currentRound = MainModel.getFixtures().whatsCurrentRound(getTodayDate());
		int previousRound = currentRound - 1;
		int twoPreviousRound = currentRound - 2;
		
		ArrayList<Team> teams = new ArrayList<Team>();
		for (User u : this.users) {
			teams.add(this.database.loadTeam(u.getId(), twoPreviousRound));
		}
		
		for (Team t : teams) {
			int weeklyScore = this.database.calculateTeamScore(t.getTeam_id(), previousRound);
			
			if(!this.database.doesTeamPointsExist(t.getTeam_id(), previousRound)) {
				this.database.writeTeamPoints(t.getTeam_id(), previousRound, weeklyScore);
			}
			else {
				continue;
			}
			HashMap<UUID,Integer> previousScores = this.database.getPreviousLeagueScores(t.getTeam_id());
			for(Map.Entry<UUID, Integer> entry : previousScores.entrySet()) {
				UUID league_id = entry.getKey();
				int score = entry.getValue();
				
				score +=weeklyScore;
				this.database.updateLeagueScore(league_id, t.getTeam_id(), score);
			}
			for(Map.Entry<Integer, Player> entry : t.getSquad().entrySet()) {
				int position = entry.getKey();
				Player player = entry.getValue();
				
				if(!this.database.doesTeamMembershipExist(t.getTeam_id(), player.getPlayer_id(), previousRound)) {
					this.database.writeTeamMembership(t.getTeam_id(), player.getPlayer_id(), previousRound, position);
				}
				else {
					continue;
				}
			}
		}
	}

	public int calculatePointsFrom(Score score) {
		int totalPoints = 0;
		String position = this.getPlayers().getPosition(score.getPlayer_id());

		if ((position).equals("Forward")) {
			totalPoints += Scores.GOAL_FOR.getValue() * score.getGoals();
		} else if ((position).equals("Defender")) {
			totalPoints += Scores.GOAL_DEF.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_DEF.getValue() * score.getClean_sheets();
			totalPoints += Scores.CONCEDE2_DEF.getValue() * score.getConcede_Two();
		} else if ((position).equals("Midfielder")) {
			totalPoints += Scores.GOAL_MID.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_MID.getValue() * score.getClean_sheets();
			totalPoints += Scores.CONCEDE2_MID.getValue() * score.getConcede_Two();
		} else if ((position).equals("Goalkeeper")) {
			totalPoints += Scores.GOAL_GK.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_GK.getValue() * score.getClean_sheets();
			totalPoints += Scores.CONCEDE2_GK.getValue() * score.getConcede_Two();
		}

		totalPoints += Scores.APPEARANCE.getValue() * score.getApps();
		totalPoints += Scores.ASSIST.getValue() * score.getAssists();

		totalPoints += Scores.OWN_GOAL.getValue() * score.getOwn_goals();
		totalPoints += Scores.RED_CARD.getValue() * score.getRed_cards();
		totalPoints += Scores.YELLOW_CARD.getValue() * score.getYellow_cards();

		return totalPoints;
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
			if (participant.getParticipantName().equals("Chris Kane")) {
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) {
				score.setPlayer_id(UUID.fromString("653e7499-9c43-4d50-b9af-4c991cd4d5bb"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 360) {
				score.setPlayer_id(UUID.fromString("a75b0120-4abc-4eb3-8ffa-2b7da60a7cf4"));
			} else
				try {
					score.setPlayer_id(this.getPlayers().getID(participant.getParticipantName()));
				} catch (NullPointerException e) {
					System.err.println("Could not find " + participant.getParticipantName() + " in the db.");
				}
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
			if (participant.getParticipantName().equals("Chris Kane")) {
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) {
				score.setPlayer_id(UUID.fromString("653e7499-9c43-4d50-b9af-4c991cd4d5bb"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 360) {
				score.setPlayer_id(UUID.fromString("a75b0120-4abc-4eb3-8ffa-2b7da60a7cf4"));
			} else
				try {
					score.setPlayer_id(this.getPlayers().getID(participant.getParticipantName()));
				} catch (NullPointerException e) {
					System.err.println("Could not find " + participant.getParticipantName() + " in the db.");
				}

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
	
	public HashMap<Integer,HashMap<Integer, Integer>> getPointHistory(UUID team_id){
		HashMap<Integer,HashMap<Integer, Integer>> history = new HashMap<Integer,HashMap<Integer, Integer>>();
		int lastRound = MainModel.getFixtures().whatsLastRound();
		int nullCount = 0;
		for(int i = 0; i<lastRound;i++) {
			HashMap<Integer, Integer> playersScores = new HashMap<Integer, Integer>();
			
			if(this.database.doesTeamExist(team_id, i)) {
				HashMap<Integer, Player> squad = this.database.loadSquad(team_id, i);
				
				for(Map.Entry<Integer, Player> entry : squad.entrySet()) {
					int position = entry.getKey();
					Player player = entry.getValue();
					if(this.database.doesPlayerPointsExist(player.getPlayer_id(), i+1)) {
						playersScores.put(position, this.database.getPlayerScoreIn(player.getPlayer_id(), i+1));

					}
					else {
						playersScores.put(entry.getKey(), null);
						nullCount++;
					}
				}
				history.put(i+1, playersScores);
			}
			else {
				continue;
			}
		}
		if(nullCount >= 11 && history.size() == 1) {
			return null;
		}
		else if(nullCount >= 11 && history.size() > 1) {
			history.remove(history.size());
		}
		return history;
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
	
	public boolean isTransferOn(UUID team_id) {
		return this.database.isTransferOn(team_id);
	}
	
	public void setTransfer(UUID team_id, boolean transfer) {
		this.database.setTransfer(team_id,transfer);
	}
	
	public void setTransferAll(boolean transfer) {
		this.database.setTransferAll(transfer);
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
				team.getCaptain());
		this.database.writeTeam(team.getTeam_id(), team.getOwner_id());
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.writeTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(),
					MainModel.getFixtures().whatsCurrentRound(getTodayDate())-1, entry.getKey());
		}
		this.database.writeLeagueMembership(UUID.fromString("3573e359-7c59-4d43-90c9-52d3ba04a66e"), team.getTeam_id(),
				0);
	}
	
	public void updateTeam(UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam();
		this.database.updateTeamDetails(team.getTeam_id(), team.getTransferBudget());
		
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.updateTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(),
					MainModel.getFixtures().whatsCurrentRound(getTodayDate())-1, entry.getKey());
		}
		this.database.setTransfer(team.getTeam_id(), false);
	}
	
	public int getRankIn(UUID league_id, UUID team_id) {
		return this.database.getRankInLeague(league_id, team_id);
	}
	
	public int getGlobalAverage() {
		return this.database.getGlobalAverage();
	}
	
	public int getGlobalMax() {
		return this.database.getGlobalMax();
	}
	
	public int getTeamTotal(UUID team_id) {
		return this.database.getTeamTotal(team_id);
	}

	public String addPlayerToTeam(UUID id, int position, UUID user_id) {
		Player player = this.players.getPlayer(id);
		return this.getUser(user_id).addPlayerToTeam(player, position);
	}

	public String removePlayerFromTeam(int position, UUID user_id) {
		return this.getUser(user_id).removePlayerFromTeam(position);
	}

	public void loadTeam(UUID user_id) {
		Team team = this.database.loadTeam(user_id, MainModel.fixtures.whatsCurrentRound(getTodayDate())-1);
		User user = this.getUser(user_id);
		user.setTeam(team);
	}

	public ArrayList<GetHistoricMatchesResultDto> getNextFixtures() {
		int nextRound = MainModel.fixtures.whatsCurrentRound(MainModel.getTodayDate());
		return MainModel.fixtures.whatFixturesIn(nextRound);
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
		for (Club c : MainModel.clubs) {
			if (c.getClub_id() == club_id) {
				clubName = c.getName();
			}
		}
		return clubName;
	}

	public static LocalDateTime getTodayDate() {
		LocalDateTime realDate = LocalDateTime.now().minusYears(1).withNano(0).withSecond(0).minusWeeks(2).minusDays(1).minusHours(2).minusMinutes(40);
		return realDate;
	}
	
	public static int getCurrentRound() {
		return getFixtures().whatsCurrentRound(getTodayDate());
	}
	
	public static LocalDateTime getRoundStartDate() {
		return getFixtures().startDateOfRound(getFixtures().whatsCurrentRound(getTodayDate()));
	}
	
	public static LocalDateTime getNextRoundStartDate() {
		return getFixtures().startDateOfRound(getFixtures().whatsCurrentRound(getTodayDate())+1);
	}
	
	
	public static LocalDateTime getRoundEndDate() {
		return getFixtures().endDateOfRound(getFixtures().whatsCurrentRound(getTodayDate()));
	}

	public static Fixtures getFixtures() {
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

	/**
	 * @return the isRoundRunning
	 */
	public boolean isRoundRunning() {
		return isRoundRunning;
	}

	/**
	 * @param isRoundRunning the isRoundRunning to set
	 */
	public void setRoundRunning(boolean isRoundRunning) {
		this.isRoundRunning = isRoundRunning;
	}
	

//	public static void main(String[] args) {
//		MainModel m = new MainModel();
//		System.err.println(MainModel.getFixtures().endDateOfRound(MainModel.getFixtures().whatsLastRound()));
//		System.err.println(m.database.loadSquad(UUID.fromString("acc727e3-5cdb-4f92-991a-b340cb471ba4"), 2));
//		System.err.println(m.getPointHistory(UUID.fromString("acc727e3-5cdb-4f92-991a-b340cb471ba4")));
//		System.err.println(MainModel.getRoundEndDate());
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
