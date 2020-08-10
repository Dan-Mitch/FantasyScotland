package online.dwResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import online.dwViews.HomeScreenView;
import online.dwViews.LoginScreenView;
import online.dwViews.NewTeamScreenView;
import online.dwViews.RegisterScreenView;

@Path("/fantasyscotland") // Resources specified here should be hosted at http://localhost:7777/fantasyscotland
@Produces(MediaType.TEXT_HTML) // This resource returns HTML content

/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different HTML/Javascript Web pages for the FantasyScotland Application. 
 * @author richardm
 *
 */
public class GameWebPagesResource {

	@GET
	@Path("/")
	/**
	 * The selection screen for choosing whether to see past game statistics or
	 * play a game. Hosted at 'http://localhost:7777/fantasyscotland/'
	 * @return
	 */
    public LoginScreenView getLoginScreen() {
        return new LoginScreenView();
    }
	
	@GET
	@Path("/register")
	/**
	 * The Web page within which the user can play a game of FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/register'
	 * @return
	 */
    public RegisterScreenView getRegisterScreen() {
        return new RegisterScreenView();
    }
	
	@GET
	@Path("/newteam")
	/**
	 * The Web page within which the user can play a game of FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/newteam'
	 * @return
	 */
    public NewTeamScreenView getNewTeamScreen() {
        return new NewTeamScreenView();
    }
	
	@GET
	@Path("/home")
	/**
	 * The Web page within which the user can play a game of FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/newteam'
	 * @return
	 */
    public HomeScreenView getHomeScreen() {
        return new HomeScreenView();
    }
}
