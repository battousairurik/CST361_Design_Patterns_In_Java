package models;

import java.util.Date;

public class letterToSanta {

	private String username;
	private String letterTitle;
	private String letterBody;
	private Date compositionDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLetterTitle() {
		return letterTitle;
	}
	public void setLetterTitle(String letterTitle) {
		this.letterTitle = letterTitle;
	}
	public String getLetterBody() {
		return letterBody;
	}
	public void setLetterBody(String letterBody) {
		this.letterBody = letterBody;
	}
	public Date getCompositionDate() {
		return compositionDate;
	}
	public void setCompositionDate(Date compositionDate) {
		this.compositionDate = compositionDate;
	}
	
}
