package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumniDAO {
	Connection conn;
	public AlumniDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public int insertAlumni(String name, String date, String home, String info){
		if(name != null){
			String sql = "INSERT INTO `alumni`(`ID`, `Name`, `Date`, `link`, `info`) VALUES ("+null+", '"+name+"', '"+date+"', '"+home+"', '"+info+"')";
			try {
				Statement pst = conn.createStatement();
				int condition = pst.executeUpdate(sql);
				return condition;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return 0;	
	}
	
	
	public ArrayList<String> getAlumni(){
		String sql = "select * from alumni";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);	
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("ID"));
				list.add(rs.getString("Name"));
				list.add(rs.getString("Date"));
				list.add(rs.getString("link"));
				list.add(rs.getString("info"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}
	
	public boolean checkAlumni(){
		String sql = "select * from alumni";
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

	public ArrayList<String> getPerticularAlumni(String id) {
		String sql = "select * from alumni where ID = '"+id+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);	
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("Name"));
				list.add(rs.getString("Date"));
				list.add(rs.getString("link"));
				list.add(rs.getString("info"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}

	public int updateAlumni(String Id, String name, String date, String link, String info) {
		if(Id != "12222"){	
			String query = "UPDATE `alumni` SET `Name`='"+name+"',`Date`='"+date+"',`link`='"+link+"',`info`='"+info+"' WHERE ID = '"+Id+"'";	
			try {
				Statement pst = conn.createStatement();
				pst.executeUpdate(query);
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return 0;
	}

	public int deleteAlumni(String id) {
		
		String sql = "delete from alumni where ID = '"+id+"'";
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
