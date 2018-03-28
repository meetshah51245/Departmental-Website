package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import dao.PhdDAO;

public class PhdTest {

	PhdDAO dao = new PhdDAO();
	
	@Test
	public void test() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> cName = new ArrayList<>();
		ArrayList<String> info = new ArrayList<>();
		map.put("cName", cName);
		map.put("info", info);
		assertEquals(map, dao.getPhD("12345", "12345"));
	}
	
	@Test
	public void test1() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> id = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		map.put("id", id);
		map.put("list", list);
		assertEquals(map, dao.Name("123456"));
	}
	
	@Test
	public void test2() {
		assertEquals(false, dao.selectQuery("123456"));
	}
	
	@Test
	public void test3() {
		assertEquals(false, dao.selectQuery1("123456"));
	}
	
	@Test
	public void test4() {
		assertEquals(1, dao.updateStatus("1234566", "12345"));
	}
}
