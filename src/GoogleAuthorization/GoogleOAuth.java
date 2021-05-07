package GoogleAuthorization;

import entities.concretes.User;

public class GoogleOAuth {
	public boolean signInCheck(User user) {
		validation(user);
		verificationEmail(user);
		System.out.println("Google ile kay�t olundu! " + user.getEmail());
		return true;
	}

	public boolean logInCheck(String email, String password) {
		
		System.out.println("Google ile giri� yap�ld�. " + email);
		return true;
	}

	public boolean validation(User user) {
		System.out.println("Google ile do�rulama ba�ar�l�!");
		return true;
	}

	public boolean verificationEmail(User user) {
		
		return true;
	}
}
