package factoryInterface;

import java.util.ArrayList;

import model.courseListSetGet;

public interface CourseListInterface {
	public int createCourse(courseListSetGet cl);
	public ArrayList<String> selectCourse(int concentration);
	public boolean checkCourse(String courseId);
	public int updateInstructor(String fullName, String courseId);
	public int updateSyllabus(String syllabus, String courseId);
}
