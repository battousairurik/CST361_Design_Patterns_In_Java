package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import businessLogic.AlbumService;
import businessLogic.LoginService;
import models.Album;
import models.User;

@ManagedBean
public class FormsController {

	@EJB
	LoginService ls;
		
	@EJB
	AlbumService as;
		
	public String login() {
		String destination = "LoginPage.html";
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		if(ls.validateLogin(user)) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			destination = "LoginPage.html";
		}
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return destination;
	}
	
	public String submitAlbum() {
		String destination = "AlbumEntryPage.html";
		FacesContext context = FacesContext.getCurrentInstance();
		Album album = context.getApplication().evaluateExpressionGet(context, "#{album}", Album.class);
		as.addAlbum(album);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return destination;
	}
}
