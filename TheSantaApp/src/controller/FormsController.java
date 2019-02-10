package controller;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import businessLogic.LetterService;
import businessLogic.LoginService;
import models.Letter;
import models.User;

public class FormsController {

	@EJB
	LoginService lgs;
		
	@EJB
	LetterService les;
		
	public String login() {
		String destination = "LoginPage.html";
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		if(lgs.validateLogin(user)) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			destination = "LoginPage.html";
		}
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return destination;
	}
	
	public String SendLetter() {
		String destination = "CreateLetterPage.html";
		FacesContext context = FacesContext.getCurrentInstance();
		Letter letter = context.getApplication().evaluateExpressionGet(context, "#{letter}", Letter.class);
		les.addLetter(letter);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("letter", letter);
		return destination;
	}
}
