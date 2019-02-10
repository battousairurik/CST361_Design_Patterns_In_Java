package businessLogic;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.User;

@RequestScoped
@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserRestService {

	@Inject
	BusinessServiceInterface bsi;

	@GET
	@Path("/getusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return bsi.readAllUsers();
	}

	@GET
	@Path("/getuserbyname/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserbyName(@PathParam("username") String username) {
		return bsi.searchForUser(username);
	}
}
