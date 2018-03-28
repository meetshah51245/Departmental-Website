package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import dao.FacultyProfileDAO;
import model.editUserSetGet;

public class FacultyProfileTest {

	FacultyProfileDAO dao = new FacultyProfileDAO();
	editUserSetGet eu = new editUserSetGet();
	
	@Test
	public void test() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> cName = new ArrayList<>();
		ArrayList<String> info = new ArrayList<>();
		map.put("cName", cName);
		map.put("info", info);
		assertEquals(map, dao.getInfo("12345"));
	}
	
	@Test
	public void test1() {
		assertEquals(false, dao.checkTable(eu));
	}
	
	@Test
	public void test2() {
		assertTrue("dao.insertInfo(eu)",true);
	}
	
	@Test
	public void test3() {
		assertEquals(false, dao.selectQuery1("12345"));
	}
	
	@Test
	public void test4() {
		assertTrue("dao.updateInfo(eu)", true);
	}
}
