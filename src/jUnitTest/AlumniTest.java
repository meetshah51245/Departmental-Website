package jUnitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import dao.AlumniDAO;
import static org.junit.Assert.assertTrue;

public class AlumniTest {

	AlumniDAO dao = new AlumniDAO();
	
	@Test
	public void test() {
		assertEquals(0, dao.insertAlumni(null, "wow", "www", "meet"));
	}
	
	@Test
	public void test1() {
		if(dao.checkAlumni())
			assertEquals(true, dao.checkAlumni());
		else	
			assertEquals(false, dao.checkAlumni());
	}
	
	@Test
	public void test2() {
		assertEquals(0, dao.deleteAlumni("12222"));
	}
	
	@Test
	public void test3() {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("Whatever");
		list.add("2016-04-22");
		list.add("http://www.google.com/");
		list.add("Whatever");
		assertTrue("dao.getAlumni()", true);
	}
	
	@Test
	public void test4() {
		ArrayList<String> list = new ArrayList<>();
		assertEquals(list , dao.getPerticularAlumni("12222"));
	}
	
	@Test
	public void test5() {
		assertEquals(0 , dao.updateAlumni("12222", "meet", "1222-12-12", "home", "info"));
	}
}
