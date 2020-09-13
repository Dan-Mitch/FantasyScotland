import online.FantasyScotlandOnlineApplication;
/**
 * Fantasy Scotland is the main base class for starting the whole application.
 * It makes a call to the online application to start the server on localhost.
 * @author d_mit
 *
 */
public class FantasyScotland {

	/**
	 * This method calls the online application file to start the server using the 
	 * ports contained in the FantasyScotland.json file.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-----Fantasy Scotland------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-----Starting Applciation--------------------");
		System.out.println("---------------------------------------------");
		System.out.println("----------v1.0-------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-----http://localhost:7777/fantasyscotland---");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		// Start the online application on localhost
		String[] commandArgs = { "server", "FantasyScotland.json" };
		FantasyScotlandOnlineApplication.main(commandArgs);

	}

}
