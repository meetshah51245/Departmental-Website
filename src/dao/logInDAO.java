package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import factoryInterface.LoginInterface;
import model.logInSetGet;

public class logInDAO implements LoginInterface{
	
	Connection conn;
	public logInDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public Boolean selectQuery(logInSetGet login){
		
		String SqlQuery;
		if(("Student").equals(login.getUser()))
			SqlQuery = "select * from registration where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		else if(("Faculty").equals(login.getUser()))
			SqlQuery = "select * from faculty where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		else
			SqlQuery = "select * from staff where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(SqlQuery);
			String user = null;
			String NetId = null;
			String pass = null;

			if(rs.next()){
				user = rs.getString("User");
				NetId = rs.getString("Net ID");
				pass = rs.getString("Password");
			}	
			if(user != null){
				if((user).equals(login.getUser()) && (NetId).equals(login.getNetid())
						&& (pass).equals(login.getPassword())) {
					return true;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String selectQuery1(logInSetGet login){
		String SqlQuery;
		if(("Student").equals(login.getUser()))
			SqlQuery = "select * from registration where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		else if(("Faculty").equals(login.getUser()))
			SqlQuery = "select * from faculty where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		else
			SqlQuery = "select * from staff where `Net ID`='"+login.getNetid()+"' and Password='"+login.getPassword()+"' and User='"+login.getUser()+"'";
		String fullName = null;
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(SqlQuery);
			
			String fname = null;
			String lname = null;
			if(rs.next()){
				fname = rs.getString("First Name");
				lname = rs.getString("Last Name");
				fullName = fname+" "+lname;
			}	
			
			return fullName;
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return fullName;
	}
}
