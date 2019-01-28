package models;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Album {
	//Private Fields
	private ArrayList<Track> tracksOnAlbum;
	private int numTracks;
	private String albumTitle;
	private String albumArtist;
	
	//Default No Argument Constructor
	public Album () {}
	//public constructor
	public Album (String albumTitle, String albumArtist) {
		setTracksOnAlbum(new ArrayList<Track>());
		this.setAlbumArtist(albumArtist);
		this.setAlbumTitle(albumTitle);
		this.setNumTracks(0);
	}
	public Album (String albumTitle, String albumArtist, ArrayList<Track> tracksOnAlbum) {
		this.setAlbumTitle(albumTitle);
		this.setAlbumArtist(albumArtist);
		this.setTracksOnAlbum(tracksOnAlbum);
		this.setNumTracks(tracksOnAlbum.size());
	}
	
	public void addTrackToAlbum (Track track) {
		this.tracksOnAlbum.add(track);
		this.setNumTracks(++numTracks);
	}
	
	//Getter and Setters for private fields
	public int getNumTracks() {
		return numTracks;
	}
	public void setNumTracks(int numTracks) {
		this.numTracks = numTracks;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getAlbumArtist() {
		return albumArtist;
	}
	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
	public ArrayList<Track> getTracksOnAlbum() {
		return tracksOnAlbum;
	}
	public void setTracksOnAlbum(ArrayList<Track> tracksOnAlbum) {
		this.tracksOnAlbum = tracksOnAlbum;
	}
	
}
