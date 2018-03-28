package factoryClass;

import dao.FacultyDAO;
import dao.StaffDAO;
import dao.registrationDAO;
import factoryInterface.RegistrationInterface;

public class RegisterFactory {
	public RegistrationInterface getRegister(String user){
		if(user.equals("Student"))
			return new registrationDAO();
		else if(user.equals("Faculty"))
			return new FacultyDAO();
		else
			return new StaffDAO();
	}
}
