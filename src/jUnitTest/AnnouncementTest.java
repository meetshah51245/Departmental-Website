package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.AnnouncementDAO;

public class AnnouncementTest {
	
	String type;
	String mainPost;
	String link;
	String owner;
	
	AnnouncementDAO dao = new AnnouncementDAO();
	
	@Test
	public void test() {
		assertTrue("insert method", true);
	}
	
	@Test
	public void test1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("16");
		list.add("Event");
		list.add("saasxas");
		list.add("MS");
		assertEquals(list, dao.getAnnouncement());
	}
	
	@Test
	public void test2() {
		assertEquals(0, dao.deleteAnnouncement("12222"));
	}
	
	@Test
	public void test3() {
		assertEquals(true, dao.checkJobs());
	}
	
	@Test
	public void test4() {
		assertEquals(true, dao.checkAnnouncement());
	}
	
	@Test
	public void test5() {
		ArrayList<String> list = new ArrayList<>();
		list.add("15");
		list.add("sadasd");
		list.add("https://www.google.com/about/careers/search#!t=jo&jid=148745002&");
		list.add("MS917523");
		assertEquals(list, dao.getJobs());
	}
}
