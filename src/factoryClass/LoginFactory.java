package factoryClass;

import dao.logInDAO;
import factoryInterface.LoginInterface;

public class LoginFactory {
	public LoginInterface getLogin(){
		return new logInDAO();
	}
}
