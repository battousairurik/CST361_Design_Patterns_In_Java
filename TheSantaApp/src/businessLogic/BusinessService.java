package businessLogic;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.interceptor.Interceptors;

import dataAccess.DBServiceInterface;
import dataAccess.LetterDBInterface;
import dataAccess.UserDBInterface;
import interceptors.MethodExecutionInterceptor;
import models.Letter;
import models.User;

@Interceptors(MethodExecutionInterceptor.class)
public class BusinessService implements BusinessServiceInterface{

	
	@EJB
	LetterDBInterface letterDB;
	
	@EJB
	UserDBInterface userDB;
	
	
	@Override
	public int insertUser(User user) {
		return userDB.insertUser(user);
	}

	@Override
	public int insertLetter(Letter letter) {
		return letterDB.insertLetter(letter);
	}

	@Override
	public ArrayList<User> readAllUsers() {
		return userDB.readAllUsers();
	}

	@Override
	public ArrayList<Letter> readAllLetters() {
		return letterDB.readAllLetters();
	}

	@Override
	public int updateUser(int id, User user) {
		return userDB.updateUser(id, user);
	}

	@Override
	public int updateLetter(int id, Letter letter) {
		return letterDB.updateLetter(id, letter);
	}

	@Override
	public int deleteUser(int id) {
		return userDB.deleteUser(id);
	}

	@Override
	public int deleteLetter(int id) {
		return letterDB.deleteLetter(id);
	}

	@Override
	public User searchForUser(String username) {
		return userDB.searchForUser(username);
	}

	@Override
	public Letter searchForLetter(String letterHeader) {
		return letterDB.searchForLetter(letterHeader);
	}

	@Override
	public int searchForLetterID(Letter letter) {
		return letterDB.searchForLetterID(letter);
	}

	@Override
	public ArrayList<Letter> searchLettersByUsername(String username) {
		return letterDB.searchLettersByUsername(username);
	}
	@Override
	public ArrayList<Letter> searchLettersByUser(User user) {
		return letterDB.searchLettersByUser(user);
	}

}
