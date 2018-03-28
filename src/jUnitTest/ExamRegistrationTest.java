package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.ExamRegistrationDAO;

public class ExamRegistrationTest {

	ExamRegistrationDAO dao = new ExamRegistrationDAO();
	
	@Test
	public void test() {
		assertEquals(1, dao.register("other", "other", "other"));
	}
}
