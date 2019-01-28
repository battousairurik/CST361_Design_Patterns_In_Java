package models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Track {
	
	private String trackTitle;
	
	public Track(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	
	
	
}
