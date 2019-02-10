package dataAccess;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import models.Letter;
import models.User;

@Stateless
@Local
@Alternative
public class DBService implements DBServiceInterface {

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
	public int insertLetter(Letter letter) {
		int rowsAffected = 0;
		// Connect
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success! w/ insertLetter");
			stmt = c.prepareStatement("INSERT INTO cst361.letters VALUES (null, ?, ?)");
			stmt.setString(1, letter.getHeader());
			stmt.setString(2, letter.getBody());
			rowsAffected = stmt.executeUpdate();
			System.out.println("Letters: ");
			// Give success message
			System.out.println(rowsAffected);
		} catch (SQLException e) {
			System.out.println("Error in communication with the database when insertLetter is called...");
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
	public ArrayList<Letter> readAllLetters() {
		ArrayList<Letter> letters = new ArrayList<>();
		try {
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success! w/ readAllLetters");
			stmt = c.prepareStatement("SELECT * FROM cst361.letters");
			rs = stmt.executeQuery();
			System.out.println("Letters: ");
			// Process the rows in result set
			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(" | header: " + rs.getString("letterHeader"));
				System.out.print(" | body: " + rs.getString("letterBody"));
				Letter u = new Letter(rs.getString("letterHeader"), rs.getString("letterBody"));
				letters.add(u);
			}
			System.out.println("End of Letters");
			c.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error in communication with the database w/ readAllLetters...");
			e.printStackTrace();
		}
		return letters;
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
	public int updateLetter(int id, Letter letter) {
		int rowsAffected = 0;
		// Connect
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success! w/ updateLetter");

			stmt = c.prepareStatement(
					"UPDATE cst361.letters " + "SET " + "username = ?, password = ? " + "WHERE " + "id = ?");
			stmt.setString(1, letter.getHeader());
			stmt.setString(2, letter.getBody());
			stmt.setInt(3, id);

			rowsAffected = stmt.executeUpdate();
			System.out.println("Letters: ");
			// Give success message
			System.out.println(rowsAffected);

		} catch (SQLException e) {
			System.out.println("Error in communication with the database... w/ updateLetter");
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
	public int deleteLetter(int id) {
		int rowsAffected = 0;
		// Connect
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success! w/ deleteLetter");
			stmt = c.prepareStatement("DELETE FROM cst361.letters WHERE id = ?");
			stmt.setInt(1, id);
			rowsAffected = stmt.executeUpdate();
			// Give success message
			System.out.println("User Deleted: " + id);
			System.out.println(rowsAffected);

		} catch (SQLException e) {
			System.out.println("Error in communication with the database... w/ deleteLetter.");
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

	@Override
	public Letter searchForLetter(String letterHeader) {
		Letter letter = new Letter();
		try {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success!");
			stmt = c.prepareStatement("SELECT * FROM cst361.letters WHERE title = ?");
			stmt.setString(1, letterHeader);
			rs = stmt.executeQuery();
			// Process the rows in result set
			while (rs.next()) {
				letter = new Letter(rs.getString("letterHeader"), rs.getString("letterBody"));
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error in communication with the database... in searchForAlbum");
			e.printStackTrace();
		}
		return letter;
	}

	@Override
	public int searchForLetterID(Letter letter) {
		int letterID = 0;
		try {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success!");
			stmt = c.prepareStatement("SELECT id FROM cst361.albums WHERE header = ?");
			stmt.setString(1, letter.getHeader());
			rs = stmt.executeQuery();
			// Process the rows in result set
			while (rs.next()) {
				letterID = rs.getInt("id");
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error in communication with the database... in searchForLetterID");
			e.printStackTrace();
		}
		return letterID;
	}

	@Override
	public ArrayList<Letter> searchLettersByUser(String user) {
		ArrayList<Letter> searchResults = new ArrayList<>();
		// Connect
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connection success! w/ readAllAlbums");
			stmt = c.prepareStatement("SELECT * FROM cst361.albums WHERE user = ?");
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			System.out.println("Albums: ");
			// Process the rows in result set
			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(" | title: " + rs.getString("title"));
				System.out.print(" | artist: " + rs.getString("artist"));
				Letter a = new Letter(rs.getString("letterHeader"), rs.getString("letterBody"));
				searchResults.add(a);
			}
			System.out.println("End of Letters");
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error in communication with the database w/ searchLettersByUser...");
			e.printStackTrace();
		} finally {
			try {
				c.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return searchResults;
	}

}
