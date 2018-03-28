package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.FacultyDAO;
import model.RegistrationSetGet;

public class FacultyTest {

	FacultyDAO dao = new FacultyDAO();
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
