package online.dwResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import online.dwViews.HomeScreenView;
import online.dwViews.LeagueScreenView;
import online.dwViews.LoginScreenView;
import online.dwViews.ManageScreenView;
import online.dwViews.NewTeamScreenView;
import online.dwViews.RegisterScreenView;
import online.dwViews.RulesScreenView;
import online.dwViews.TransferScreenView;

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
	 * The Web page within which the user can login to FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/'
	 * @return
	 */
    public LoginScreenView getLoginScreen() {
        return new LoginScreenView();
    }
	
	@GET
	@Path("/register")
	/**
	 * The Web page within which the user can register to play FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/register'
	 * @return
	 */
    public RegisterScreenView getRegisterScreen() {
        return new RegisterScreenView();
    }
	
	@GET
	@Path("/newteam")
	/**
	 * The Web page within which the user can create a team for FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/newteam'
	 * @return
	 */
    public NewTeamScreenView getNewTeamScreen() {
        return new NewTeamScreenView();
    }
	
	@GET
	@Path("/home")
	/**
	 * The Web page within which the user can view point history, team information and upcoming fixtures.
	 * Hosted at 'http://localhost:7777/fantasyscotland/home'
	 * @return
	 */
    public HomeScreenView getHomeScreen() {
        return new HomeScreenView();
    }
	
	@GET
	@Path("/manage")
	/**
	 * The Web page within which the user can manage their team, including changing captain and making substitutuions.
	 * Hosted at 'http://localhost:7777/fantasyscotland/manage'
	 * @return
	 */
    public ManageScreenView getManageScreen() {
        return new ManageScreenView();
    }
	
	@GET
	@Path("/leagues")
	/**
	 * The Web page within which the user can view the leaderboard for the public league.
	 * <p>
	 * Will be developed further in the future to include Private leagues.
	 * Hosted at 'http://localhost:7777/fantasyscotland/leagues'
	 * @return
	 */
    public LeagueScreenView getLeagueScreen() {
        return new LeagueScreenView();
    }
	
	@GET
	@Path("/transfer")
	/**
	 * The Web page within which the user can make transfers for their team and bring in new players.
	 * Hosted at 'http://localhost:7777/fantasyscotland/transfer'
	 * @return
	 */
    public TransferScreenView getTransferScreen() {
        return new TransferScreenView();
    }
	
	@GET
	@Path("/rules")
	/**
	 * The Web page within which the user can view the rules of FantasyScotland.
	 * Hosted at 'http://localhost:7777/fantasyscotland/rules'
	 * @return
	 */
    public RulesScreenView getRulesScreen() {
        return new RulesScreenView();
    }
	
}
