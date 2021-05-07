package UserAuthoraziton;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.concretes.User;

public class UserAuthoraziton {
	
	public boolean logInCheck(String email, String password) {
		boolean nullOrEmptyCheck = email.trim().isEmpty() ||
				password.trim().isEmpty() ||
				Objects.isNull(email)||
				Objects.isNull(password);
		if (nullOrEmptyCheck) {
			System.out.println("E-posta ve Þifre alaný girilmesi zorunludur!");
			return false;
		}
		return true;
	}

	public boolean validation(User user) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean nullOrEmptyCheck = Objects.isNull(user) || 
				user.getFirstName().trim().isEmpty() || 
				user.getLastName().trim().isEmpty()||
				user.getEmail().trim().isEmpty()||
				user.getPassword().trim().isEmpty();
		
		if (nullOrEmptyCheck) {
			System.out.println("Alanlar boþ geçilemez!");
			return false;
		}
		if (!matcher.find()) {
			System.out.println("Girilen eposta yanlýþ!");
			return false;
		}
		if (user.getPassword().length()<=6) {
			System.out.println("Parola en az 6 karakter içermelidir.");
			return false;
		}
		if (user.getFirstName().length()<=2 || user.getLastName().length()<=2) {
			System.out.println("Ad veya soyad iki harften az olamaz!");
			return false;
		}
		
		System.out.println("Doðrulama Baþarýlý!");
		return true; //Doðrulama Baþarýlý
		
	}

	public boolean verificationEmail(User user) {
		System.out.println("E-posta adresinizi doðrulamak için  lütfen büyük harfler ile 'ONAYLA' yazýnýz(týrnak iþareti olmadan).");
		String verificate = "ONAYLA";
		if (verificate=="ONAYLA") {
			System.out.println("E-posta onay iþlemi Baþarýlý!");
			user.setValidated(true);
			return true; //E-posta onayý baþarýlý!
		}
		return false;
	}
}
