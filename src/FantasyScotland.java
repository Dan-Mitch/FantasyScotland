import commandline.FantasyScotlandCLIApplication;

import online.TopTrumpsOnlineApplication;



public class FantasyScotland {

	/** This is the main class for the Fantasy Soccer Scotland Applications */
	public static void main(String[] args) {
		
		System.out.println("---------------------------------");
		System.out.println("--- Fantasy Soccer Scotland   ---");
		System.out.println("---------------------------------");
		
		// command line switches
		boolean onlineMode = false;
		boolean commandLineMode = false;
		boolean printTestLog = false;
		
		// check the command line for what switches are active
		for (String arg : args) {
			
			if (arg.equalsIgnoreCase("-t")) printTestLog=true;
			if (arg.equalsIgnoreCase("-c")) commandLineMode=true;
			if (arg.equalsIgnoreCase("-o")) onlineMode=true;
			
		}
		
		// We cannot run online and command line mode simultaniously
		if (onlineMode && commandLineMode) {
			System.out.println("ERROR: Both online and command line mode selected, select one or the other!");
			System.exit(0);
		}
		
		// Start the appropriate application
		if (onlineMode) {
			// Start the online application
			String[] commandArgs = {"server", "TopTrumps.json"};
			TopTrumpsOnlineApplication.main(commandArgs);
		} else if (commandLineMode) {
			// Start the command line application
			String[] commandArgs = {String.valueOf(printTestLog)};
			FantasyScotlandCLIApplication.main(commandArgs);
		}
		
	}
	
}
