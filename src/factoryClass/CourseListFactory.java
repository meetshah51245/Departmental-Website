package factoryClass;

import dao.CourseListDao;
import factoryInterface.CourseListInterface;

public class CourseListFactory {
	public CourseListInterface getCreateCourse(){
		return new CourseListDao();
	}
}
