package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnnouncementDAO {
	Connection conn;
	public AnnouncementDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public void insertIntoAnnounce(String type, String mainPost, String link, String owner) {
		if(link == null){
			link = "No link";
		}
		String sql = "INSERT INTO `announcement`(`ID`, `Type`, `Post`, `link`, `Net ID`) VALUES ("+null+",'"+type+"','"+mainPost+"','"+link+"','"+owner+"')";
		try {
			Statement pst = conn.createStatement();
			pst.executeUpdate(sql);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAnnouncement(){
		String sql = "select * from announcement where `Type` = 'Event' or Type = 'News'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);	
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("ID"));
				list.add(rs.getString("Type"));
				list.add(rs.getString("Post"));
				list.add(rs.getString("Net ID"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}

	public ArrayList<String> getJobs() {
		String sql = "select * from announcement where `Type` = 'Job Opportunity'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);	
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("ID"));
				list.add(rs.getString("Post"));
				list.add(rs.getString("link"));
				list.add(rs.getString("Net ID"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}

	public int deleteAnnouncement(String id) {
		String query = "DELETE FROM `meet`.`announcement` WHERE `ID` = "+id+"";
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(query);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean checkAnnouncement(){
		String query = "SELECT * FROM `meet`.`announcement` where `Type` = 'Event' or Type = 'News'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()){
			   return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkJobs(){
		String query = "SELECT * FROM `meet`.`announcement` where `Type` = 'Job Opportunity'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()){
			   return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
