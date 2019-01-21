package restfulServices;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

	// http://localhost:8080/Activity_4_Business_Layer_Patterns/resources/MyRestService/sayHello
	@GET
	@Path("/sayHello")
	public String getMessage() {
		return "Hello World";
	}

	@GET
	@Path("/echo")
	public Response getEchoMsg(@QueryParam("message") String msg) {
		return Response.ok("Your message was: " + msg).build();
	}

	@GET
	@Path("/object")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public SimpleObject getObject() {
		return new SimpleObject(1, "Test");
	}
	
	
	
	
	
}
