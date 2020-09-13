package online.dwResources;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.pabloo99.xmlsoccer.api.dto.GetHistoricMatchesResultDto;

import io.dropwizard.jersey.sessions.Session;
import model.*;

@Path("/fantasyscotland") // Resources specified here should be hosted at http://localhost:7777/fantasyscotland
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods.
 * <p>
 * This class is adapted from an old Top Trumps team development project. Only the configuration files and 
 * service setup was utilised for this project. No other code that was developed was used.
 * 
 */
public class FantasyScotlandRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	private MainModel model;
	
	//______________________________________INITIALISATION_____________________________________________________________
	/**
	 * Contructor method for the REST API. This is called first. It is where the model for the application is
	 * instantiated.
	 */
	public FantasyScotlandRESTAPI() {
		this.model = new MainModel();
	}
	
	//_____________________________________RESTAPI_METHODS______________________________________________________________
	//____________________BOOLEAN_METHODS______________________________________
	@GET
	@Path("/isRoundRunning")
	/**
	 * This method checks wether a round has started and fixtures are being played.
	 * <p>
	 * Called when user enters the manage screen.
	 * @param session the session of the user
	 * @return a boolean indicating if the round has started or not 
	 * @throws IOException
	 */
	public boolean isRoundRunning(@Session HttpSession session) throws IOException {
		return this.model.isRoundRunning();
	}
	
	@GET
	@Path("/isTransferOn")
	/**
	 * This method checks wether a team is permitted to make transfers.
	 * <p>
	 * Called when user enters the transfer screen.
	 * @param session the session of the user
	 * @return a boolean indicating if transfers are permitted for the team or not
	 * @throws IOException
	 */
	public boolean isTransferOn(@Session HttpSession session) throws IOException {
		Team team = this.model.getUser((UUID)session.getAttribute("id")).getTeam();
		return this.model.isTransferOn(team.getTeam_id());
	}
	
	@GET
	@Path("/userSignedIn")
	/**
	 * This method checks wether a user has logged in and authenticated.
	 * <p>
	 * Called when user tries to enter any screen other than login or register.
	 * @param session the session of the user
	 * @return a boolean indicating if user has authenticated or not
	 * @throws IOException
	 */
	public boolean userSignedIn(@Session HttpSession session) throws IOException {
		if(session.getAttribute("id") == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * This is the method that is called when a user has entered their details into the field and attempted to log in.
	 * <p>
	 * When the user logs in successfully, the session they log in with is tagged by setting attributes for the user's email and user_id. The id attribute is used to display all other related
	 * information in the application.
	 * @param email the email address entered by the user
	 * @param pass the unencrypted password entered by the user
	 * @param session  the session of the user
	 * @return a boolean indicating if the login was successful or not
	 * @throws IOException
	 */
	@POST
	@Path("/auth")
	public boolean authenticateUser(@QueryParam("Email") String email, @QueryParam("Pass") String pass, @Session HttpSession session) throws IOException {
		System.err.println(session.toString());
		UUID id = this.model.authenticateUser(email, pass);
		if(id != null) {
			session.setAttribute("email", email); 
			session.setAttribute("id", id); //http session is tagged with user's id
			return true;
		}
		return false;
	}
	
	@GET
	@Path("/userExists")
	/**
	 * This method checks to see if a user exists on the database during user registration.
	 * @param email the email address entered by the user
	 * @return a boolean indicating if the user exists on the database
	 * @throws IOException
	 */
	public boolean doesUserExist(@QueryParam("Email") String email) throws IOException {
		return this.model.doesUserExist(email);
	}
	
	@GET
	@Path("/teamExists")
	/**
	 * Used to indicate wether a user has completed the team creation process and is called after a user has been
	 * authenticated for login.
	 * <p>
	 * Called after user logs in.
	 * @param email the email address entered by the user
	 * @return a boolean indicating wether a team exists on the database or not
	 * @throws IOException
	 */
	public boolean doesTeamExist(@QueryParam("Email") String email) throws IOException {
		return this.model.doesTeamExist(email);
	}
	
	@GET
	@Path("/duplicateExists")
	/**
	 * This method is called to check if duplciate players exist in a team after a player is added or removed.
	 * <p>
	 * It is called during the new team creation to assert if the team meets the criteria and if the continue button should be displayed.
	 * @param session the session of the user
	 * @return a boolean indicating wether a duplicate player exists in the team or not
	 * @throws IOException
	 */
	public boolean doesDuplicateExist(@Session HttpSession session) throws IOException {
		String response = this.model.getUser((UUID)session.getAttribute("id")).getTeam().duplicatePlayers();
		if(response != null) {
			return true;
		}
		return false;
	}
	
	@GET
	@Path("/clubLimitReached")
	/**
	 * This method is called to check if more than three players from the same club exist in the team.
	 * <p>
	 * It is called during the new team creation when the user adds or removes players, to assert if the team meets the criteria and if the continue button should be displayed.
	 * @param session the session of the user
	 * @return a boolean indicating wether three or more players from the same club exist in the team
	 * @throws IOException
	 */
	public boolean clubLimitReached(@Session HttpSession session) throws IOException {
		String response = this.model.getUser((UUID)session.getAttribute("id")).getTeam().clubLimitReached();
		if(response != null) {
			return true;
		}
		return false;
	}
	
	//____________________VOID_METHODS______________________________________
	
	@GET
	@Path("/signOut")
	/**
	 * This method signs the user out by removing any set attributes on the current session.
	 * <p>
	 * Called when user presses the sign out button.
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void signOut(@Session HttpSession session) throws IOException {
		session.setAttribute("email", null);
		session.setAttribute("id", null);
	}
	
	@POST
	@Path("/register")
	/**
	 * This method is called when a user has finished registering an account. 
	 * <p>
	 * It sends the users information to be stored in the database and autmoatically authenticates and logs the user in
	 * for team creation.
	 * @param email the email address entered by the user
	 * @param pass the unencrypted password entered by the user
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void registerUser(@QueryParam("Email") String email, @QueryParam("Pass") String pass, @Session HttpSession session) throws IOException {
		this.model.registerUser(email,pass);
		this.authenticateUser(email, pass, session);
	}
	
	@GET
	@Path("/registerTeam")
	/**
	 * This method is called when a user has finished creating a team that has met all the criteria. 
	 * <P>
	 * It sends all the user's team data to the database to be stored including the team name and the selected players and their positions.
	 * @param name the name of the team 
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void registerTeam(@QueryParam("Name") String name, @Session HttpSession session) throws IOException {
		this.model.registerTeam(name, (UUID)session.getAttribute("id"));
	}
	
	@GET
	@Path("/updateTeam")
	/**
	 * This method is called when the user has confirmed they want to make changes when making transfers to the team.
	 * <p>
	 * The database is updated with the changes to the team and players positions in the team.
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void updateTeam(@Session HttpSession session) throws IOException {
		this.model.updateTeam((UUID)session.getAttribute("id"));
	}
	
	@GET
	@Path("/manageTeam")
	/**
	 * This method is called when the user has confirmed they want to make changes when managing their team.
	 * <p>
	 * The database is updated with the changes to the team and players' positions in the team.
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void manageTeam(@Session HttpSession session) throws IOException {
		this.model.manageTeam((UUID)session.getAttribute("id"));
	}
	
	@GET
	@Path("/loadTeam")
	/**
	 * This method is called when a user has successfully logged in. It searches the database for the associated team of a user, using the user's uuid and attaches
	 * the team object to the user before it is loaded into the view.
	 * <p>
	 * It is called when the user enters the home screen after logging in. It also unnecessarily is called by league, manage, rules and transfer screens.
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void loadTeam(@Session HttpSession session) throws IOException {
		this.model.loadTeam((UUID) session.getAttribute("id"));
	}
	
	@GET
	@Path("/setCaptain")
	/**
	 * This method is called when a user wants to manage their team and selects a new captain.
	 * @param position integer indicating the position of the player in the team selected to be captain
	 * @param session the session of the user
	 * @throws IOException
	 */
	public void setCaptain(@QueryParam("Pos") int position, @Session HttpSession session) throws IOException {
		this.model.setCaptain((UUID)session.getAttribute("id"), position);
	}
	
	//____________________STRING_METHODS______________________________________
	
	@GET
	@Path("/addPlayer")
	/**
	 * This method is called when a user is creating a team and adds a player into the model.
	 * @param id uuid of the team 
	 * @param position integer indicating the position in the team
	 * @param session the session of the user
	 * @return a string message indicating success or error
	 * @throws IOException
	 */
	public String addPlayer(@QueryParam("Id") UUID id, @QueryParam("Pos") int position, @Session HttpSession session) throws IOException {
		String response = this.model.addPlayerToTeam(id,position, (UUID)session.getAttribute("id"));
		String responseAsJSONString = oWriter.writeValueAsString(response);
		return responseAsJSONString;
	}
	
	@GET
	@Path("/swapPlayers")
	/**
	 * This method is called when a user is managing their team and substitutes one of their players on the field for one on the bench.
	 * @param id uuid of the team 
	 * @param position integer indicating the position in the team
	 * @param session the session of the user
	 * @return a json string message indicating success or error
	 * @throws IOException
	 */
	public String swapPlayers(@QueryParam("Id") UUID id, @QueryParam("Pos") int position, @Session HttpSession session) throws IOException {
		String response = this.model.swapPlayersInTeam(id,position, (UUID)session.getAttribute("id"));
		String responseAsJSONString = oWriter.writeValueAsString(response);
		return responseAsJSONString;
	}
	
	@GET
	@Path("/removePlayer")
	/**
	 * This method is called when a user is creating a team and removes a player from the model.
	 * @param position integer indicating the position in the team
	 * @param session  the session of the user
	 * @return a json string message indicating success or error
	 * @throws IOException
	 */
	public String removePlayer(@QueryParam("Pos") int position, @Session HttpSession session) throws IOException {
		String response = this.model.removePlayerFromTeam(position, (UUID)session.getAttribute("id"));
		String responseAsJSONString = oWriter.writeValueAsString(response);
		return responseAsJSONString;
	}
	
	@GET
	@Path("/removeAllPlayers")
	/**
	 * This method is called when a user is creating a team and clicks the remove all players button.
	 * <p>
	 * It conveniently iterates through all the players in the team and removes them from the team object in the model.
	 * @param session the session of the user
	 * @return a json string message indicating success or error
	 * @throws IOException
	 */
	public String removeAllPlayers(@Session HttpSession session) throws IOException {
		Set<Integer> keys = new HashSet<Integer>(this.model.getUser((UUID)session.getAttribute("id")).getTeam().getSquad().keySet());
		for(int i : keys) {
			this.model.removePlayerFromTeam(i, (UUID)session.getAttribute("id"));
		}
		String responseAsJSONString = "Successfully removed all players.";
		return responseAsJSONString;
	}
	
	@GET
	@Path("/buildPlayers")
	/**
	 * This method is called to load and send the full list of players as a json string to each of the views that require it.
	 * <P>
	 * Called when user enters new team, transfer, manage and home screens.
	 * @param session the session of the user
	 * @return a json string of a list of all the players
	 * @throws IOException
	 */
	public String buildPlayers(@Session HttpSession session) throws IOException {
		ArrayList<Player> listOfPlayers = this.model.getPlayers().getPlayers();
		String listAsJSONString = oWriter.writeValueAsString(listOfPlayers);
		return listAsJSONString;
	}
	
	@GET
	@Path("/buildClubs")
	/**
	 * This method is called to load in all the clubs in the database and send the list as a json string to each of the views that require it.
	 * <p>
	 * Called when user enters new team, manage and transfer screens.
	 * @return a json string of a list of all the clubs in the premiership
	 * @throws IOException
	 */
	public String buildClubs() throws IOException {
		ArrayList<Club> listOfClubs = MainModel.clubs;
		String listAsJSONString = oWriter.writeValueAsString(listOfClubs);
		return listAsJSONString;
	}
	
	@GET
	@Path("/buildUser")
	/**
	 * This method is called to load the user's profile and team in and send it to each of the views that require it.
	 * <p>
	 * It is called by all of the views at the beginning of laoding, apart from login and register screens
	 * @param session the session of the user
	 * @return a User object as a json string
	 * @throws IOException
	 */
	public String buildUser(@Session HttpSession session) throws IOException {
		User user = this.model.getUser((UUID)session.getAttribute("id"));
		String userAsJSONString = oWriter.writeValueAsString(user);
		return userAsJSONString;
	}
	
	@GET
	@Path("/buildNextFixtures")
	/**
	 * This method returns a list of the next fixtures being played in the upcoming round as a json string.
	 * <p>
	 * It is called when the user enters the home screen.
	 * @param session the session of the user
	 * @return a list of upcoming fixtures as a json string
	 * @throws IOException
	 */
	public String buildNextFixtures(@Session HttpSession session) throws IOException {
		ArrayList<GetHistoricMatchesResultDto> listOfFixtures = this.model.getNextFixtures();
		String listAsJSONString = oWriter.writeValueAsString(listOfFixtures);
		return listAsJSONString;
	}
	
	@GET
	@Path("/buildPointHistory")
	/**
	 * This method is called to generate a nested HashMap containing the players scores for each round played.
	 * <p>
	 * It is called when the user enters the home screen.
	 * @param session the session of the user
	 * @return a nested HashMap of point history as a json string
	 * @throws IOException
	 */
	public String buildPointHistory(@Session HttpSession session) throws IOException {
		Team team = this.model.getUser((UUID)session.getAttribute("id")).getTeam();
		String listAsJSONString = oWriter.writeValueAsString(this.model.getPointHistory(team.getTeam_id()));
		return listAsJSONString;
	}
	
	@GET
	@Path("/getRankIn")
	/**
	 * This method is called to display the league position of a team in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param league_id uuid of the public league
	 * @param session the session of the user
	 * @return the integer position of the team in the public league as a json string
	 * @throws IOException
	 */
	public String getRankIn(@QueryParam("Id") UUID league_id, @Session HttpSession session) throws IOException {
		Team team = this.model.getUser((UUID)session.getAttribute("id")).getTeam();
		int rank = this.model.getRankIn(league_id, team.getTeam_id());
		System.err.println(rank);
		String rankAsJSONString = oWriter.writeValueAsString(rank);
		return rankAsJSONString;
	}
	
	@GET
	@Path("/getGlobalMax")
	/**
	 * This method is called to display the highest score of all teams in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param session the session of the user
	 * @return the highest score of all users in the public league as a json string
	 * @throws IOException
	 */
	public String getGlobalMax(@Session HttpSession session) throws IOException {
		int globalMax = this.model.getGlobalMax();
		String maxAsJSONString = oWriter.writeValueAsString(globalMax);
		return maxAsJSONString;
	}
	
	@GET
	@Path("/getGlobalAvg")
	/**
	 * This method is called to display the average score of all teams in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param session the session of the user
	 * @return the average score of all users in the public league as a json string
	 * @throws IOException
	 */
	public String getGlobalAvg(@Session HttpSession session) throws IOException {
		int globalAvg = this.model.getGlobalAverage();
		String avgAsJSONString = oWriter.writeValueAsString(globalAvg);
		return avgAsJSONString;
	}
	
	@GET
	@Path("/getTeamTotal")
	/**
	 * This method is called to display the all time total score of a team in the public league.
	 * <p>
	 * Called when a user enters the home screen.
	 * @param session the session of the user
	 * @return the total score of a team in the public league as a json string
	 * @throws IOException
	 */
	public String getTeamTotal(@Session HttpSession session) throws IOException {
		Team team = this.model.getUser((UUID)session.getAttribute("id")).getTeam();
		int teamTotal = this.model.getTeamTotal(team.getTeam_id());
		String avgAsJSONString = oWriter.writeValueAsString(teamTotal);
		return avgAsJSONString;
	}
	
	@GET
	@Path("/getPublicRankings")
	/**
	 * This method is called to return an ordered leaderboard of all teams in the public league
	 * <p>
	 * Called when the user enters the league screen.
	 * @return  an ordered list of teams and their scores as a json string
	 * @throws IOException
	 */
	public String getPublicRankings() throws IOException {
		ArrayList<Ranking> rankings = this.model.getPublicRankings();
		String rankingsAsJSONString = oWriter.writeValueAsString(rankings);
		return rankingsAsJSONString;
	}
	
	@GET
	@Path("/getNameFrom")
	/**
	 * This method is called to determine the name of a team's captain from their id number.
	 * <p>
	 * It is called and dispalyed when the user enters the home screen and
	 * @param id the uuid of the captain
	 * @param session the session of the user
	 * @return the full name of the captain as a json string
	 * @throws IOException
	 */
	public String getNameFrom(@QueryParam("Id") UUID id,@Session HttpSession session) throws IOException {
		String name = this.model.getPlayers().getPlayer(id).getName();
		String nameAsJSONString = oWriter.writeValueAsString(name);
		return nameAsJSONString;
	}
	
	@GET
	@Path("/getCurrentRound")
	/**
	 * This method returns the current round according to the current date/time.
	 * <p>
	 * It is called and displayed when the user enters the home screen.
	 * @return the upcoming round number as a json string
	 * @throws IOException
	 */
	public String getCurrentRound() throws IOException {
		int round = MainModel.getCurrentRound();
		String roundAsJSONString = oWriter.writeValueAsString(round);
		return roundAsJSONString;
	}
	
	@GET
	@Path("/getStartDate")
	/**
	 * This method returns the start date/time of the upcoming round.
	 * <p>
	 * It is called and displayed when the user enters the home screen.
	 * @return the start date/time of the upcoming round as a json string
	 * @throws IOException
	 */
	public String getstartDate() throws IOException {
		LocalDateTime startDate = MainModel.getRoundStartDate();
		String startAsJSONString = oWriter.writeValueAsString(startDate);
		return startAsJSONString;
	}
	
	@GET
	@Path("/getEndDate")
	/**
	 * This method returns the end date/time of the upcoming round.
	 * <p>
	 * It is called and displayed when the user enters the home screen.
	 * @return the end date/time of the upcoming round
	 * @throws IOException
	 */
	public String getEndDate() throws IOException {
		LocalDateTime endDate = MainModel.getRoundEndDate();
		String endAsJSONString = oWriter.writeValueAsString(endDate);
		return endAsJSONString;
	}
	
}