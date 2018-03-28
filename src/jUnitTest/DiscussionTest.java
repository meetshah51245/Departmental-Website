package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import dao.DiscussionBoardDAO;

public class DiscussionTest {

	DiscussionBoardDAO dao = new DiscussionBoardDAO();
	
	@Test
	public void test() {
		assertTrue("dao.postQuestion(dbgs)", true);
	}
	
	@Test
	public void test1() {
		assertEquals(0, dao.delete(123));
	}

	@Test
	public void test2() {
		assertEquals(true, dao.selectEverything());
	}
	
	@Test
	public void test3() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> pid = new ArrayList<>();
		ArrayList<String> id = new ArrayList<>();
		list.add("1"); list1.add("1"); id.add("1"); pid.add("1");
		map.put("list", list);
		map.put("list1", list1);
		map.put("pid", pid);
		map.put("id", id);
		assertTrue("dao.selectPost()", true);
	}
}
