package models;

import java.util.ArrayList;

public class MusicAlbumEJB {

	private ArrayList<AlbumTrack> tracksOnAlbum;
	private String AlbumTitle;
	private String AlbumArtist;
	
	//public constructor
	public MusicAlbumEJB (String albumTitle, String albumArtist) {
		tracksOnAlbum = new ArrayList<AlbumTrack>();
		this.AlbumArtist = albumArtist;
		this.AlbumTitle = albumTitle;
	}
	public int getNumberOfTracks () {
		return tracksOnAlbum.size();
	}
	public void addNewTrack (String trackTitle) {
		AlbumTrack track = new AlbumTrack();
		track.setTrackTitle(trackTitle);
		track.setMusicAlbum(AlbumTitle);
		track.setTrackNumber(tracksOnAlbum.size() + 1);
	}
		
	//return an index of a song based on the track title searched
	public int getTrackNumber (String trackTitle) {
		for (AlbumTrack track : tracksOnAlbum) {
			if (trackTitle == track.getTrackTitle()) {
				return tracksOnAlbum.indexOf(track);
			}
		}
		return 0;
	}
	
	
	
	//Default getter and setters for private fields
	public String getAlbumTitle() {
		return AlbumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		AlbumTitle = albumTitle;
	}
	public String getAlbumArtist() {
		return AlbumArtist;
	}
	public void setAlbumArtist(String albumArtist) {
		AlbumArtist = albumArtist;
	}
}
