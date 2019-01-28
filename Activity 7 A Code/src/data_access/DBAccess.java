package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import models.Album;
import models.Track;
import models.User;

@Stateless
@Local
@Alternative
public class DBAccess implements DBServiceInterface{

	//Connection Variables
		String dbURL = "jdbc:mysql//localhost:3306/cst361";
		String dbuser = "root";
		String dbpassword = "root";
		// load and register JDBC driver for MySQL 
		//Four CRUD operations
		//Create Operations
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
		public int insertAlbum(Album album) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ insertAlbum");
				stmt = c.prepareStatement("INSERT INTO cst361.albums VALUES (null, ?, ?)");
				stmt.setString(1, album.getAlbumTitle());
				stmt.setString(2, album.getAlbumArtist());
				rowsAffected = stmt.executeUpdate();
				System.out.println("Albums: ");
				// Give success message
				System.out.println(rowsAffected);
			} catch (SQLException e) {
				System.out.println("Error in communication with the database when insertAlbum is called...");
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
		//Read Operations
		public ArrayList<User> readAllUsers(){
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
					User u = new User(rs.getString("username"),
									  rs.getString("password"));
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
		public ArrayList<Album> readAllAlbums(){
			ArrayList<Album> albums = new ArrayList<>();
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ readAllAlbums");
				stmt = c.prepareStatement("SELECT * FROM cst361.albums");
				rs = stmt.executeQuery();
				System.out.println("Albums: ");
				// Process the rows in result set
				while (rs.next()) {
					System.out.print("ID: " + rs.getInt("id"));
					System.out.print(" | title: " + rs.getString("title"));
					System.out.print(" | artist: " + rs.getString("artist"));
					Album a = new Album(rs.getString("title"),
									  rs.getString("artist"));
					albums.add(a);
				}
				System.out.println("End of Users");
				rs.close();			
			} catch (SQLException e) {
				System.out.println("Error in communication with the database w/ readAllUsers...");
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
			return albums;
		}
		//Update Operation
		public int updateUser(int id, User user) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ updateUser");

				stmt = c.prepareStatement("UPDATE cst361.users "
										+ "SET "
										+ "username = ?, password = ? "
										+ "WHERE "
										+ "id = ?");
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
		public int updateAlbum(int id, Album album) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ updateAlbum");

				stmt = c.prepareStatement("UPDATE cst361.albums "
										+ "SET "
										+ "title = ?, artist = ? "
										+ "WHERE "
										+ "id = ?");
				stmt.setString(1, album.getAlbumTitle());
				stmt.setString(2, album.getAlbumArtist());
				stmt.setInt(3, id);
				
				rowsAffected = stmt.executeUpdate();
				System.out.println("Albums: ");
				// Give success message
				System.out.println(rowsAffected);

			} catch (SQLException e) {
				System.out.println("Error in communication with the database... w/ updateAlbum");
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
		//Delete Operations
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
		public int deleteAlbum(int id) {
			int rowsAffected = 0;
			// Connect
			Connection c = null;
			PreparedStatement stmt = null;
			try {
				c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success! w/ deleteAlbum");
				stmt = c.prepareStatement("DELETE FROM cst361.albums WHERE id = ?");
				stmt.setInt(1, id);
				rowsAffected = stmt.executeUpdate();
				// Give success message
				System.out.println("Album Deleted: " + id);
				System.out.println(rowsAffected);
			} catch (SQLException e) {
				System.out.println("Error in communication with the database... w/ deleteAlbum");
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
		//Search Operations
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
		public Album searchForAlbum(String username) {
			Album album = new Album();
			try {
				PreparedStatement stmt = null;
				ResultSet rs = null;
				Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success!");
				stmt = c.prepareStatement("SELECT * FROM cst361.albums WHERE title = ?");
				stmt.setString(1, username);
				rs = stmt.executeQuery();
				// Process the rows in result set
				while (rs.next()) {
					album = new Album(rs.getString("title"), rs.getString("artist"));
				}
				c.close();
				stmt.close();
				rs.close();			
			} catch (SQLException e) {
				System.out.println("Error in communication with the database... in searchForAlbum");
				e.printStackTrace();
			} 
			return album;
		}
		@Override
		public ArrayList<Track> searchForTracksByAlbumID(int id) {
			ArrayList<Track> tracks = new ArrayList<>();
			try {
				PreparedStatement stmt = null;
				ResultSet rs = null;
				Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success!");
				stmt = c.prepareStatement("SELECT title FROM cst361.songs WHERE albumID = ?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				// Process the rows in result set
				while (rs.next()) {
					tracks.add(new Track(rs.getString("title")));
				}
				c.close();
				stmt.close();
				rs.close();			
			} catch (SQLException e) {
				System.out.println("Error in communication with the database... in searchForTracksByAlbumID");
				e.printStackTrace();
			} 
			return tracks;
		}
		@Override
		public int searchForAlbumID(Album album) {
			int albumID = 0;
			try {
				PreparedStatement stmt = null;
				ResultSet rs = null;
				Connection c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
				System.out.println("Connection success!");
				stmt = c.prepareStatement("SELECT id FROM cst361.albums WHERE title = ?");
				stmt.setString(1, album.getAlbumTitle());
				rs = stmt.executeQuery();
				// Process the rows in result set
				while (rs.next()) {
					albumID = rs.getInt("id");
				}
				c.close();
				stmt.close();
				rs.close();			
			} catch (SQLException e) {
				System.out.println("Error in communication with the database... in searchForAlbumID");
				e.printStackTrace();
			} 
			return albumID;
		}
		@Override
		public ArrayList<Album> searchAlbumsByArtist(String artist) {
			ArrayList<Album> searchResults = new ArrayList<>();
			// Connect
					Connection c = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					try {
						c = DriverManager.getConnection(dbURL, dbuser, dbpassword);
						System.out.println("Connection success! w/ readAllAlbums");
						stmt = c.prepareStatement("SELECT * FROM cst361.albums WHERE artist = ?");
						stmt.setString(1, artist);
						rs = stmt.executeQuery();
						System.out.println("Albums: ");
						// Process the rows in result set
						while (rs.next()) {
							System.out.print("ID: " + rs.getInt("id"));
							System.out.print(" | title: " + rs.getString("title"));
							System.out.print(" | artist: " + rs.getString("artist"));
							Album a = new Album(rs.getString("title"),
											  rs.getString("artist"));
							searchResults.add(a);
						}
						System.out.println("End of Users");
						rs.close();			
					} catch (SQLException e) {
						System.out.println("Error in communication with the database w/ readAllUsers...");
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
