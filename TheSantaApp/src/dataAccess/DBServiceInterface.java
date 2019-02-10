package dataAccess;

import java.util.ArrayList;

import models.Letter;
import models.User;

public interface DBServiceInterface {

	// C operations
	public int insertUser(User user);

	public int insertLetter(Letter letter);

	// R operations
	public ArrayList<User> readAllUsers();

	public ArrayList<Letter> readAllLetters();

	// U operations
	public int updateUser(int id, User user);

	public int updateLetter(int id, Letter letter);

	// D operations
	public int deleteUser(int id);

	public int deleteLetter(int id);

	// Search operations
	public User searchForUser(String username);

	public Letter searchForLetter(String letterHeader);

	public int searchForLetterID(Letter letter);

	public ArrayList<Letter> searchLettersByUser(String user);
}
