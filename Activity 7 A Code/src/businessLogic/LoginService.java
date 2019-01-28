package businessLogic;


import javax.ejb.Local;
import javax.ejb.Stateless;

import data_access.UserDAO;
import models.User;

@Stateless
@Local
public class LoginService {

	UserDAO userDAO = new UserDAO();

	public boolean validateLogin(User user) {
		boolean result = false;
		User userExists = userDAO.findUser(user.getUsername(), user.getPassword());
		if (userExists != null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
