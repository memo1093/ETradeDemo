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
			System.out.println("E-posta ve �ifre alan� girilmesi zorunludur!");
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
			System.out.println("Alanlar bo� ge�ilemez!");
			return false;
		}
		if (!matcher.find()) {
			System.out.println("Girilen eposta yanl��!");
			return false;
		}
		if (user.getPassword().length()<=6) {
			System.out.println("Parola en az 6 karakter i�ermelidir.");
			return false;
		}
		if (user.getFirstName().length()<=2 || user.getLastName().length()<=2) {
			System.out.println("Ad veya soyad iki harften az olamaz!");
			return false;
		}
		
		System.out.println("Do�rulama Ba�ar�l�!");
		return true; //Do�rulama Ba�ar�l�
		
	}

	public boolean verificationEmail(User user) {
		System.out.println("E-posta adresinizi do�rulamak i�in  l�tfen b�y�k harfler ile 'ONAYLA' yaz�n�z(t�rnak i�areti olmadan).");
		String verificate = "ONAYLA";
		if (verificate=="ONAYLA") {
			System.out.println("E-posta onay i�lemi Ba�ar�l�!");
			user.setValidated(true);
			return true; //E-posta onay� ba�ar�l�!
		}
		return false;
	}
}
