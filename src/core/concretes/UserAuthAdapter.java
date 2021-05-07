package core.concretes;

import UserAuthoraziton.UserAuthoraziton;
import core.abstracts.UserAuth;
import entities.concretes.User;

public class UserAuthAdapter implements UserAuth{
	UserAuthoraziton userAuth = new UserAuthoraziton(); //Google auth ile deðiþtirilebilecek.


	@Override
	public boolean validation(User user) {
		
		return userAuth.validation(user);
	}

	@Override
	public boolean verificationEmail(User user) {
		
		return userAuth.verificationEmail(user);
	}

	@Override
	public boolean logInAuth(String email, String password) {
		
		return userAuth.logInCheck(email, password);
	}

}
