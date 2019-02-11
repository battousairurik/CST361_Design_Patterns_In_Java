package businessLogic;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import dataAccess.LetterDAO;
import dataAccess.LetterDBInterface;
import interceptors.MethodExecutionInterceptor;
import models.Letter;

@Interceptors(MethodExecutionInterceptor.class)
@Stateless
@Local
public class LetterService {

	@Inject
	LetterDBInterface li;
		
	public void addLetter (Letter letter) {
		li.insertLetter(letter);
	}
	
	
	
}
