package factoryInterface;

import model.logInSetGet;

public interface LoginInterface {
	public Boolean selectQuery(logInSetGet login) throws Exception;

	public String selectQuery1(logInSetGet login);
}
