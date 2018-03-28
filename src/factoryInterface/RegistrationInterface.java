package factoryInterface;

import model.RegistrationSetGet;

public interface RegistrationInterface {
	public int insertData (RegistrationSetGet regSetGet) throws Exception;

	public boolean selectQuery(RegistrationSetGet regSetGet);
}
