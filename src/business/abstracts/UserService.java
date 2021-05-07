package business.abstracts;

import entities.concretes.User;

public interface UserService {
	boolean signIn(User user);
	boolean logIn(String email,String password);
	
	}
