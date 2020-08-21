import online.FantasyScotlandOnlineApplication;

public class FantasyScotland {

	/** This is the main class for the Fantasy Soccer Scotland Applications */
	public static void main(String[] args) {
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("-----Fantasy Scotland------------");
		System.out.println("---------------------------------");
		System.out.println("-----Starting Applciation--------");
		System.out.println("---------------------------------");
		System.out.println("----------v0.7-------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("If loading for first time please ");
		System.out.println("allow for the scores and fixture ");
		System.out.println("history to build in the database.");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		// Start the online application
		String[] commandArgs = { "server", "FantasyScotland.json" };
		FantasyScotlandOnlineApplication.main(commandArgs);

	}

}
