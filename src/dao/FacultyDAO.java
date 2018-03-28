package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factoryInterface.RegistrationInterface;
import model.RegistrationSetGet;

public class FacultyDAO implements RegistrationInterface {
	Connection conn;
	public FacultyDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public int insertData (RegistrationSetGet regSetGet){	
		String sqlQuery = "INSERT INTO `faculty`(`User`, `First Name`, `Last Name`, `Net ID`, `Password`)	VALUES ('"+regSetGet.getUser()+"','"+regSetGet.getFname()+"','"+regSetGet.getLname()+"','"+regSetGet.getNetid()+"','"+regSetGet.getPassword()+"')";
		
		try {
			Statement pst = conn.createStatement();
			int condition = pst.executeUpdate(sqlQuery);
	//		System.out.println("----------"+condition);
			return condition;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean selectQuery(RegistrationSetGet regSetGet){
		String SqlQuery = "select * from Faculty where `Net ID`='"+regSetGet.getNetid()+"'";
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
}
