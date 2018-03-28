package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.CourseListDao;
import model.courseListSetGet;

public class CourseListTest {

	CourseListDao dao = new CourseListDao();
	courseListSetGet cl = new courseListSetGet();
	
	@Test
	public void test() {
		assertEquals(false, dao.checkCourse("12222"));
	}
	
	@Test
	public void test1() {
		assertEquals(1, dao.createCourse(cl));
	}
	
	@Test
	public void test2() {
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list, dao.selectCourse(123));
	}
	
	@Test
	public void test3() {
		assertEquals(0, dao.updateInstructor("zxcv", "1234"));
	}
	
	@Test
	public void test4() {
		assertEquals(0, dao.updateSyllabus("lkj", "1234"));
	}
}
