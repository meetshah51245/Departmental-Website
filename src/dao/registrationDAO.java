package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import factoryInterface.RegistrationInterface;
import model.RegistrationSetGet;

public class registrationDAO implements RegistrationInterface{
	Connection conn;
	public registrationDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	

	public int insertData (RegistrationSetGet regSetGet){	
		Date td = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sqlQuery = null;
		if(regSetGet.getUser() != null)
			sqlQuery = "INSERT INTO `registration`(`User`, `First Name`, `Last Name`, `Program`,`Major`, `Net ID`, `Join Date`, `Password`)	VALUES ('"+regSetGet.getUser()+"','"+regSetGet.getFname()+"','"+regSetGet.getLname()+"','"+regSetGet.getProgram().toLowerCase()+"','"+regSetGet.getMajor()+"','"+regSetGet.getNetid()+"','"+dt.format(td)+"','"+regSetGet.getPassword()+"')";
		if(sqlQuery != null){
			try {
				Statement pst = conn.createStatement();
				int condition = pst.executeUpdate(sqlQuery);
				return condition;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}	
	
	public boolean selectQuery(RegistrationSetGet regSetGet){
		String SqlQuery = "select * from registration where `Net ID`='"+regSetGet.getNetid()+"'";
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