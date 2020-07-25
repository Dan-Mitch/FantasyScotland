package commandline;
import model.MainModel;
import controller.MainController;

/**
 * Top Trumps command line application
 */
public class FantasyScotlandCLIApplication {

	/**
	 * This main method is called by FantasyScotland.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		//Create Instances of Classes
		MainModel model = new MainModel();
		MainController controller = new MainController();
		
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {
			
				controller.runtimeMenu();
			
			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			
			userWantsToQuit=true; // use this when the user wants to exit the game
			
		}


	}

}
