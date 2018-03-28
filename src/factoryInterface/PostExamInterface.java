package factoryInterface;

import java.util.ArrayList;

import model.examSetGet;

public interface PostExamInterface {
	public void insertExam(examSetGet ex);
	public ArrayList<String> selectExams();
	public boolean checkExams(examSetGet ex);
	public boolean isExams();
}
