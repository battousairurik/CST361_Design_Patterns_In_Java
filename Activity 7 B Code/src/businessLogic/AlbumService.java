package businessLogic;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;

import interceptors.MethodExecutionInterceptor;
import models.Album;
import models.Track;

@Interceptors(MethodExecutionInterceptor.class)
@Local
@Stateless
public class AlbumService {
	
	@EJB 
	BusinessServiceInterface bsi;

	public String addAlbum(Album a) {
		String destination = "album_entry";
		//Orchestration
		//Step 1: Data Validation
		try {
			if(validateAlbumData(a)) {
			//Step 2: get Music Track Data from External Source
				//Put some code here that generates the songs for the Album
				ArrayList<Track> tracks = getTracks(a);
				for(Track track : tracks) {
					a.addTrackToAlbum(track);
				}
			//Step 3: persist music album to database (via call to DAO)
				bsi.insertAlbum(a);	
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
				destination = "home.xhtml";
			} else {
				//Album Data doesn't exist
				destination = "album_entry.xhtml";
			}
			
		} catch (Exception e) {
			System.out.println("Execption caught");
		}
		return destination;
	}
	
	
	public boolean validateAlbumData(Album album) {
		boolean result = false;
		Album dbAlbum = bsi.searchForAlbum(album.getAlbumTitle());
		if(album.getAlbumTitle().equals(dbAlbum.getAlbumTitle()) && album.getAlbumArtist().equals(dbAlbum.getAlbumArtist())) {
			result = true;
		}
		return result;
	}

	
	public ArrayList<Track> getTracks(Album album) {
		ArrayList<Track> tracks = new ArrayList<>();
		//Get Tracks
		tracks = bsi.searchForTracksByAlbumID(bsi.searchForAlbumID(album));
		return tracks;
	}
}
