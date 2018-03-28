package jUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.StaffDAO;
import model.RegistrationSetGet;

public class StaffTest {

	StaffDAO dao = new StaffDAO();
	RegistrationSetGet regSetGet = new RegistrationSetGet();
	
	@Test
	public void test() {
		assertEquals(1, dao.insertData(regSetGet));
	}
	
	@Test
	public void test1() {
		assertEquals(true, dao.selectQuery(regSetGet));
	}
}
