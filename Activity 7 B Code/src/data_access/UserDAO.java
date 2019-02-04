package data_access;

import javax.inject.Inject;
import businessLogic.BusinessService;
import models.User;

public class UserDAO {

	@Inject
	public BusinessService bsi;
	
	public User findUser(String username, String password) {
		User searchResult = new User();
		User searchQuery = bsi.searchForUser(username);
		if(searchQuery.getPassword().equals(password)) {
			searchResult = searchQuery;
		}
		else {
			searchResult = null;
		}
		return searchResult;
	}
}
