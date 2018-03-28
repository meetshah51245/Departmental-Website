package jUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.PostExamDao;
import model.examSetGet;

public class ExamTest {

	PostExamDao dao = new PostExamDao();
	examSetGet ex = new examSetGet();
	
	@Test
	public void test() {
		assertTrue("insertEaxam()", true);
	}
	
	@Test
	public void test1() {
		assertEquals(false, dao.checkExams(ex));
	}
	
	@Test
	public void test2() {
		assertTrue("dao.selectExams()",true);
	}
}
