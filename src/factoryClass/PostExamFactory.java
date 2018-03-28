package factoryClass;

import dao.PostExamDao;
import factoryInterface.PostExamInterface;

public class PostExamFactory {
	public PostExamInterface getExam(){
		return new PostExamDao();
	}
}
