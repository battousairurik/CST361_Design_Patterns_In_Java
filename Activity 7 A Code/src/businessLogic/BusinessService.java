package businessLogic;

import java.util.ArrayList;

import javax.ejb.EJB;

import data_access.DBServiceInterface;
import models.Album;
import models.Track;
import models.User;

public class BusinessService implements BusinessServiceInterface{

	@EJB
	DBServiceInterface db;
	
	@Override
	public int insertUser(User user) {
		return db.insertUser(user);
	}
	@Override
	public ArrayList<User> readAllUsers() {
		return db.readAllUsers();
	}
	@Override
	public int updateUser(int id, User user) {
		return db.updateUser(id, user);
	}
	@Override
	public int deleteUser(int id) {
		return db.deleteUser(id);
	}
	@Override
	public User searchForUser(String username) {
		return db.searchForUser(username);
	}
	@Override
	public int insertAlbum(Album album) {
		return db.insertAlbum(album);
	}
	@Override
	public ArrayList<Album> readAllAlbums() {
		return db.readAllAlbums();
	}
	@Override
	public int updateAlbum(int id, Album album) {
		return db.updateAlbum(id, album);
	}
	@Override
	public int deleteAlbum(int id) {
		return db.deleteAlbum(id);
	}
	@Override
	public Album searchForAlbum(String albumTitle) {
		return db.searchForAlbum(albumTitle);
	}
	@Override
	public ArrayList<Track> searchForTracksByAlbumID(int id) {
		return db.searchForTracksByAlbumID(id);
	}
	@Override
	public int searchForAlbumID(Album album) {
		return db.searchForAlbumID(album);
	}
	@Override
	public ArrayList<Album> searchAlbumsByArtist(String artist) {
		return db.searchAlbumsByArtist(artist);
	}

}
