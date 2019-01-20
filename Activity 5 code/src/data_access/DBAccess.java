package data_access;

import java.sql.*;

public class DBAccess {

	private Connection conn;
	private Statement s;

	public DBAccess() {
	}

	public void setDefaultAccessDB() {
		try {
			// Set up Access Database TYpe
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Set up connection to actual database via location
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.accdb)};DBQ=Accounts.accdb;";
			// Set up connection with user-name and password
			conn = DriverManager.getConnection(database, "", "");
			// Connection statement manager
			
			System.out.println("DB connection successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setCustomDatabase() {

	}

	public void closeConnections() {
		try {
			// close and cleanup
			s.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void executeCommand(String command) {
		try {
			s = conn.createStatement();
			s.execute(command);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
