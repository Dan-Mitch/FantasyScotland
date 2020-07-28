import online.FantasyScotlandOnlineApplication;

public class FantasyScotland {

	/** This is the main class for the Fantasy Soccer Scotland Applications */
	public static void main(String[] args) {

		System.out.println("---------------------------------");
		System.out.println("--- Fantasy Soccer Scotland   ---");
		System.out.println("---------------------------------");
		System.out.println("Starting Applciation...          ");
		System.out.println("---------------------------------");

		// command line switches
		boolean onlineMode = true;
		boolean printTestLog = false;

		// check the command line for what switches are active
		for (String arg : args) {

			if (arg.equalsIgnoreCase("-t"))
				printTestLog = true;

		}

		// Start the appropriate application
		if (onlineMode) {
			// Start the online application
			String[] commandArgs = { "server", "FantasyScotland.json" };
			FantasyScotlandOnlineApplication.main(commandArgs);
		}

	}

}
