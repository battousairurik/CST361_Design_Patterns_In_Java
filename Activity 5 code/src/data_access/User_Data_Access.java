package data_access;

import models.User;

public class User_Data_Access {

	private DBAccess dbAccess;
	private User user;

	public User_Data_Access() {
	}

	public void setUser(User user) {
		if (verifyUser(user) == false) {

		}
		this.user = user;
	}
	
	public void SaveNewUser () {
		establishDBConnection();
		insertIntoDB();
		closeDBConn();
	}

	private Boolean verifyUser(User user) {
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
		String command = "INSERT INTO users VALUES (" + user.getUsername() + ", " + user.getPassword()
				+ ")";
		dbAccess.executeCommand(command);
	}
}
