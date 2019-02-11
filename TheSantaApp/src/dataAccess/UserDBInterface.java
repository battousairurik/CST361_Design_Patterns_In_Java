package dataAccess;

import java.util.ArrayList;

import models.Letter;
import models.User;

public interface UserDBInterface {
	// C operations
	public int insertUser(User user);

	// R operations
	public ArrayList<User> readAllUsers();

	// U operations
	public int updateUser(int id, User user);

	// D operations
	public int deleteUser(int id);

	// Search operations
	public User searchForUser(String username);
}
