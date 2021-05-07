import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.UserAuthAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService= new UserManager(new HibernateUserDao(),new UserAuthAdapter()); 
		User user1 = new User (1,"Mehmet","Akyer","mehmetakyer006@gmail.com","159357456"); 
		User user2 = new User (2,"Mehmet","Akyer","mehmetakyer006@gmail.com","159357456"); 
		User user3 = new User (3,"M","Akyer","mehmet006@gmail.com","159357456"); 
		User user4 = new User (3,"Mehmet","Akyer","mehmet006gmail.  com","159357456"); 
		User user5 = new User (3,"Mehmet","Akyer","mehmet006@gmail.com","159  ");
		
		userService.signIn(user1);//Do�ru girdi
		System.out.println("-------------------------------------------------------------");
		userService.signIn(user2);//Mevcut hesap
		System.out.println("-------------------------------------------------------------");
		userService.signIn(user3);//Ad-Soyad kontrol�
		System.out.println("-------------------------------------------------------------");
		userService.signIn(user4);//yanl�� eposta giri�i
		System.out.println("-------------------------------------------------------------");
		userService.signIn(user5); // yanl�� parola giri�i
		System.out.println("-------------------------------------------------------------");
		userService.logIn("mehmetakyer006@gmail.com","159357456");//do�ru �ifre
		System.out.println("-------------------------------------------------------------");
		userService.logIn("mehmetakyer006@gmail.com","15935745");//yanl�� �ifre
		
		

	}

}
