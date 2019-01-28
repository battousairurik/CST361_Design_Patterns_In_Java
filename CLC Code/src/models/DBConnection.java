package models;

import java.io.File;
import java.sql.*;

public class DBConnection {

	private String connectionString;
	
	public String getConnectionString () {
		return connectionString;
	}
	
	public void setDefaultConnection () {
		try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("DriverLoaded");
            File f = new File ("C:\\Users\\Michael\\Documents\\Access Databases\\SantaAppDB.accdb");
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + f.getAbsolutePath();
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connection Established Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Could Not Connect to Database");
        }
	}
}
