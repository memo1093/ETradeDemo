package core.abstracts;

import entities.concretes.User;

public interface UserAuth {
	
	boolean logInAuth(String email,String password);
	boolean validation(User user);
	boolean verificationEmail(User user);
}
