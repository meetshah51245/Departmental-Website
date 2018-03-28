package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ResourceDAO {
	Connection conn;
	public ResourceDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public int addResource(String name, String type, String info, String owner){
		String sql = "INSERT INTO `resource`(`ID`, `Name`, `Type`, `Info`, `owner`) VALUES ("+null+",'"+name+"','"+type+"','"+info+"','"+owner+"')";
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(sql);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean checkResource(String name){
		String sql = "SELECT `Name` FROM `resource` WHERE `Name`='"+name+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(!rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getResourceList() {
		String sql = "SELECT * FROM `resource`";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("Name"));
				list.add(rs.getString("Type"));
				list.add(rs.getString("Info"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int addReservation(String type, String name, String info, String date, String timeSlot, String fullName) {
		String sql = "INSERT INTO `resourcereservation`(`Type`, `Name`, `Info`, `date`, `TimeSlot`, `FullName`, `ID`) VALUES ('"+type+"','"+name+"','"+info+"','"+date+"','"+timeSlot+"','"+fullName+"',"+null+")";
		System.out.println("---------------------------------");
		System.out.println(type+"--"+name+"--"+date+"--"+timeSlot+"--"+fullName);
		
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(sql);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean isReserved(String type, String name, String date, String timeSlot, String fullName) {
		String sql = "select * from `resourcereservation` where `Type` = '"+type+"' and `Name` = '"+name+"' and `date` = '"+date+"' and `TimeSlot` = '"+timeSlot+"' and `FullName` = '"+fullName+"'";
		System.out.println("---------------------------------");
		System.out.println(type+"--"+name+"--"+date+"--"+timeSlot+"--"+fullName);
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkReservation(String netID){
		String sql = "SELECT * FROM `resourcereservation` WHERE `FullName`='"+netID+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(!rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getReservationList(String netID) {
		String sql = "SELECT * FROM `resourcereservation` WHERE `FullName`='"+netID+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString("Type"));
				list.add(rs.getString("Name"));
				list.add(rs.getString("Info"));
				list.add(rs.getString("Date"));
				list.add(rs.getString("TimeSlot"));
				list.add(rs.getString("ID"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int cancelReservation(String ID) {
		String sql = "DELETE FROM `resourcereservation` WHERE `ID` = '"+ID+"'";
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(sql);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
