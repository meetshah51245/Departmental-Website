package factoryClass;

import dao.FacultyProfileDAO;
import dao.StaffProfileDAO;
import dao.StudentProfileDAO;
import factoryInterface.userProfileInterface;

public class UserProfileFactory {
	public userProfileInterface getInfo(String user){
		if(user.equals("Student"))
			return new StudentProfileDAO();
		else if(user.equals("Faculty"))
			return new FacultyProfileDAO();
		else
			return new StaffProfileDAO();
	}
}
