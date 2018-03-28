package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import factoryInterface.PostExamInterface;
import model.examSetGet;

public class PostExamDao implements PostExamInterface {
	
	Connection conn;
	public PostExamDao(){
		makeConn make = new makeConn();
		conn = make.connect();
	}
	
	public void insertExam(examSetGet ex){
		
		String query = "INSERT INTO `meet`.`exam` (`Type`, `Name`, `Date`, `content`, `Owner`) VALUES ('"+ex.getType()+"','"+ex.getName()+"','"+new java.sql.Date(ex.getDate().getTime())+"', '"+ex.getContent()+"', '"+ex.getOwner()+"')";
		
		try{
			Statement s = conn.createStatement();
			s.executeUpdate(query);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean checkExams(examSetGet ex){
		
		String query = "SELECT * FROM `meet`.`exam` where Name = '"+ex.getName()+"' and Type = '"+ex.getType()+"'";
		boolean list = false;
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs.next()){
				list = true;	
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
public boolean isExams(){
		
		String query = "SELECT * FROM `meet`.`exam`";
		boolean list = false;
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs.next()){
				list = true;	
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<String> selectExams(){
		
		String query = "SELECT * FROM `meet`.`exam`";
		ArrayList<String> list = new ArrayList<>();
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			while(rs.next()){
				list.add(rs.getString("Type"));
				list.add(rs.getString("Name"));
				String date = df.format(rs.getDate("Date"));
				list.add(date);
				list.add(rs.getString("content"));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
