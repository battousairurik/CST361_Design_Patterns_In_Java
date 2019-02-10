package businessLogic;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import dataAccess.LetterDAO;
import interceptors.MethodExecutionInterceptor;
import models.Letter;

@Interceptors(MethodExecutionInterceptor.class)
@Stateless
@Local
public class LetterService {

	LetterDAO letterDAO = new LetterDAO();
	
	public void addLetter (Letter letter) {
		
	}
}
