package online;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import online.configuration.FantasyScotlandJSONConfiguration;
import online.dwResources.FantasyScotlandRESTAPI;
import online.dwResources.GameWebPagesResource;

import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * Top Trumps Web Application. This class is complete, you do not need to edit
 * it, you instead need to complete FantasyScotlandRESTAPI and the HTML/Javascript
 * views.
 */
public class FantasyScotlandOnlineApplication extends Application<FantasyScotlandJSONConfiguration> {

	/**
	 * This is the main class for the Top Trumps Web application. It is called by
	 * FantasyScotland.java when the user specifies that they want to run in online mode.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new FantasyScotlandOnlineApplication().run(args); // Create a new online application and run it
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * This is the Dropwizard run method after argument parsing has happened
	 */
	public void run(FantasyScotlandJSONConfiguration conf, Environment environment) throws Exception {

		// Enable CORS headers (see
		// https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		cors.setInitParameter("allowCredentials", "true");
		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		// Dropwizard expresses things that the user can ask for as resources. We have
		// two of
		// these, the REST api and the HTML/Javascript Webpages

		// REST API
		FantasyScotlandRESTAPI restAPI = new FantasyScotlandRESTAPI(conf);

		// HTML/Javascript Webpages
		GameWebPagesResource gameScreen = new GameWebPagesResource();

		// Registration tells Dropwizard to host a resource
		environment.jersey().register(restAPI);
		environment.jersey().register(gameScreen);
		environment.servlets().setSessionHandler(new SessionHandler());
		environment.jersey().register(HttpSessionProvider.class);
	}

	/**
	 * Get the name of the application
	 */
	@Override
	public String getName() {
		return "Fantasy Scotland";
	}

	/**
	 * An initalization method that attaches the Configuration to the views
	 */
	@Override
	public void initialize(Bootstrap<FantasyScotlandJSONConfiguration> bootstrap) {
		bootstrap.addBundle(new ViewBundle<FantasyScotlandJSONConfiguration>());
	}
}
