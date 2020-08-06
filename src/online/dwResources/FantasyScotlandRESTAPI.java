package online.dwResources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import online.configuration.FantasyScotlandJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import model.*;

@Path("/fantasyscotland") // Resources specified here should be hosted at http://localhost:7777/fantasyscotland
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a FantasyScotland game to be controled from a Web page.
 */
public class FantasyScotlandRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a FantasyScotlandJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	
	private MainModel model;
	
	public FantasyScotlandRESTAPI(FantasyScotlandJSONConfiguration conf) {
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
		
		this.model = new MainModel();
	}
	
	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	
	@GET
	@Path("/helloJSONList")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String helloJSONList() throws IOException {
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Hello");
		listOfWords.add("World!");
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
	}
	
	@GET
	@Path("/helloWord")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String helloWord(@QueryParam("Word") String Word) throws IOException {
		return "Hello "+Word;
	}
	
	@POST
	@Path("/auth")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public boolean authenticateUser(@QueryParam("Email") String email, @QueryParam("Pass") String pass) throws IOException {
		return this.model.authenticateUser(email,pass);
	}
	
	@GET
	@Path("/userExists")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public boolean doesUserExist(@QueryParam("Email") String email) throws IOException {
		return this.model.doesUserExist(email);
	}
	
	@GET
	@Path("/teamExists")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public boolean doesTeamExist(@QueryParam("Email") String email) throws IOException {
		return this.model.doesTeamExist(email);
	}
	
	@POST
	@Path("/register")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public void registerUser(@QueryParam("Email") String email, @QueryParam("Pass") String pass) throws IOException {
		this.model.registerUser(email,pass);
	}
	
	@GET
	@Path("/addPlayer")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String addPlayer(@QueryParam("Id") UUID id, @QueryParam("Pos") int position) throws IOException {
		System.out.println("addplayer" + id);
		String response = this.model.addPlayerToTeam(id,position);
		String responsetAsJSONString = oWriter.writeValueAsString(response);
		return responsetAsJSONString;
	}
	
	@GET
	@Path("/buildPlayers")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String buildPlayers() throws IOException {
		
		ArrayList<Player> listOfPlayers = this.model.getPlayers().getPlayers();
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfPlayers);
		return listAsJSONString;
	}
	
	@GET
	@Path("/buildClubs")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String buildClubs() throws IOException {
		
		ArrayList<Club> listOfClubs = MainModel.clubs;
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfClubs);
		return listAsJSONString;
	}
	
	@GET
	@Path("/buildTeam")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String buildTeam() throws IOException {
		
		Team team = this.model.getCurrentUser().getTeam();
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String teamAsJSONString = oWriter.writeValueAsString(team);
		
		return teamAsJSONString;
	}
	
	@GET
	@Path("/buildUser")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String buildUser() throws IOException {
		
		User user = this.model.getCurrentUser();
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String userAsJSONString = oWriter.writeValueAsString(user);
		
		return userAsJSONString;
	}
}