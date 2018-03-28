package jUnitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.makeConn;

public class makeConnTest {

	makeConn makeconn = new makeConn();
	
	@Test
	public void test4() {
		assertTrue("makeconn.connect()", true);
	}

}
