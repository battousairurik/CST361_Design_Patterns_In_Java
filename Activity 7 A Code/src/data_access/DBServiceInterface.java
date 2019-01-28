package data_access;

import java.util.ArrayList;

import models.Album;
import models.Track;
import models.User;

public interface DBServiceInterface {

	// C operations
	public int insertUser(User user);

	public int insertAlbum(Album album);

	// R operations
	public ArrayList<User> readAllUsers();

	public ArrayList<Album> readAllAlbums();

	// U operations
	public int updateUser(int id, User user);

	public int updateAlbum(int id, Album album);

	// D operations
	public int deleteUser(int id);

	public int deleteAlbum(int id);

	// Search operations
	public User searchForUser(String username);

	public Album searchForAlbum(String albumTitle);

	public ArrayList<Track> searchForTracksByAlbumID(int id);

	public int searchForAlbumID(Album album);

	public ArrayList<Album> searchAlbumsByArtist(String artist);
}
