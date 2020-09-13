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

/**
 * This is the main model for the whole application. It includes critical methods for calculating the scores, scheduling execitions and acts as a bridge between the RESTAPI resources and
 * the database.
 * @author d_mit
 *
 */
public class MainModel {
	/**
	 * A public list of all the clubs used by the application
	 */
	public static ArrayList<Club> clubs;
	private DatabaseLinker database;
	private Players players;
	private static Fixtures fixtures;
	private ArrayList<League> leagues;
	private ArrayList<User> users;
	private XmlSoccerService xmlSoccerService; //XML Soccer API
	private boolean isRoundRunning; //blocks all team manage activity if false
	private OffsetDateTime nextUpdate;
	private OffsetDateTime nextBlock;
	
	/**
	 * The constructor first initialises a connection with both the remote database and the football data API. It then loads all the data from the backend that is unchanged by the application including clubs, players
	 * and fixtures. Another initialisation method is then called and then both the scheduled exection services are started.
	 */
	public MainModel() {
		this.database = new DatabaseLinker();
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA"); //XML Soccer config
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		MainModel.clubs = database.loadClubs();
		fixtures = new Fixtures(this.xmlSoccerService);
		this.players = new Players(database.loadPlayers());
		initialise();
		scheduleUpdate();
		scheduleBlock();
	}
	
	/**
	 * This is an initialisation method that is first called when the application is started and then called again each time one of the scheduled executions commenences.
	 * <p>
	 * It first determines the two dates the scheduled executors should next execute and then loads and refreshes user and league data from the database, incase new users and leagues have been created.
	 */
	public void initialise() {
		this.nextUpdate = OffsetDateTime.of(MainModel.getRoundEndDate(), ZoneOffset.UTC); //date for next update 
		this.nextBlock = OffsetDateTime.of(MainModel.getFixtures().getNextStartDate(MainModel.getTodayDate()), ZoneOffset.UTC).plusMinutes(1);  //date for next block 
		this.leagues = new ArrayList<League>(database.loadLeagues()); //Loads all leagues
		this.users = new ArrayList<User>(database.loadUsers());	//Loads users and their teams.
	}
	
	/**
	 * This method is used to terminate the whole application. It is called at the start of every round.
	 * <p>
	 * It acts as a placeholder to a more intuative end game solution that aims to display a final screen of results rather than terminate the whole application.
	 */
	public void isGameOver() {
		if(!MainModel.getTodayDate().isBefore(MainModel.getFixtures().endDateOfRound(MainModel.getFixtures().whatsLastRound()))) { //checks date of last round and if we have passed it
			System.err.println("The game has finished");
			System.exit(0);
		}
	}
	
	//_________________________________________________________SCHEDULING__________________________________________________________________________________________
	
