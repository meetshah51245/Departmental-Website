package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.ResourceDAO;

public class ResourceTest {

	ResourceDAO dao = new ResourceDAO();
	
	@Test
	public void test() {
		assertEquals(1,dao.addResource("Group Studies Room", "Study Area", "Corner", "MS917523"));
	}
	
	@Test
	public void test1() {
		assertEquals(1,dao.addReservation("Group Room", "Study Area", "Corner", "MS917523", "Study Area","Study Area"));
	}
	
	@Test
	public void test3() {
		assertEquals(true,dao.checkResource(""));
	}
	
	@Test
	public void test4() {
		assertEquals(true,dao.checkReservation(""));
	}
	
	@Test
	public void test5() {
		assertEquals(0,dao.cancelReservation(""));
	}
	
	@Test
	public void test6() {
		assertEquals(1,dao.addReservation("ADD", "ADD", "ADD", "ADD", "ADD", "ADD"));
	}
}
