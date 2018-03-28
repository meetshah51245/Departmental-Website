package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.registrationDAO;
import model.RegistrationSetGet;

public class RegistrationTest {

	registrationDAO dao = new registrationDAO();
	RegistrationSetGet regSetGet = new RegistrationSetGet();
	@Test
	public void test() {
		assertEquals(0,dao.insertData(regSetGet));
	}
	
	@Test
	public void test1(){
		assertEquals(false,dao.selectQuery(regSetGet));
	}
}