	/**
	 * This method is called at the end of a round to build the scores for each player, team and store each score along with the fixtures played, into the database. It also re-enables transfer activity
	 * and team managment functionaility.
	 * <p>
	 * This method is adapted from https://stackoverflow.com/a/54050020
	 */
	public void scheduleUpdate () {
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
                    scheduledExecutorService.schedule( this , seconds , TimeUnit.MILLISECONDS );  // Schedules new date for task to be run.	
                } catch ( Exception e ) {
                    System.err.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service." );
                    e.printStackTrace();
                }
            }
        };

        // Jump-start this perpetual motion machine.
        scheduledExecutorService.schedule( runnable , 0L , TimeUnit.SECONDS );  // Start immediately, no delay.
        try {
            Thread.sleep( TimeUnit.SECONDS.toMillis( 2 ) );  // run for 2 seconds, then shut them both down.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        //scheduledExecutorService.shutdown();
    }
	
	/**
	 * This method is called at the start of a round to firstly check if the whole game was over and then to disable transfer and team managment activity while the round is in progress.
	 * <p>
	 * This method is adapted from https://stackoverflow.com/a/54050020
	 */
	public void scheduleBlock () {
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
                    	setRoundRunning(true); //blocks users making team managment changes
                    }
                    System.err.println("Setting new schedule - Will next execute block at: " + nextBlock.toString());
                    Duration d = Duration.between( now , nextBlock ) ;
                    long seconds = d.toMillis() ; // Truncates any fractional second.
                    scheduledExecutorService.schedule( this , seconds , TimeUnit.MILLISECONDS );  // Schedules new date for task to be run.	
                } catch ( Exception e ) {
                    System.err.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service." );
                    e.printStackTrace();
                }
            }
        };

        // Jump-start this perpetual motion machine.
        scheduledExecutorService.schedule( runnable , 0L , TimeUnit.SECONDS );  // Start immediately, no delay.
        try {
            Thread.sleep( TimeUnit.SECONDS.toMillis( 2 ) );  // run for 2 seconds, then shut them both down.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        //scheduledExecutorService.shutdown();
    }
	
	//_________________________________________________________SCORE_BUILDING__________________________________________________________________________________________

	/**
	 * This is the main score builidng method. It stores the previous fixtures played, calls helper methods to build individual score cards for each of the players in each fixture and caluculate a points tally based on that scorecard,
	 * then it stores the score cards and player scores in the database also.
	 */
	public void writePreviousFixtures() {
		for (GetHistoricMatchesResultDto fixture : fixtures.getAllFixtures()) { //get all the fixtures 
			Date date = fixture.getDate();
			LocalDateTime fixtureDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().minusHours(2); //minus two hours to ensure time has definetly been past and reduce related errors
			if (fixtureDate.isBefore(MainModel.getTodayDate())) { //if fixture is in the past
				if (!this.database.doesFixtureExist(fixture.getFixtureMatchId())) {
					this.database.writeFixture(fixture.getFixtureMatchId(), fixture.getRound(), fixture.getHomeTeamId(), //write previous fixture to database
							fixture.getAwayTeamId());
					if (!this.database.doesScoreExist(fixture.getFixtureMatchId())) {
						ArrayList<Score> scores = new ArrayList<Score>(this.buildScoresForFixture(fixture)); //call helper method to build all scores for fixture
						for (Score score : scores) {
							this.database.writeScore(score.getRound(), score.getPlayer_id(), score.getGoals(), //write each scorecard to database
									score.getAssists(), score.getRed_cards(), score.getYellow_cards(), score.getApps(),
									score.getClean_sheets(), score.getConcede_Two(), score.getOwn_goals(),
									score.getFixture_id());
							if(!this.database.doesPlayerPointsExist(score.getPlayer_id(), score.getRound())) {
								this.database.writePlayerPoints(score.getPlayer_id(), score.getRound(), //calculate points using helper method and store points in database for each player
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
	
	/**
	 * Helper method used for building all the individual score cards for each player that appears in a fixture.
	 * <p>
	 * The method first makes a call to the football data api to get the full list of players in the lineup and match event data for the fixture.
	 * The method then uses the lineup data to see who started in a fixture, and then iterates through each of the match events for each player that started, counting each of the events
	 * the player was involved in. The same process is repeated for the benched players.
	 * <p>
	 * Unfortunately due to an error with the returned API data, a hard coded solution had to be implemented to stop a String mismatch. The API returns two different versions of the same persons name.
	 * @param fixture a fixture object returned by the api
	 * @return a list of all the scores for the fixture
	 */
	public ArrayList<Score> buildScoresForFixture(GetHistoricMatchesResultDto fixture) {
		int fixture_id = fixture.getFixtureMatchId();
		ArrayList<Score> scores = new ArrayList<Score>();
		List<GetMatchLineupsDto> lineups = xmlSoccerService.getMatchLineupsByFixtureMatchId(fixture_id).stream() //list of players in the lineup for fixture
				.collect(Collectors.toList());
		List<GetMatchEventsDto> match_events = xmlSoccerService.getMatchEventsByFixtureMatchId(fixture_id).stream() //list of match events for fixture
				.collect(Collectors.toList());
		ArrayList<GetMatchLineupsDto> substitutes = new ArrayList<GetMatchLineupsDto>(); //empty list for players starting on the bench
		ArrayList<GetMatchLineupsDto> starters = new ArrayList<GetMatchLineupsDto>(); //empty list for players starting on the field

		for (GetMatchLineupsDto participant : lineups) { //split lineup into starters and subs lists
			if (participant.getLineupType().equals("Coach")) {
				continue;
			} else if (participant.getLineupType().equals("Substitute player")) {
				substitutes.add(participant);
			} else {
				starters.add(participant);
			}
		}

		for (GetMatchLineupsDto participant : starters) { //build scores for all the starters
			Score score = new Score(); //initailsation
			int goals = 0;
			int assists = 0;
			int red_cards = 0;
			int yellow_cards = 0;
			score.setApps(1); //set appearances to 1 as they all start from the beginning of fixture
			int clean_sheets = calculateCleanSheet(fixture, participant); //uses helper method (did the team not have any goals scored against them?)
			int concedeTwo = calculateConcedeTwo(fixture, participant);	//uses helper method (does the team concede more than two goals?)
			int own_goals = 0;
			if (participant.getParticipantName().equals("Chris Kane")) { //hard coded fix - api was returning Christopher and Chris for seperate fixtures, Christopher only one on database
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) { //there are two Ross Stewarts who play for different teams
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
				if (event.getParticipantName().equals(participant.getParticipantName())) { //start iterating through match events for each player
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
			scores.add(score); //add to arraylist of all scores
		}
		
		for (GetMatchLineupsDto participant : substitutes) { //build scores for all subs
			Score score = new Score();
			int goals = 0;
			int assists = 0;
			int red_cards = 0;
			int yellow_cards = 0;
			int clean_sheets = calculateCleanSheet(fixture, participant); //uses helper method (did the team not have any goals scored against them?)
			int concedeTwo = calculateConcedeTwo(fixture, participant); //uses helper method (does the team concede more than two goals?)
			int own_goals = 0;
			if (participant.getParticipantName().equals("Chris Kane")) { //hard coded fix - api was returning Christopher and Chris for seperate fixtures, Christopher only one on database
				score.setPlayer_id(UUID.fromString("599b7145-5388-4722-aca5-2cddd5f3b7e2"));
			} else if (participant.getParticipantName().equals("Ross Stewart") && participant.getTeamId() == 560) { //there are two Ross Stewarts in the SPFL who play for different teams
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
			for (GetMatchEventsDto event : match_events) { //start iterating through match events for each player
				if (event.getParticipantName() == null) {
					continue;
				}
				if (event.getParticipantName().equals(participant.getParticipantName())) {
					String action = event.getEventName();
					if (action.equals("Substitution in")) { //additional check to see if benched player was eventually subbed on to make an appearance
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
				scores.add(score); //add to arraylist of all scores
			}
		}
		return scores;
	}

	/**
	 * This is a helper method used in the score building process to calculate if a player recieved a clean sheet in a fixture.
	 * <p>
	 * This is when the team has no goals scored against them. 
	 * @param fixture a fixture object from the football api
	 * @param participant a player object from the api
	 * @return an integer indicating if a clean sheet occured or not
	 */
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

	/**
	 * This is a helper method used in the score building process to calculate if a player conceded more than two goals.
	 * @param fixture a fixture object from the football api
	 * @param participant a player object from the api
	 * @return an integer indicating if more than two goals were conceded
	 */
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
	
	/**
	 * This is a helper method used for calculating a points tally for a given score of a player.
	 * <p>
	 * The method uses predefined enum constants to return integer values based off of the different recorded match events and the player's position.
	 * @param score a score card recording the different match events a player was involved in during a fixture
	 * @return an integer points total calculated from the score
	 */
	public int calculatePointsFrom(Score score) {
		int totalPoints = 0; //initialise
		String position = this.getPlayers().getPosition(score.getPlayer_id());

		if ((position).equals("Forward")) { //if player is a forward
			totalPoints += Scores.GOAL_FOR.getValue() * score.getGoals(); //clean sheet and concede more than 2 goals, only applies to other positions
		} else if ((position).equals("Defender")) { //if player is a defender
			totalPoints += Scores.GOAL_DEF.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_DEF.getValue() * score.getClean_sheets(); 
			totalPoints += Scores.CONCEDE2_DEF.getValue() * score.getConcede_Two();
		} else if ((position).equals("Midfielder")) { //if player is a midfielder
			totalPoints += Scores.GOAL_MID.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_MID.getValue() * score.getClean_sheets();
			totalPoints += Scores.CONCEDE2_MID.getValue() * score.getConcede_Two();
		} else if ((position).equals("Goalkeeper")) { //if player is a goalkeeper
			totalPoints += Scores.GOAL_GK.getValue() * score.getGoals();
			totalPoints += Scores.CLEAN_GK.getValue() * score.getClean_sheets();
			totalPoints += Scores.CONCEDE2_GK.getValue() * score.getConcede_Two();
		}
		//general scores not related to player's position
		totalPoints += Scores.APPEARANCE.getValue() * score.getApps();
		totalPoints += Scores.ASSIST.getValue() * score.getAssists();

		totalPoints += Scores.OWN_GOAL.getValue() * score.getOwn_goals();
		totalPoints += Scores.RED_CARD.getValue() * score.getRed_cards();
		totalPoints += Scores.YELLOW_CARD.getValue() * score.getYellow_cards();

		return totalPoints;
	}

	/**
	 * This is the second and last score builidng method that compliles all the individual player scores from the database, builds and stores a team score aswell as initialising each of the teams 
	 * for the next round and updating scores and rankings in the leagues.
	 */
	public void writeTeamScores() {
		int currentRound = MainModel.getFixtures().whatsCurrentRound(getTodayDate()); //round after fixture round that has just finished
		int previousRound = currentRound - 1; //round where fixtures just took place
		int twoPreviousRound = currentRound - 2; //round when team was last stored in database
		
		ArrayList<Team> teams = new ArrayList<Team>();
		for (User u : this.users) {
			if(this.database.doesTeamExist(u.getEmail()) != null){ //if the user has registered an account has also made a team
				teams.add(this.database.loadTeam(u.getId(), twoPreviousRound)); //load last stored team from database 
			}
			else {
				continue; //if account hasnt registered team, continue.
			}
			
		}
		
		for (Team t : teams) {
			int weeklyScore = this.database.calculateTeamScore(t.getTeam_id(), previousRound); //calls method in database to calculate team score from stored player scores
			
			if(!this.database.doesTeamPointsExist(t.getTeam_id(), previousRound)) {
				this.database.writeTeamPoints(t.getTeam_id(), previousRound, weeklyScore); //then stores player score in database
			}
			else {
				continue;
			}
			HashMap<UUID,Integer> previousScores = this.database.getPreviousLeagueScores(t.getTeam_id()); //gets the previous league score for each league team is in
			for(Map.Entry<UUID, Integer> entry : previousScores.entrySet()) {
				UUID league_id = entry.getKey();
				int score = entry.getValue();
				
				score +=weeklyScore; //appends previous scores with new score
				this.database.updateLeagueScore(league_id, t.getTeam_id(), score); //updates database
			}
			
			for(Map.Entry<Integer, Player> entry : t.getSquad().entrySet()) { //for each player in the team, record their membership and set it for the next round
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
	
	//_________________________________________________________REST_API_METHODS__________________________________________________________________________________________
	
	//_______________________________WRITE METHODS_________________________________
	/**
	 * This acts as a bridging method between the RESTAPI and the database. It is called when a user first registers an account with the application.
	 * @param email validated email string 
	 * @param pass unencrypted string 
	 */
	public void registerUser(String email, String pass) {
		;
		this.database.writeUser(email, pass);
	}
	
	/**
	 * This acts as a bridging method between the RESTAPI and the database. It is called when a user registers a team for the first time with the application.
	 * <p>
	 * It calls three seperate methods that store each of the related data about the team into the database.
	 * @param name the name of the team
	 * @param id the uuid of the user
	 */
	public void registerTeam(String name, UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam();
		if (name.contains("'")) { //validation check to double up any single quotes that cant be processed by the database as its in UTF-8 format
			String newName = name.replace("'", "''"); 
			team.setName(newName);
		} else {
			team.setName(name);
		}
		team.setTeam_id(UUID.randomUUID());
		team.setRandomCaptain(); //sets random captain
		this.database.writeTeamDetails(team.getTeam_id(), team.getName(), team.getTransferBudget(),
				team.getCaptain());
		this.database.writeTeam(team.getTeam_id(), team.getOwner_id());
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.writeTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(),
					MainModel.getFixtures().whatsCurrentRound(getTodayDate())-1, entry.getKey());
		}
		this.database.writeLeagueMembership(UUID.fromString("3573e359-7c59-4d43-90c9-52d3ba04a66e"), team.getTeam_id(), //registers ever team to the global public league
				0);
	}
	
	/**
	 * This method is called when a user is creating a team and adds a player into the model.
	 * @param id uuid of the team 
	 * @param position integer indicating the position in the team
	 * @param user_id uuid of the user
	 * @return a string message indicating success or error
	 */
	public String addPlayerToTeam(UUID id, int position, UUID user_id) {
		Player player = this.players.getPlayer(id);
		return this.getUser(user_id).addPlayerToTeam(player, position);
	}
	
	/**
	 * This method is called when a user is managing their team and substitutes one of their players on the field for one on the bench.
	 * @param id uuid of the team 
	 * @param position integer indicating the position in the team
	 * @param user_id uuid of the user
	 * @return a string message indicating success or error
	 */
	public String swapPlayersInTeam(UUID id, int position, UUID user_id) {
		Player player = this.players.getPlayer(id);
		return this.getUser(user_id).swapPlayersInTeam(player, position);
	}

	/**
	 * This method is called when a user is creating a team and removes a player from the model.
	 * @param position integer indicating the position in the team
	 * @param user_id uuid of the user
	 * @return a string message indicating success or error
	 */
	public String removePlayerFromTeam(int position, UUID user_id) {
		return this.getUser(user_id).removePlayerFromTeam(position);
	}

	//_______________________________UPDATE METHODS_________________________________
	
	/**
	 * This method is called when the user has confirmed they want to make changes when managing their team.
	 * <p>
	 * The database is updated with the changes to the team and players positions in the team.
	 * @param id the uuid of the user
	 */
	public void manageTeam(UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam(); //get team of user
		this.database.updateTeamDetails(team.getTeam_id(), team.getTransferBudget(), team.getCaptain()); //in the case of manageTeam, only the captain attribute of the team may be changed in this version
		
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.updateTeamPositions(team.getTeam_id(), entry.getValue().getPlayer_id(), //players' current memberships updated with swapped positions
					MainModel.getFixtures().whatsCurrentRound(getTodayDate())-1, entry.getKey());
		}
	}
	
	/**
	 * This method is called when the user has confirmed they want to make changes when making transfers to the team.
	 * <p>
	 * The database is updated with the changes to the team and players' positions in the team.
	 * @param id the uuid of the user
	 */
	public void updateTeam(UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam(); //get team of user
		this.database.updateTeamDetails(team.getTeam_id(), team.getTransferBudget(), team.getCaptain()); //in the case of updateTeam, the transferbudget of the team is all that changes
		
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.updateTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(), //team's current memberships updated with new player
					MainModel.getFixtures().whatsCurrentRound(getTodayDate())-1, entry.getKey());
		}
		this.database.setTransfer(team.getTeam_id(), false); //disable any more transfer activity till the next round starts
	}
	//_______________________________GETTER METHODS_________________________________
	
	/**
	 * This method when called, runs an instance of the history thread amd returns the generated HashMap of the point history for a team.
	 * <p>
	 * The point history building was refactored to run as a thread in an attempt to stop request timeouts when the app was deployed. 
	 * @param team_id the uuid of the team 
	 * @return a HashMap of the point history of the team
	 */
	public HashMap<Integer,HashMap<Integer, Integer>> getPointHistory(UUID team_id) {
		HistoryThread historyThread = new HistoryThread(team_id);
		Thread thread = new Thread(historyThread);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return historyThread.getHistory();
	}

	/**
	 * This method is called when a user attempts to login. It acts as a bridge between the database and the RESTAPI resources.
	 * <p>
	 * When a new user logs in, it adds the user object to an arraylist of all users in the application. If an existing user logs in, it removes the instance of the user in the list and re-adds it.
	 * @param email the email string entered by the user 
	 * @param pass the password entered by the user
	 * @return the uuid of the user
	 */
	public UUID authenticateUser(String email, String pass) {
		String response = this.database.authenticateUser(email, pass);
		if (response != null && !response.isEmpty()) { //does user exist on database?
			UUID id = UUID.fromString(response);
			if (this.getUser(id) == null) { //if user is new to the application
				users.add(new User(email, id));
			} else {
				users.remove(this.getUserIndex(id)); //if user has logged in before
				users.add(new User(email, id));
			}
			return id;
		}
		return null;
	}
	
	/**
	 * This method is called when a user has successfully logged in. It searches the database for the associated team of a user, using the user's uuid.
	 * <p>
	 * Once the team has been found it is set as an attribute of the user.
	 * @param user_id the uuid of the user
	 */
	public void loadTeam(UUID user_id) {
		Team team = this.database.loadTeam(user_id, MainModel.fixtures.whatsCurrentRound(getTodayDate())-1);
		User user = this.getUser(user_id);
		user.setTeam(team);
	}
	
	/**
	 * This method is called when a user attempts to access the transferScreen. It checks the database to see if the team is permitted to make transfer activity. It will return false
	 * if transfers are not premitted and true if they are.
	 * @param team_id uuid of the team
	 * @return boolean indicating if transfers are allowed or not
	 */
	public boolean isTransferOn(UUID team_id) {
		return this.database.isTransferOn(team_id);
	}
	
	/**
	 * This method is called when a user is registering a new account. Before a new account is stored, this check is called to make sure a user is not already registed with the same email address.
	 * @param email the email string entered by the user 
	 * @return boolean indicating wether a user is already registered on the database
	 */
	public boolean doesUserExist(String email) {
		String id = this.database.doesUserExist(email);
		if (id != null && !id.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is called when a user logs in. It checks the database to see if the user has finished the team creation process and decide what view to direct the user to.
	 * @param email the email string entered by the user 
	 * @return boolean indicating wether a team has been created for a user
	 */
	public boolean doesTeamExist(String email) {
		UUID team_id = this.database.doesTeamExist(email);
		if (team_id != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method is called to display the league position of a team in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param league_id uuid of the public league
	 * @param team_id uuid of the team
	 * @return the integer position of the team in the public league
	 */
	public int getRankIn(UUID league_id, UUID team_id) {
		return this.database.getRankInLeague(league_id, team_id);
	}
	
	/**
	 * This method is called to display the average score of all teams in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @return the average score of all users in the public league
	 */
	public int getGlobalAverage() {
		return this.database.getGlobalAverage();
	}
	
	/**
	 * This method is called to display the highest score of all teams in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @return the highest score of all users in the public league
	 */
	public int getGlobalMax() {
		return this.database.getGlobalMax();
	}
	
	/**
	 * This method is called to display the all time total score of a team in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param team_id the uuid of a team
	 * @return the total score of a team in the public league
	 */
	public int getTeamTotal(UUID team_id) {
		return this.database.getTeamTotal(team_id);
	}
	
	/**
	 * This method is called to return an ordered leaderboard of all teams in the public league
	 * <p>
	 * Called when the user enters the league screen.
	 * @return an ordered list of teams and their scores
	 */
	public ArrayList<Ranking> getPublicRankings(){
		return this.database.getPublicRankings();
	}

	/**
	 * This method returns a list of the next fixtures being played in the upcoming round.
	 * <p>
	 * Called when the user enters the home screen.
	 * @return a list of upcoming fixtures
	 */
	public ArrayList<GetHistoricMatchesResultDto> getNextFixtures() {
		int nextRound = MainModel.fixtures.whatsCurrentRound(MainModel.getTodayDate());
		return MainModel.fixtures.whatFixturesIn(nextRound);
	}

	/**
	 * 
	 * @return players
	 */
	public Players getPlayers() {
		return players;
	}

	/**
	 * 
	 * @return users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * This method returns the user with a given id number.
	 * @param id uuid of the user
	 * @return user object or null
	 */
	public User getUser(UUID id) {
		for (User u : this.getUsers()) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * This method is called the determine the index number of a user object held in the list of all users in the application.
	 * <p>
	 * It is used to remove and re-add an existing user to the lsit, who is logging in again.
	 * @param id the uuid of the user
	 * @return the indexed location of the user object in the list
	 */
	public int getUserIndex(UUID id) {
		ArrayList<User> u = this.getUsers();
		User user = this.getUser(id);
		return u.indexOf(user);
	}
	
	/**
	 * 
	 * @return fixtures
	 */
	public static Fixtures getFixtures() {
		return fixtures;
	}

	/**
	 * @return leagues
	 */
	public ArrayList<League> getLeagues() {
		return leagues;
	}

	/**
	 * Returns the local date time the application is running on.
	 * <p>
	 * Since this is a simualtion of the 19/20 season, it is set back by 1 year.
	 * @return the date and time (minus 1 year)
	 */
	public static LocalDateTime getTodayDate() {
		LocalDateTime realDate = LocalDateTime.now().minusYears(1).withNano(0);
		return realDate;
	}
	
	/**
	 * This method returns the current round according to the current date/time.
	 * @return the upcoming round number
	 */
	public static int getCurrentRound() {
		return getFixtures().whatsCurrentRound(getTodayDate());
	}
	
	/**
	 * 
	 * @return the start date/time of the upcoming round
	 */
	public static LocalDateTime getRoundStartDate() {
		return getFixtures().startDateOfRound(getFixtures().whatsCurrentRound(getTodayDate()));
	}
	
	/**
	 * 
	 * @return the start date/time of the next round
	 */
	public static LocalDateTime getNextRoundStartDate() {
		return getFixtures().startDateOfRound(getFixtures().whatsCurrentRound(getTodayDate())+1);
	}
	
	/**
	 *  
	 * @return the end date/time of the upcoming round
	 */
	public static LocalDateTime getRoundEndDate() {
		return getFixtures().endDateOfRound(getFixtures().whatsCurrentRound(getTodayDate()));
	}

	/**
	 * This method is called to check if team management activity is permitted.
	 * @return the isRoundRunning
	 */
	public boolean isRoundRunning() {
		return isRoundRunning;
	}

	//_______________________________SETTER METHODS_________________________________
	/**
	 * This method is called when a schedule block occurs at the start of a round.
	 * @param isRoundRunning the isRoundRunning to set
	 */
	public void setRoundRunning(boolean isRoundRunning) {
		this.isRoundRunning = isRoundRunning;
	}
	
	/**
	 * @param leagues the leagues to set
	 */
	public void setLeagues(ArrayList<League> leagues) {
		this.leagues = leagues;
	}
	
	/**
	 * This method is called when a user wants to manage their team and selects a new captain.
	 * @param user_id uuid of the user who wants to manage their captain
	 * @param position integer indicating the position of the player in the team selected to be captain
	 */
	public void setCaptain(UUID user_id, int position) {
		this.getUser(user_id).getTeam().setCaptain(position);
	}
	
	/**
	 * This method is called when a user has made a transfer before a round starts.
	 * <p>
	 * It sets the transfer boolean of the team in the database to false so no more transfer ativity ccan occur before the next round.
	 * @param team_id uuid of the team 
	 * @param transfer boolean indicating if transfers are permitted or not
	 */
	public void setTransfer(UUID team_id, boolean transfer) {
		this.database.setTransfer(team_id,transfer);
	}
	
	/**
	 * This method is called during a schedule update after a round has finished.
	 * <p>
	 * It sets all of the teams' transfer boolean to true so that every team can make transfers for the next round.
	 * @param transfer
	 */
	public void setTransferAll(boolean transfer) {
		this.database.setTransferAll(transfer);
	}
}