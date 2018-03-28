package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.logInDAO;
import model.logInSetGet;

public class LoginTest {

	logInDAO dao = new logInDAO();
	logInSetGet login = new logInSetGet();

	@Test
	public void test() {
		boolean value = dao.selectQuery(login);
		assertEquals(false, value);
	}
	
	@Test
	public void test1() {
		String value = dao.selectQuery1(login);
		assertEquals(null, value);
	}
}
