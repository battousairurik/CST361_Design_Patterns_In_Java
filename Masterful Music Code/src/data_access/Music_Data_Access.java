package data_access;

import models.MusicAlbumEJB;

public class Music_Data_Access {

	private MusicAlbumEJB musicAlbum;
	private DBAccess dbAccess;
	
	public Music_Data_Access () {}
	
	public void setMusicAlbum (MusicAlbumEJB album) {
		if (verifyAlbum(album)==false) {
			//Logic for hat happens if the album has null information
			
			// goes here
		}
		musicAlbum = album;
	}
	
	public void saveAlbumToDatabase () {
		establishDBConnection();
		insertIntoDB();
		closeDBConn();
	}
	//Verify that the Album has correct parameters
	private Boolean verifyAlbum (MusicAlbumEJB album) {
		if (album.getAlbumTitle()==null) {
			return false;
		}
		if (album.getAlbumArtist()==null) {
			return false;
		}
		return true;
	}
	//Establish default access DB connection
	private void establishDBConnection () {
		dbAccess = new DBAccess();
		dbAccess.setDefaultAccessDB();
	}
	//close DB connection and execution controller
	private void closeDBConn () {
		dbAccess.closeConnections();
	}
	//insert statement
	private void insertIntoDB() {
		String command = "INSERT INTO music_albums VALUES (" + musicAlbum.getAlbumTitle()
		 + ", " + musicAlbum.getAlbumArtist() + ")";
		dbAccess.executeCommand(command);
	}
}
