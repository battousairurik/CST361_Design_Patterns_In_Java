package data_access;

import javax.inject.Inject;
import business.BusinessServiceInterface;
import models.Album;

public class AlbumDAO {

	@Inject
	public BusinessServiceInterface bsi;

	public Album findAlbum(String title, String artist) {
		Album searchResult = new Album();
		Album searchQuery = bsi.searchForAlbum(title);
		if (searchQuery.getAlbumArtist().equals(artist)) {
			searchResult = searchQuery;
		} else {
			searchResult = null;
		}
		return searchResult;
	}
}
