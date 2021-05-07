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
				System.out.println("Böyle bir kullanýcý zaten mevcut.");
				return false;
			}
		}
		if (!userAuth.validation(user)) {
			return false;
		}
		
		userAuth.verificationEmail(user);
		
		userDao.add(user);
		System.out.println("Kayýt baþarýlý!");
		return true;
	}

	@Override
	public boolean logIn(String email, String password) {
		
		userAuth.logInAuth(email, password);
		for (User user : userDao.getAll()) {
			
			if (user.getEmail()==email && user.getPassword()==password) {
				if (!user.isValidated()) {
					System.out.println("Kullanýcý epostasý onaylanmamýþ. Lütfen onay iþlemini gerçekleþtiriniz.");
					userAuth.verificationEmail(user);
					return true;
				}
				System.out.println("Hoþgeldin, " + user.getFirstName());
				return true; // Giriþ baþarýlý!
			}
		}
		System.out.println("Böyle bir kullanýcý bulunamadý.");
		return false;
	}

	
	

	

}
