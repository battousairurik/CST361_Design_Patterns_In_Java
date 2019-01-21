package dataAccess;

import models.letterToSanta;

public class LetterDataAccess {

	private DBAccess dbAccess;
	private letterToSanta letter;

	public LetterDataAccess() {
	}

	public void setUser(letterToSanta letter) {
		if (verifyUser(letter) == false) {

		}
		this.letter = letter;
	}
	
	public void SaveNewUser () {
		establishDBConnection();
		insertIntoDB();
		closeDBConn();
	}

	private Boolean verifyUser(letterToSanta letter) {
		if (letter.getLetterTitle() == null) {
			return false;
		}
		if (letter.getLetterBody() == null) {
			return false;
		}
		return true;
	}

	// Establish default access DB connection
	private void establishDBConnection() {
		dbAccess = new DBAccess();
		dbAccess.setDefaultAccessDB();
	}

	// close DB connection and execution controller
	private void closeDBConn() {
		dbAccess.closeConnections();
	}

	// insert statement
	private void insertIntoDB() {
		String command = "INSERT INTO LetterTable VALUES (" + letter.getUsername() + ", " + letter.getLetterTitle()
				+ ", " + letter.getLetterBody() + ", " + letter.getCompositionDate() + ")";
		dbAccess.executeCommand(command);
	}
}
