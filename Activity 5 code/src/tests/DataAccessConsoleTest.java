package tests;

import data_access.*;
import models.*;

public class DataAccessConsoleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testRunOne();
	}

	private static void testRunOne () {
		User user = new User();
		user.setUsername("usertwo");
		user.setPassword("newpassword");
		
		MusicAlbumEJB album = new MusicAlbumEJB("new album", "new artist");
		
		User_Data_Access userAccess = new User_Data_Access ();
		userAccess.setUser(user);
		userAccess.SaveNewUser();
		
		Music_Data_Access musicAccess = new Music_Data_Access();
		musicAccess.setMusicAlbum(album);
		musicAccess.saveAlbumToDatabase();
	}
}
