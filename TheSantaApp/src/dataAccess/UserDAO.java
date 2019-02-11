package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import businessLogic.BusinessService;
import models.User;

public class UserDAO implements UserDBInterface {

	@Inject
	public BusinessService bsi;
	
	// Connection Variables
		String dbURL = "jdbc:mysql//localhost:3306/cst361";
		String dbuser = "root";
		String dbpassword = "root";

		@Override
		public int insertUser(User user) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ insertUser");
				stmt = c.prepareStatement("INSERT INTO cst361.users VALUES (null, ?, ?)");
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				rowsAffected = stmt.executeUpdate();
				System.out.println("Users: ");
				// Give success message
				System.out.println(rowsAffected);
			} catch (SQLException e) {
				System.out.println("Error in communication with the database when insertUser is called...");
				e.printStackTrace();
			} finally {
				try {
					c.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return rowsAffected;
		}
	
		@Override
		public ArrayList<User> readAllUsers() {
			ArrayList<User> users = new ArrayList<>();
			try {
				// Connect
				Connection c = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ readAllUsers");
				stmt = c.prepareStatement("SELECT * FROM cst361.users");
				rs = stmt.executeQuery();
				System.out.println("Users: ");
				// Process the rows in result set
				while (rs.next()) {
					System.out.print("ID: " + rs.getInt("id"));
					System.out.print(" | username: " + rs.getString("username"));
					System.out.print(" | password: " + rs.getString("password"));
					User u = new User(rs.getString("username"), rs.getString("password"));
					users.add(u);
				}
				System.out.println("End of Users");
				c.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error in communication with the database w/ readAllUsers...");
				e.printStackTrace();
			}
			return users;
		}
		@Override
		public int updateUser(int id, User user) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ updateUser");

				stmt = c.prepareStatement(
						"UPDATE cst361.users " + "SET " + "username = ?, password = ? " + "WHERE " + "id = ?");
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				stmt.setInt(3, id);

				rowsAffected = stmt.executeUpdate();
				System.out.println("Users: ");
				// Give success message
				System.out.println(rowsAffected);

			} catch (SQLException e) {
				System.out.println("Error in communication with the database... w/ updateUser");
				e.printStackTrace();
			} finally {
				try {
					c.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rowsAffected;
		}
		@Override
		public int deleteUser(int id) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ deleteUser");
				stmt = c.prepareStatement("DELETE FROM cst361.users WHERE id = ?");
				stmt.setInt(1, id);
				rowsAffected = stmt.executeUpdate();
				// Give success message
				System.out.println("User Deleted: " + id);
				System.out.println(rowsAffected);

			} catch (SQLException e) {
				System.out.println("Error in communication with the database... w/ deleteUser");
				e.printStackTrace();
			} finally {
				try {
					c.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return rowsAffected;
		}
		@Override
		public User searchForUser(String username) {
			User user = new User();
			try {
				PreparedStatement stmt = null;
				ResultSet rs = null;
				Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success!");
				stmt = c.prepareStatement("SELECT * FROM cst361.users WHERE username = ?");
				stmt.setString(1, username);
				rs = stmt.executeQuery();
				// Process the rows in result set
				while (rs.next()) {
					user = new User(rs.getString("username"), rs.getString("password"));
				}
				c.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error in communication with the database... in searchForUser");
				e.printStackTrace();
			}
			return user;
		}
	
	
	public User findUser(String username, String password) {
		User searchResult = new User();
		User searchQuery = bsi.searchForUser(username);
		if(searchQuery.getPassword().equals(password)) {
			searchResult = searchQuery;
		}
		else {
			searchResult = null;
		}
		return searchResult;
	}
}
