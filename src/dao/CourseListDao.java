package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import factoryInterface.CourseListInterface;
import model.courseListSetGet;

public class CourseListDao implements CourseListInterface {
	Connection conn;
	public CourseListDao(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	@Override
	public int createCourse(courseListSetGet cl) {
		// TODO Auto-generated method stub
		String instructor = "Staff";
		String syllabus = "Syllabus";
		String query = "INSERT INTO `meet`.`courselist` (`concentration`,`courseId`, `name`, `instructor`, `syllabus`) VALUES ('"+cl.getConcentration()+"','"+cl.getId()+"','"+cl.getName()+"', '"+instructor+"', '"+syllabus+"')";
		
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(query);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public ArrayList<String> selectCourse(int concentration) {
		// TODO Auto-generated method stub
		String SqlQuery = null;
		if(concentration == 1)
			SqlQuery = "SELECT * FROM `courselist`";
		else
			SqlQuery = "SELECT * FROM `courselist` where concentration='"+concentration+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(SqlQuery);
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("courseId"));
				list.add(rs.getString("name"));
				list.add(rs.getString("instructor"));
				list.add(rs.getString("syllabus"));
			}	
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkCourse(String courseId){
		
		String SqlQuery = null;
		if(courseId.equals("courseId"))
			SqlQuery = "SELECT * FROM `courselist`";
		else
			SqlQuery = "SELECT * FROM `courselist` where courseId='"+courseId+"'";
		
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(SqlQuery);
			
			if(rs.next()){
				return true;
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public int updateInstructor(String instructor, String courseId){
		
		String query = "UPDATE `meet`.`courselist` SET `instructor` = '"+instructor+"' WHERE `courselist`.`courseId` = '"+courseId+"'";
		
		try{
			Statement s = conn.createStatement();
			int rs = s.executeUpdate(query);
			
			return rs;
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
public int updateSyllabus(String syllabus, String courseId){
		
		String query = "UPDATE `meet`.`courselist` SET `syllabus` = '"+syllabus+"' WHERE `courselist`.`courseId` = '"+courseId+"'";
		
		try{
			Statement s = conn.createStatement();
			int rs = s.executeUpdate(query);
			
			return rs;
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
}
