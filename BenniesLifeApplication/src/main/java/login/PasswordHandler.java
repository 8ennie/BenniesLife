package login;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordHandler {

	protected StrongPasswordEncryptor passwordEncryptor;
	
	public PasswordHandler(){
	passwordEncryptor = new StrongPasswordEncryptor();
	}
	
	public String getPassword(String password) {
	String encryptedPassword = passwordEncryptor.encryptPassword(password);
	return encryptedPassword;
	}
	
	public boolean checkPassword(String inputPassword,String encryptedPassword) {
		
		if (passwordEncryptor.checkPassword(inputPassword,encryptedPassword)) {
			  return true;
		} else {
			  return false;
		}
	}
}
