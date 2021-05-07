package business.concretes;


import business.abstracts.UserService;
import core.abstracts.UserAuth;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private UserAuth userAuth;

	public UserManager(UserDao userDao,UserAuth userAuth) {
		super();
		this.userDao = userDao;
		this.userAuth= userAuth;
	}

	@Override
	public boolean signIn(User user) {
		
		for (User userfromDatabase : userDao.getAll()) {
			if (userfromDatabase.getEmail()==user.getEmail()) {
				System.out.println("B�yle bir kullan�c� zaten mevcut.");
				return false;
			}
		}
		if (!userAuth.validation(user)) {
			return false;
		}
		
		userAuth.verificationEmail(user);
		
		userDao.add(user);
		System.out.println("Kay�t ba�ar�l�!");
		return true;
	}

	@Override
	public boolean logIn(String email, String password) {
		
		userAuth.logInAuth(email, password);
		for (User user : userDao.getAll()) {
			
			if (user.getEmail()==email && user.getPassword()==password) {
				if (!user.isValidated()) {
					System.out.println("Kullan�c� epostas� onaylanmam��. L�tfen onay i�lemini ger�ekle�tiriniz.");
					userAuth.verificationEmail(user);
					return true;
				}
				System.out.println("Ho�geldin, " + user.getFirstName());
				return true; // Giri� ba�ar�l�!
			}
		}
		System.out.println("B�yle bir kullan�c� bulunamad�.");
		return false;
	}

	
	

	

}
