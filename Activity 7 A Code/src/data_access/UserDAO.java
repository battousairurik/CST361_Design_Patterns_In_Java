package data_access;

import javax.inject.Inject;
import business.BusinessServiceInterface;
import models.User;

public class UserDAO {

	@Inject
	public BusinessServiceInterface bsi;
	
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
