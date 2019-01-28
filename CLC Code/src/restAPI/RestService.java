package restAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.letterToSanta;
import models.userAccount;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

	// http://localhost:8080/The_Santa_App/resources/MyRestService/letter
	@GET
	@Path("/letter")
	@Produces({ MediaType.APPLICATION_JSON })
	public letterToSanta getObject() {
		return new letterToSanta();
	}
	
	// http://localhost:8080/The_Santa_App/resources/MyRestService/account
	@GET
	@Path("/account")
	@Produces({ MediaType.APPLICATION_JSON })
	public userAccount getUserAccount () {
		return new userAccount();
	}
}
