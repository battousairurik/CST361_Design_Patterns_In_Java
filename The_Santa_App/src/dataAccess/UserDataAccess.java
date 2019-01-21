package dataAccess;

import dataAccess.DBAccess;
import models.userAccount;

public class UserDataAccess {

	private DBAccess dbAccess;
	private userAccount user;

	public UserDataAccess() {
	}

	public void setUser(userAccount user) {
		if (verifyUser(user) == false) {

		}
		this.user = user;
	}
	
	public void SaveNewUser () {
		establishDBConnection();
		insertIntoDB();
		closeDBConn();
	}

	private Boolean verifyUser(userAccount user) {
		if (user.getUsername() == null) {
			return false;
		}
		if (user.getPassword() == null) {
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
		String command = "INSERT INTO UserTable VALUES (" + user.getUsername() + ", " + user.getPassword()
				+ ", " + user.getIsAdmin() + ")";
		dbAccess.executeCommand(command);
	}
}
