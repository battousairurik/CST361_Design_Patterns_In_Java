package models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="letter")
@RequestScoped
public class Letter {

	private String body;
	private User user;
	private String header;
	
	public Letter () {}
	public Letter(String letterHeader, String letterBody) {
		this.setHeader(letterHeader);
		this.setBody(letterBody);
		this.setUser(null);
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
