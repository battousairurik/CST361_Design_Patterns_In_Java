package dataAccess;

import java.util.ArrayList;

import models.Letter;
import models.User;

public interface LetterDBInterface {
	// C operations
	public int insertLetter(Letter letter);

	// R operations
	public ArrayList<Letter> readAllLetters();

	// U operations
	public int updateLetter(int id, Letter letter);

	// D operations
	public int deleteLetter(int id);

	// Search operations
	public Letter searchForLetter(String letterHeader);
	public int searchForLetterID(Letter letter);
	public ArrayList<Letter> searchLettersByUsername(String username);
	public ArrayList<Letter> searchLettersByUser(User user);
}
