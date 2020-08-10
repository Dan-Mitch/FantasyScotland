package online.configuration;


import io.dropwizard.Configuration;

public class FantasyScotlandJSONConfiguration extends Configuration{

	/** This is the location of the deck file to load */
	String deckFile;
	
	/** This is the number of AI players to use */
	int numAIPlayers;

	/** Get the Deck File location */
	public String getDeckFile() {
		return deckFile;
	}

	/** Set the Deck File location */
	public void setDeckFile(String deckFile) {
		this.deckFile = deckFile;
	}

	/** Get the number of AI players to use */
	public int getNumAIPlayers() {
		return numAIPlayers;
	}

	/** Set the number of AI players to use */
	public void setNumAIPlayers(int numAIPlayers) {
		this.numAIPlayers = numAIPlayers;
	}
	
	
}