package businessLogic;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.interceptor.Interceptors;

import dataAccess.DBServiceInterface;
import interceptors.MethodExecutionInterceptor;
import models.Letter;
import models.User;

@Interceptors(MethodExecutionInterceptor.class)
public class BusinessService implements BusinessServiceInterface{

	@EJB
	DBServiceInterface db;
	
	@Override
	public int insertUser(User user) {
		return db.insertUser(user);
	}

	@Override
	public int insertLetter(Letter letter) {
		return db.insertLetter(letter);
	}

	@Override
	public ArrayList<User> readAllUsers() {
		return db.readAllUsers();
	}

	@Override
	public ArrayList<Letter> readAllLetters() {
		return db.readAllLetters();
	}

	@Override
	public int updateUser(int id, User user) {
		return db.updateUser(id, user);
	}

	@Override
	public int updateLetter(int id, Letter letter) {
		return db.updateLetter(id, letter);
	}

	@Override
	public int deleteUser(int id) {
		return db.deleteUser(id);
	}

	@Override
	public int deleteLetter(int id) {
		return db.deleteLetter(id);
	}

	@Override
	public User searchForUser(String username) {
		return db.searchForUser(username);
	}

	@Override
	public Letter searchForLetter(String letterHeader) {
		return db.searchForLetter(letterHeader);
	}

	@Override
	public int searchForLetterID(Letter letter) {
		return db.searchForLetterID(letter);
	}

	@Override
	public ArrayList<Letter> searchLettersByUser(String user) {
		return db.searchLettersByUser(user);
	}

}
