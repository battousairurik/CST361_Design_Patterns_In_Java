package businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Album;

@RequestScoped
@Path("/albums")
@Produces("application/json")
@Consumes("application/json")
public class AlbumRestService {

	@Inject
	BusinessServiceInterface bsi;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> getAlbums() {
		return bsi.readAllAlbums();
	}
	@GET
	@Path("/getalbumbytitle/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Album getAlbumbyTitle(@PathParam("title") String title) {
		return bsi.searchForAlbum(title);
	}
	@GET
	@Path("/getalbumbyartist/{artist}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Album> getAlbumbyArtist(@PathParam("artist") String artist) {
		return bsi.searchAlbumsByArtist(artist);
	}
}
