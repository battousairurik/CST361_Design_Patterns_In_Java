package restfulServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import data_access.Music_Data_Access;
import models.MusicAlbumEJB;

@ApplicationScoped
@ManagedBean
public class RestClient {

	public void call() {
		Client client = ClientBuilder.newClient();

		SimpleObject o = client.target("http://localhost:8080/Activity_4_Business_Layer_Patterns/resources/MyRestService/object").request().get(SimpleObject.class);
		
		System.out.println(o);
	}
	
	public void createNewAlbum (MusicAlbumEJB album) {
		
	}
	
	public void fetchAlbum (MusicAlbumEJB album) {
		
	}
}
