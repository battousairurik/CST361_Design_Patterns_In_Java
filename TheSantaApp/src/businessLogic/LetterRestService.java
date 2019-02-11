package businessLogic;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.Letter;


public class LetterRestService {

	@Inject
	BusinessServiceInterface bsi;

	@GET
	@Path("/getletters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Letter> getLetters() {
		return bsi.readAllLetters();
	}

	@GET
	@Path("/getletterbyusername/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Letter getUserbyName(@PathParam("username") String username) {
		return bsi.searchForLetter(username);
	}	
	
	
}
