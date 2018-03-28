package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ResultDAO {
	
	Connection conn;
	public ResultDAO(){
		makeConn makeconn = new makeConn();
		conn = makeconn.connect();
	}
	
	public ArrayList<String> getList(String type , String Owner){
		
		String sql = "SELECT `Name` FROM `exam` WHERE `Type` = '"+type+"' and  `Owner` = '"+Owner+"'";		
		
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("Name"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean isExist(String type , String Owner){
		
		String sql = "SELECT `Name` FROM `exam` WHERE `Type` = '"+type+"' and  `Owner` = '"+Owner+"'";		
		
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
	
	public int postResult(String type , String Owner, String Exam, String result){
		
		String sql = "INSERT INTO `result`(`Owner`, `Exam`, `Type`, `Result`) VALUES ('"+Owner+"', '"+Exam+"', '"+type+"', '"+result+"')";		
		
		try{
			Statement s = conn.createStatement();
			int rs = s.executeUpdate(sql);
			return rs;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public boolean isPosted(String type , String name){
		
		String sql = "SELECT `Result` FROM `result` WHERE `Type` = '"+type+"' and  `Exam` = '"+name+"'";		
		
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
	
	public ArrayList<String> getResult(String type, String name){
		String sql = "SELECT * FROM `result` WHERE `Type` = '"+type+"' and  `Exam` = '"+name+"'";		
		
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<>();
			if(rs.next()){
				 list.add(rs.getString("Result"));
				 list.add(rs.getString("Owner"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean isExist1(String type) {
		String sql = "SELECT `Name` FROM `exam` WHERE `Type` = '"+type+"'";		
		
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
	
	public ArrayList<String> getNames(String type){
		
		String sql = "SELECT `Name` FROM `exam` WHERE `Type` = '"+type+"'";		
		
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("Name"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public int updateResult(String owner, String examType, String examName, String result) {
		String sql = "UPDATE `result` SET `Result`='"+result+"' WHERE `Owner`='"+owner+"' and `Exam`='"+examName+"' and `Type`='"+examType+"'";
		
		try{
			Statement s = conn.createStatement();
			int rs = s.executeUpdate(sql);
			
			return rs;
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}

}
